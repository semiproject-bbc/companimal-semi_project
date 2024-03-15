package com.companimal.semiProject.member.model.service;

import com.companimal.semiProject.order.model.dto.CouponDTO;
import org.springframework.stereotype.Service;

@Service
public interface CouponService {

    CouponDTO getCouponInfo(String memId);
}
