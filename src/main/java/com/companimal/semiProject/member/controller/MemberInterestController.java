package com.companimal.semiProject.member.controller;

import com.companimal.semiProject.member.model.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberInterestController {

    private final MemberService memberService;

    public MemberInterestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/interest")
    public String supporterParticipate() {
        return "contents/member/supporterInterest";
    }




}
