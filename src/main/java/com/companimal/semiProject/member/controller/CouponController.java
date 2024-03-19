package com.companimal.semiProject.member.controller;

import com.companimal.semiProject.member.model.service.CouponService;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class CouponController {

    private final CouponService couponService;

    @Autowired
    public CouponController (CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/coupon") // 쿠폰 페이지에서 정보를 출력을 하기 위해서이다
    public String couponPage(Model model, Authentication authentication) {

        System.out.println("잘 도착");
        /* 사용가능한 쿠폰들 호출 */
        List<CouponDTO> availableCouponList = couponService.getAvailableCouponInfo(authentication.getName());
        for (CouponDTO couponDTO : availableCouponList) {
            System.out.println(couponDTO);
        }
        /* 사용한 쿠폰들 호출 */
        List<CouponDTO> usedCouponList = couponService.getUsedCouponInfo(authentication.getName());
        for (CouponDTO couponDTO : usedCouponList) {
            System.out.println(couponDTO);
        }

        /* 다운 받을 쿠폰들 호출*/
//        List<CouponDTO> downloadCouponList = couponService.downloadCouponInfo(authentication.getName());
//        for (CouponDTO couponDTO : downloadCouponList) {
//            System.out.println(couponDTO);
//        }

        model.addAttribute("availableCoupon", availableCouponList);
        model.addAttribute("usedCoupon", usedCouponList);
//        model.addAttribute("downloadCoupon", downloadCouponList);

        System.out.println("쿠폰 페이지로 전송");
        return "contents/member/supportercoupon";
    }

    @PostMapping("/downloadCoupon")
    @ResponseBody
    public ResponseEntity<String> processCoupon(@RequestBody String couponCode) {
        System.out.println("받은 couCode : " + couponCode);

        System.out.println(couponCode);

        return ResponseEntity.ok("Coupon processed successfully");
    }
}