package com.companimal.semiProject.order.model.service;

import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface OrderService {

    List<CouponDTO> couponInfo(String memId);              // 쿠폰 정보

    MemberDTO memberInfo(String memId);              // 멤버 정보

    void setOrderPaymentInfo(OrderPaymentDTO orderPaymentDTO);

    void updateUsedCoupon(String couCode);

    void updateEstRate(int proCode, int totalPrice);
}
