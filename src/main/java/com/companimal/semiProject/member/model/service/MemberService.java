package com.companimal.semiProject.member.model.service;

import com.companimal.semiProject.member.model.dao.MemberMapper;
import com.companimal.semiProject.member.model.dto.LoginMemberDTO;
import com.companimal.semiProject.member.model.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public int registMember(MemberDTO memberDTO) {

        memberDTO.setMemberPwd(passwordEncoder.encode(memberDTO.getMemberPwd()));

        int result = 0;
        try {
            result = memberMapper.registMember(memberDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public LoginMemberDTO findByMembername(String memberId) {

        LoginMemberDTO login = memberMapper.findByMemberName(memberId);


        if (!Objects.isNull(login)) {

            return login;
        } else {

            return null;
        }
    }
}
