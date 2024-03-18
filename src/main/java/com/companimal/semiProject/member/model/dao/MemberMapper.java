package com.companimal.semiProject.member.model.dao;

import com.companimal.semiProject.member.model.dto.LoginMemberDTO;
import com.companimal.semiProject.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    int registMember(MemberDTO memberDTO);

    LoginMemberDTO findByMemberName(String memberId);

    int idDuplicateCheck(String id);

    List<MemberDTO> selectParticipate(String id);

    int updatePurchaseConfirm(String orderCode);

    String selectMemId(String memName);

    String registeredEmailCheckByName(String name);

    String registeredEmailCheckById(String memId);

    boolean UpdatePassword(MemberDTO memberDTO);
}
