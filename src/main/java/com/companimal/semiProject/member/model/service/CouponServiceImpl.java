package com.companimal.semiProject.member.model.service;

import com.companimal.semiProject.order.model.dao.OrderMapper;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {

    private final OrderMapper orderMapper;
    public CouponServiceImpl (OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    @Override
    public CouponDTO getCouponInfo(String memId) {
        return orderMapper.getCouponInfo(memId);
    }
}
