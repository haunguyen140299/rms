package com.example.rms.Controller;

import com.example.rms.Entity.*;
import com.example.rms.Repositories.AccountRepository;
import com.example.rms.Repositories.RoleRepository;
import com.example.rms.Services.AccountService;
import com.example.rms.Services.ClassesService;
import com.example.rms.Services.GroupService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.*;

import static com.example.rms.Entity.ERole.*;

/**
 * author: ManhHoang
 * Tạo các api
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/account")
public class AccountController {
    @Autowired
    GroupService groupService;
    @Autowired
    AccountService accountService;
    @Autowired
    ClassesService classesService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Api tạo mới account
     *
     * @return
     */
    @RequestMapping(value="/create", method = RequestMethod.POST)
    public  int create(@RequestBody Account account) {
        Account ac = accountService.findaccountbyemail(account.getUsername());
        if(ac == null){
            Date currentUtilDate = new Date();
            account.setDate_range(currentUtilDate);
            account.setPassword(passwordEncoder.encode(account.getPassword()));
            Role role = roleRepository.findByName(student);
            switch (account.getGroup_id()) {
                case 1:
                    role = roleRepository.findByName(student);
                    break;
                case 2:
                    role = roleRepository.findByName(teacher);
                    break;
                case 3:
                    role = roleRepository.findByName(dlead);
                    break;
                case 4:
                    role = roleRepository.findByName(mentor);
                    break;
                case 5:
                    role = roleRepository.findByName(admin);
                    break;
                default:
                    role = roleRepository.findByName(management);
                    break;
            }
            System.out.println(role);
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            account.setRoles(roles);
            account.setSttus(true);
            accountService.save(account);
            return 1;
        }
        else{
            return 2;
        }
    }
    /**
     * Api Checkemail
     *
     * @return
     */
    @RequestMapping(value = "/checkemail", method = RequestMethod.POST)
    public Account checkemail(@RequestBody String email) throws MessagingException, UnsupportedEncodingException {
        Account account= accountService.findaccountbyemail(email);
        if(account == null){
            return account;
        }else{
            String token = RandomString.make(50);
            account.setPwdtoken(token);
            sendEmailtoresetpassword(email,token);
            accountService.save(account);
            return account;
        }
    }
    public String sendEmailtoresetpassword(String email, String token) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        String url = "http://localhost:4200/givepassword/"+ token;
        helper.setFrom("manhht_tts@rikkeisoft.com", "Yeu cau cap lai mat khau");
        helper.setTo(email);

        String subject1 = "Yeu cau cap lai mat khau:";

        String content = "<div class=\"container\" style=\"width: 540px;height: 348px;top: 276px;left: 420px\">\n" +
                "  <h1 style=\"color: blue;width: 288px;height: 24px;top: 316px;margin-left: 170px;margin-bottom: 35px; font-size: 15px\">RTEP MANAGEMENT SYSTEM</h1>\n" +
                "\n" +
                "  <label>Bạn vừa yêu cầu lấy mật khẩu trên <b>RMS</b>. Để lấy lại mật khẩu bạn vui lòng click vào đường link bên dưới:</label>\n" +
                "\n" +

                "  <a class=\"image-seach\" style=\"margin-left: 390px\" >\n" +
                "    <img src=\"https://i.imgur.com/4atzShz.png\" style=\"margin-top: 100px\"/>\n" +
                "\n" +
                "  </a>\n" +
                "</div>\n>"
                +url;
        helper.setSubject(subject1);

        helper.setText(content, true);

        mailSender.send(message);

        return "gửi thành công";
    }

    /**
     * Api xóa account
     *
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        accountService.deletebyid(id);
    }
    /**
     * Api lấy tất cả danh sách
     *
     * @return
     */
    @GetMapping("/all")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    /**
     * Api : Thêm người dùng theo nhóm đối tượng
     * Tạo các api
     */
    @GetMapping("/group")
    public List<Group> findallgroup() {
        return groupService.findAll();
    }
    /**
     * Api : Thêm người dùng theo Lớp
     * Tạo các api
     */
    @GetMapping("/classes")
    public List<Classes> findallclass() {
        return classesService.findAll();
    }
    /**
     * Api lấy theo Id
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable Integer id) {
        try {
            Account ac = accountService.findByID(id).get();
            return new ResponseEntity<Account>(ac, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getaccnamebyid/{id}")
    public Object getaccnamebyid(@PathVariable Integer id) {
        return accountService.getaccnamebyid(id);
    }

    /**
     * Api Update User
     *
     * @param act
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Account act, @PathVariable Integer id) {
        try {
            Account acctt = accountService.findByID(id).get();
            acctt.setFullname(act.getFullname());
            acctt.setUsername(act.getUsername());
            acctt.setGroup_id(act.getGroup_id());
            acctt.setClass_id(act.getClass_id());
            acctt.setSttus(act.getSttus());
            accountService.save(acctt);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Api Update password
     *
     * @param act
     * @param id
     * @return
     */
    @PutMapping("/pwd/{id}")
    public ResponseEntity<?> updatepwd(@RequestBody Account act, @PathVariable Integer id) {
        try {
            Account acctt = accountService.findByID(id).get();
            acctt.setPassword(act.getPassword());
            accountService.save(acctt);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Api verify token
     *
     * @param
     * @param
     * @return
     */

    @PostMapping("/verification/{token}")
    public void verification(@RequestBody String pwd, @PathVariable String token) {
        Account account = accountRepository.findByToken(token);
        account.setPassword(pwd);
        accountRepository.save(account);
    }
    /**
     * Api Phân trang
     *
     * @param
     * @param
     * @return
     */
    @GetMapping(value = "/paging",  params = {"page", "size", "search"})
    public ResponseEntity<Page<Account>> getAll(@RequestParam("page") int page,
                                                @RequestParam("size") int size,
                                                @RequestParam("search") String search)
    {
        try {
            Page<Account> list = accountRepository.findAllByFullnameContaining(PageRequest.of(page, size),search);
            return  new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    /** API lấy học sinh theo id đánh giá */
    @RequestMapping(value = "/liststudent/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> listaccountbyidevaluation(@PathVariable int id){
        List<Account> accounts = accountService.findAllaccountbyIDevaluation(id);
        if (accounts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    /** API lấy người đánh giá theo id đánh giá */
    @RequestMapping(value = "/listassessor/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> listassessorbyidevaluation(@PathVariable int id){
        List<Account> accounts = accountService.findAllassessorbyIDevaluation(id);
        if (accounts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/allnotstudent")
    public List<Account> findAllnotstudent() {
        return accountService.findAllnotstudent();
    }

    /** API lấy lớp theo id đánh giá */
    @RequestMapping(value = "/countclassbyid/{id}", method = RequestMethod.GET)
    public int countclassbyid(@PathVariable int id){
        int classe = accountService.countclassbyid(id);
        return classe;
    }

    @RequestMapping(value = "/getnameclassofaccount/{id}", method = RequestMethod.GET)
    public Object getnameclassofaccount(@PathVariable int id){
        return accountService.getnameclassofaccount(id);
    }
}
