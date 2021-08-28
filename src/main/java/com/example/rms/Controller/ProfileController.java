package com.example.rms.Controller;

import com.example.rms.Entity.Profile;
import com.example.rms.Repositories.ProfileRepository;
import com.example.rms.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private ProfileRepository profileRepositor;
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int Create(@RequestBody Profile profile) {
        profileService.save(profile);
        return profile.getProfile_id();
    }
    @GetMapping(value = "all",  params = {"page", "size", "search"})
    public ResponseEntity<Page<Profile>> getAll(@RequestParam("page") int page,
                                                @RequestParam("size") int size,
                                                @RequestParam("search") String search)
    {
        try {
            Page<Profile> list = profileRepositor.findAllByNameContainingOrderByCreateDateDesc(PageRequest.of(page, size),search);
            return  new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<Profile> Findallbyid(@PathVariable Integer id) {
        try {
            Optional<Profile> profiles =  profileService.findAllbyID(id);
            return new ResponseEntity(profiles, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?>Edit(@RequestBody Profile profile, @PathVariable Integer id ){
        try{
            Profile profile1 = profileService.findAllbyID(id).get();
            profile1.setBirthday(profile.getBirthday());
            profile1.setAddress(profile.getAddress());
            profile1.setImage(profile.getImage());
            profile1.setEmail(profile.getEmail());
            profile1.setGroup_obj(profile.getGroup_obj());
            profile1.setHobby(profile.getHobby());
            profile1.setName(profile.getName());
            profile1.setPrCandidate(profile.getPrCandidate());
            profile1.setPhone(profile.getPhone());
            profileService.save(profile1);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping( value = "/deletebyid/{id}", method = RequestMethod.DELETE)
    public  void Delete(@PathVariable Integer id){
        profileService.deletebyid(id);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void Upload(@RequestBody MultipartFile multipart) throws IOException {
//        Profile profile =  profileService.findAllbyID(id).get();
//        profile.setImage(url);
//        profileService.save(profile);
        System.out.println(multipart);
//        String uploadDir = "C:/41" + multipart.getName();
//        saveFile(uploadDir,multipart.getName(),multipart);
    }
    public void saveFile(String uploadDir, String fileName,
                                    MultipartFile multipartFile) throws IOException {
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            try (InputStream inputStream = multipartFile.getInputStream()) {
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ioe) {
                throw new IOException("Could not save image file: " + fileName, ioe);
            }
        }
}
