package com.companimal.semiProject.member.model.service;

import com.companimal.semiProject.order.model.dto.CouponDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CouponService {

    List<CouponDTO> getAvailableCouponInfo(String memId);

    List<CouponDTO> getUsedCouponInfo(String memId);

    List<CouponDTO> downloadCouponInfo(String memId);
}
