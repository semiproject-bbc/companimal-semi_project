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

    @GetMapping("/findId")
    public String findId() {
        return "/contents/member/findId";
    }

    @PostMapping("/findId")
    public ModelAndView findId(@RequestParam("memName") String memName, ModelAndView modelAndView) {
        String memId = memberService.selectMemId(memName);

        System.out.println(memId);
        // 이름으로 검색된 아이디가 있으면 성공 화면, 없으면 실패화면으로 보냄
        if (memId == null) {
            modelAndView.setViewName("/contents/member/findIdFail");
        } else {
                modelAndView.addObject("memId", memId);
            modelAndView.setViewName("/contents/member/findIdSuccess");
        }

        return modelAndView;
    }

    @GetMapping("/findPassword")
    public String findPassword() {
        return "/contents/member/findPassword";
    }

    @ResponseBody
    @PostMapping("/registeredEmailCheckByName")
    public boolean registeredEmailCheckByName(@RequestParam("email") String email, @RequestParam("memName") String name) {

        boolean registeredCheck = false;

        String registeredEmail = memberService.registeredEmailCheckByName(name);

        // 해당 이름으로 검색된 email이 있다면 입력한 이메일과 비교해서 일치하면 true값 전달
        if (registeredEmail != null) {
            if (email.equals(registeredEmail)) {
                registeredCheck = true;
            }
        }

        return registeredCheck;
    }

    @ResponseBody
    @PostMapping("/registeredEmailCheckById")
    public boolean registeredEmailCheck(@RequestParam("email") String email, @RequestParam("memberId") String memberId) {

        boolean registeredCheck = false;


        String registeredEmail = memberService.registeredEmailCheckById(memberId);
        // 해당 id로 검색된 email이 있다면 입력한 이메일과 비교해서 일치하면 true값 전달
        if (registeredEmail != null) {
            if (email.equals(registeredEmail)) {
                registeredCheck = true;
            }
        }

        return registeredCheck;
    }

    @PostMapping("/findPasswordResetPassword")
    public String passwordReset(@ModelAttribute MemberDTO memberDTO) {


        System.out.println("getId: " + memberDTO.getMemberId());
        System.out.println("getPwd: " + memberDTO.getMemberPwd());

        memberService.UpdatePassword(memberDTO);

        return "/auth/login";
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

        int result = memberService.updatePurchaseConfirm(orderCode);

        if(result > 0) {
            System.out.println("구매 확정 완료");
        }else {
            System.out.println("구매 확정 실패");
        }

        return "redirect:/participateProject";

    }

    @GetMapping("/mypage/ongoingProject")
    public String ongoingPage() {
        return "/contents/member/mypage/ongoingProject";
    }

//    @RequestMapping("/selectProjectOrder/${orderCode}")
//    public String selectProjectOrder(@RequestParam("orderCode") String orderCode, Model model) {
//
//
//        return "contents/member/supportProject";
//
//    }

}
