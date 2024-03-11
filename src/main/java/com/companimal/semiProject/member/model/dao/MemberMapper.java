package com.companimal.semiProject.member.model.dao;

import com.companimal.semiProject.member.model.dto.LoginMemberDTO;
import com.companimal.semiProject.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    int registMember(MemberDTO memberDTO);

    LoginMemberDTO findByMemberName(String memberId);

    int idDuplicateCheck(String id);
}
