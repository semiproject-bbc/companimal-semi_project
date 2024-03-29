package com.companimal.semiProject.order.model.service;

import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dao.OrderMapper;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;
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
    public List<CouponDTO> couponInfo(String memId) {
        return orderMapper.findCouponInfo(memId);
    }

    @Override
    public MemberDTO memberInfo(String memId) {
        return orderMapper.findMemberInfo(memId);
    }

    @Override
    public void setOrderPaymentInfo(OrderPaymentDTO orderPaymentDTO) {
        orderMapper.setOrderPaymentInfo(orderPaymentDTO);
    }

    @Override
    public void updateUsedCoupon(String couCode) {
        orderMapper.updateUsedCoupon(couCode);
    }

    @Override
    public void updateEstRate(int proCode, int totalPrice) {
        orderMapper.updateEstRate(proCode, totalPrice);
    }

}

