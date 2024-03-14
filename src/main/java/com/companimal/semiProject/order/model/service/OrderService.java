package com.companimal.semiProject.order.model.service;

import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import com.companimal.semiProject.order.model.dto.OrderRewardInfoDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface OrderService {
    void showAllInfo(Model model);

    List<OrderRewardInfoDTO> findRewardInfo(String name); // 리워드 정보

    List<CouponDTO> couponInfo(String name);              // 쿠폰 정보

    List<MemberDTO> memberInfo(String name);              // 멤버 정보

    @Transactional
    int updatePurchaseConfirm(String orderCode);

}
