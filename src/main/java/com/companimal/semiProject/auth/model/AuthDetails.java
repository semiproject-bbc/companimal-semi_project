//package com.companimal.semiProject.auth.model;
//
//import com.companimal.semiProject.member.model.dto.LoginMemberDTO;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class AuthDetails implements UserDetails {
//
//    private LoginMemberDTO loginMemberDTO;
//
//    public AuthDetails() {
//    }
//
//    public AuthDetails(LoginMemberDTO loginMemberDTO) {
//        this.loginMemberDTO = loginMemberDTO;
//    }
//    public LoginMemberDTO getMemberDTO() {
//        return loginMemberDTO;
//    }
//
//    public void setMemberDTO(LoginMemberDTO loginMemberDTO) {
//        this.loginMemberDTO = loginMemberDTO;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
