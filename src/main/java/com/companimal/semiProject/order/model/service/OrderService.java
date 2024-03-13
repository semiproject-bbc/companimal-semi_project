package com.companimal.semiProject.order.model.service;

import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public interface OrderService {
    @Transactional
    int updatePurchaseConfirm(String orderCode);

//    void rewDeliverInfo(OrderPaymentDTO orderPaymentDTO);


}
