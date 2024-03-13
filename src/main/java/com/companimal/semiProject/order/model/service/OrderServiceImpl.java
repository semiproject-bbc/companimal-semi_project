package com.companimal.semiProject.order.model.service;

import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dao.OrderMapper;
import com.companimal.semiProject.order.model.dto.CouponDTO;
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


//    @Override
//    public List<OrderRewardInfoDTO> findRewardInfo() {
//        return orderMapper.findRewardInfo();
//    }
//
//    @Override
//    public List<CouponDTO> couponInfo() {
//        return orderMapper.findCouponInfo();
//    }
//
//    @Override
//    public List<MemberDTO> memberInfo() {
//        return orderMapper.findMemberInfo();
//    }

    @Override
    public void showAllInfo(Model model) {}

    @Override
    public List<OrderRewardInfoDTO> findRewardInfo(String name) {
        return orderMapper.findRewardInfo();
    }

    @Override
    public List<CouponDTO> couponInfo(String name) {
        return orderMapper.findCouponInfo();
    }

    @Override
    public List<MemberDTO> memberInfo(String name) {
        return orderMapper.findMemberInfo();
    }

    @Override
    public int updatePurchaseConfirm(String orderCode) {
        int result = OrderMapper.updatePurchaseConfirm(orderCode);

        return result;
    }

}

