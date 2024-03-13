package com.companimal.semiProject.order.model.service;

import com.companimal.semiProject.order.model.dao.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderMapper OrderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        OrderMapper = orderMapper;
    }

    @Override
    public int updatePurchaseConfirm(String orderCode) {
        int result = OrderMapper.updatePurchaseConfirm(orderCode);

        return result;
    }
}

