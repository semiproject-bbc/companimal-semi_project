package com.companimal.semiProject.member.model.dao;

import com.companimal.semiProject.member.model.dto.InquiryDTO;
import com.companimal.semiProject.member.model.dto.LoginMemberDTO;
import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.member.model.dto.SupporterParticipatedProjectDTO;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    int registMember(MemberDTO memberDTO);

    LoginMemberDTO findByMemberName(String memberId);

    int idDuplicateCheck(String id);

    List<MemberDTO> selectParticipate(String id);

    int updatePurchaseConfirm(String orderCode);


    List<CouponDTO> getUsedCouponInfo(String memId);

    List<CouponDTO> getAvailableCouponInfo(String memId);

    List<CouponDTO> downloadCouponInfo(String memId);

    List<SupporterParticipatedProjectDTO> getSupporterProject(String memId);

    void setSupporterInquiredProject(InquiryDTO inquiryDTO);

    String selectMemId(String memName);

    String registeredEmailCheckByName(String name);

    String registeredEmailCheckById(String memId);

    boolean UpdatePassword(MemberDTO memberDTO);
}
