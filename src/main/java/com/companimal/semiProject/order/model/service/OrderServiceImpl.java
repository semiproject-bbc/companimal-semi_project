package com.companimal.semiProject.order.model.service;

import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dao.OrderMapper;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import com.companimal.semiProject.order.model.dto.OrderDetailsDTO;
import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;
import com.companimal.semiProject.order.model.dto.OrderRewardInfoDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    public OrderServiceImpl (OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    @Override
    public void showAllInfo(Model model) {}

    @Override
    public CouponDTO couponInfo(String memId) {
        return orderMapper.findCouponInfo(memId);
    }

    @Override
    public MemberDTO memberInfo(String memId) {
        return orderMapper.findMemberInfo(memId);
    }

    @Override
    public int updatePurchaseConfirm(String orderCode) {
        int result = orderMapper.updatePurchaseConfirm(orderCode);

        return result;
    }

    @Override
    public void insertOrderPaymentInfo(OrderPaymentDTO orderPaymentDTO) {
//        return orderMapper.insertOrderPaymentInfo(orderPaymentDTO);
    }
}

