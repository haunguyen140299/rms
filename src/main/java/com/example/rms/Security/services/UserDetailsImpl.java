package com.example.rms.Security.services;

import com.example.rms.Entity.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Hoang Tuan Manh
 **/
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Integer account_id;
    private String username;
    private  Boolean sttus;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Integer account_id, String username, Boolean sttus, String password, Collection<? extends GrantedAuthority> authorities) {
        this.account_id = account_id;
        this.username = username;
        this.sttus = sttus;
        this.password = password;
        this.authorities = authorities;
    }

    public Integer getId() {
        return account_id;
    }


    public static UserDetailsImpl build(Account account) {
        if (account.getSttus() == true) {
            List<GrantedAuthority> authorities = account.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                    .collect(Collectors.toList());

            return new UserDetailsImpl(
                    account.getAccount_id(),
                    account.getUsername(),
                    account.getSttus(),
                    account.getPassword(),
                    authorities);
        }
        return null;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(account_id, user.account_id);
    }
}
