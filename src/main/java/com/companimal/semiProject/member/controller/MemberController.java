package com.companimal.semiProject.member.controller;

import com.companimal.semiProject.member.model.service.DuplicateCheckService;
import com.companimal.semiProject.member.model.service.MailService;
import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.member.model.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final MailService mailService;
    private final DuplicateCheckService duplicateCheckService;

    public MemberController(MemberService memberService, MailService mailService, DuplicateCheckService duplicateCheckService) {
        this.memberService = memberService;
        this.mailService = mailService;
        this.duplicateCheckService = duplicateCheckService;
    }

    @GetMapping("/regist")
    public String regist() {
        return "contents/member/regist";
    }

    @PostMapping("/regist")
    public ModelAndView regist(ModelAndView mv, @ModelAttribute MemberDTO memberDTO) {

        int result = memberService.registMember(memberDTO);

        String message ="";

        if (result > 0) {
            message = "회원가입이 정상적으로 완료되었습니다.";
            mv.setViewName("auth/login");
        } else {
            message = "회원가입에 실패하였습니다.";
            mv.setViewName("contents/member/regist");
        }

        mv.addObject("message", message);

        return mv;
    }

    @ResponseBody
    @PostMapping("/sendEmail")
    public void sendEmail(@RequestParam("email") String email, HttpSession session) {

        System.out.println(email);
        mailService.sendMail(email, session);
    }

    @ResponseBody
    @PostMapping("/verifyEmail")
    public boolean verifyEmail(@RequestParam("email") String email, @RequestParam("authCode") String inputAuthCode, HttpSession session) {
        String authCode = (String) session.getAttribute(email);
        return authCode != null && authCode.equals(inputAuthCode);
    }

    @ResponseBody
    @GetMapping("/idDuplicateCheck")
    public Boolean idDuplicateCheck(@RequestParam("id") String id) {
        int result = duplicateCheckService.idDuplicateCheck(id);
        boolean isDuplicate = true;

        if (result == 0) {
            isDuplicate = false;
        }

        return isDuplicate;
    }

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

    @RequestMapping("/participateProject")
    public String selectParticipate(Authentication authentication, Model model) {

        String id = authentication.getName();
        System.out.println("멤버DTO / 프로젝트DTO / 주문결제DTO -> 주문 코드가 존재하면 참여");

        List<MemberDTO> participateList = memberService.selectParticipate(id);
        System.out.println(participateList.toString());

        model.addAttribute("participateList", participateList);

        return "contents/member/supporterParticipate";
    }

    @ResponseBody
    @PostMapping("/updatePurchaseStatus")
    public String updatePurchaseConfirm(@RequestParam("orderCode") String orderCode) {

        System.out.println("😤😤😤😤😤😤😤😤😤😤😤😤😤😤😤😤😤😤😤😤😤😤😤😤");

        int result = memberService.updatePurchaseConfirm(orderCode);

        if(result > 0) {
            System.out.println("구매 확정 완료");
        }else {
            System.out.println("구매 확정 실패");
        }

        return "redirect:/participateProject";

    }

}
