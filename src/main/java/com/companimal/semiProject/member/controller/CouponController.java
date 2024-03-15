package com.companimal.semiProject.member.controller;

import com.companimal.semiProject.member.model.service.CouponService;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CouponController {

    private final CouponService couponService;


    @Autowired
    public CouponController (CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/coupon")
    public String couponPage(Model model, Authentication authentication) {

        CouponDTO coupon = couponService.getCouponInfo(authentication.getName());
        model.addAttribute("coupon", coupon);
        return "contents/member/supportercoupon";
    }

}
