package com.companimal.semiProject.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @RequestMapping("/mypage")
    public String showMypage() {
        System.out.println("마이페이지 확인");

        return "/contents/member/supportermypage";
    }

    @RequestMapping("/coupon")
    public String selectCouponList() {
        System.out.println("쿠폰 목록");

        return "contents/member/supportercoupon";
    }

    @RequestMapping("/profile")
    public String showProfile() {
        System.out.println("프로필 확인");

        return "contents/member/supporterProfile";
    }

    @RequestMapping("/noticecenter")
    public String showNoticecenter() {
        System.out.println("알림 센터");

        return "contents/member/noticecenter";
    }

}
