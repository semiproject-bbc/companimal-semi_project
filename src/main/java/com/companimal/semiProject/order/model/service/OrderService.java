package com.companimal.semiProject.order.model.service;

import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface OrderService {
    void showAllInfo(Model model);

    CouponDTO couponInfo(String memId);              // 쿠폰 정보

    MemberDTO memberInfo(String memId);              // 멤버 정보

    @Transactional
    int updatePurchaseConfirm(String orderCode);

    void setOrderPaymentInfo(OrderPaymentDTO orderPaymentDTO);

    void updateUsedCoupon(String couCode);
}
