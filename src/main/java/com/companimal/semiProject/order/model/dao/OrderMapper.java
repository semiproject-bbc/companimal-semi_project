package com.companimal.semiProject.order.model.dao;

import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

//    List<OrderRewardInfoDTO> findRewardInfo();

    CouponDTO findCouponInfo(String memId);

    MemberDTO findMemberInfo(String memId);

    CouponDTO getCouponInfo(String memId);

    void insertOrderPaymentInfo(OrderPaymentDTO orderPaymentDTO);
}
