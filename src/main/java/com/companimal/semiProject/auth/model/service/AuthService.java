//package com.companimal.semiProject.auth.model.service;
//
//import com.companimal.semiProject.auth.model.AuthDetails;
//import com.companimal.semiProject.member.model.dto.LoginMemberDTO;
//import com.companimal.semiProject.member.model.service.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Objects;
//
//@Service
//public class AuthService implements UserDetailsService {
//
//    @Autowired
//    private MemberService memberService;
//
//    @Override
//    public UserDetails loadUserByUsername(String membername) throws UsernameNotFoundException {
//        LoginMemberDTO login = memberService.findByMembername(membername);
//        if (Objects.isNull(login)) {
//            throw new UsernameNotFoundException("해당하는 회원 정보가 존재하지 않습니다.");
//        }
//
//        return new AuthDetails(login);
//    }
//}
