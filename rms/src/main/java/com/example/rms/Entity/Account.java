package com.example.rms.Entity;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer account_id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_roles",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles = new HashSet<>();
    private String username;
    private String fullname;
    private Date date_range;
    private Integer group_id;
    private Boolean sttus;
    private String password;
    private Integer class_id;

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getDate_range() {
        return date_range;
    }

    public void setDate_range(Date date_range) {
        this.date_range = date_range;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Boolean getSttus() {
        return sttus;
    }

    public void setSttus(Boolean sttus) {
        this.sttus = sttus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getPwdtoken() {
        return pwdtoken;
    }

    public void setPwdtoken(String pwdtoken) {
        this.pwdtoken = pwdtoken;
    }

    public String getVerification_email_token() {
        return verification_email_token;
    }

    public void setVerification_email_token(String verification_email_token) {
        this.verification_email_token = verification_email_token;
    }

    public Account(Integer account_id, Set<Role> roles, String username, String fullname, Date date_range, Integer group_id, Boolean sttus, String password, Integer class_id, String pwdtoken, String verification_email_token) {
        this.account_id = account_id;
        this.roles = roles;
        this.username = username;
        this.fullname = fullname;
        this.date_range = date_range;
        this.group_id = group_id;
        this.sttus = sttus;
        this.password = password;
        this.class_id = class_id;
        this.pwdtoken = pwdtoken;
        this.verification_email_token = verification_email_token;
    }

    private String pwdtoken;
    private String verification_email_token;

    public Account() {
    }


}