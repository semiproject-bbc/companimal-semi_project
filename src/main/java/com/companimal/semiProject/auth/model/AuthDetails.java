package com.companimal.semiProject.auth.model;

import com.companimal.semiProject.member.model.dto.LoginMemberDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class AuthDetails implements UserDetails {

    private LoginMemberDTO loginMemberDTO;

    public AuthDetails(LoginMemberDTO loginMemberDTO) {
        this.loginMemberDTO = loginMemberDTO;
    }
    public LoginMemberDTO getloginMemberDTO() {
        return loginMemberDTO;
    }

    public void setMemberDTO(LoginMemberDTO loginMemberDTO) {
        this.loginMemberDTO = loginMemberDTO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        loginMemberDTO.getRole().forEach(role -> authorities.add(() -> role));

        return authorities;
    }

    @Override
    public String getPassword() {
        return loginMemberDTO.getMemberPwd();
    }

    @Override
    public String getUsername() {
        return loginMemberDTO.getMemberId();
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
}
