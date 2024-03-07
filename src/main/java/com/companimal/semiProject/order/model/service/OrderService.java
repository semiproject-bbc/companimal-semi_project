package com.companimal.semiProject.order.model.service;

import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    public void rewDeliverInfo(OrderPaymentDTO orderPaymentDTO);
}
