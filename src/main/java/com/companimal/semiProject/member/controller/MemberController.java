package com.companimal.semiProject.member.controller;

import com.companimal.semiProject.member.model.dto.InquiryCateDTO;
import com.companimal.semiProject.member.model.dto.InquiryDTO;
import com.companimal.semiProject.member.model.dto.SupporterParticipatedProjectDTO;
import com.companimal.semiProject.member.model.service.CouponService;
import com.companimal.semiProject.member.model.service.DuplicateCheckService;
import com.companimal.semiProject.member.model.service.MailService;
import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.member.model.service.MemberService;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final MailService mailService;
    private final DuplicateCheckService duplicateCheckService;
    private final CouponService couponService;

    public MemberController(MemberService memberService, MailService mailService, DuplicateCheckService duplicateCheckService, CouponService couponService) {
        this.memberService = memberService;
        this.mailService = mailService;
        this.duplicateCheckService = duplicateCheckService;
        this.couponService = couponService;
    }

    @GetMapping("/regist")
    public String regist() {
        return "contents/member/regist";
    }

    @PostMapping("/regist")
    public ModelAndView regist(ModelAndView mv, @ModelAttribute MemberDTO memberDTO) {

        int result = memberService.registMember(memberDTO);

        String message = "";

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
    @GetMapping("/idDuplicateCheck")
    public Boolean idDuplicateCheck(@RequestParam("id") String id) {
        // DB에 입력한 아이디로 조회되는 결과가 있다면 true, 없다면 false를 반환
        return duplicateCheckService.idDuplicateCheck(id);
    }

    @ResponseBody
    @PostMapping("/sendEmail")
    public void sendEmail(@RequestParam("email") String email, HttpSession session) {

        // 회원가입 창에서 입력한 이메일 주소로 이메일을 보내기 위해 메일서비스에서 semdMail 메소드 호출
        // 인증번호 화인에 세션을 활용하기 위해 세션도 매개변수에 넣음
        mailService.sendMail(email, session);
    }

    @ResponseBody
    @PostMapping("/verifyEmail")
    public boolean verifyEmail(@RequestParam("email") String email, @RequestParam("authCode") String inputAuthCode, HttpSession session) {

        // 입력한 에메일 주소로 메일을 발송하면서 세션에 저장한 인증코드와 사용자가 입력한 인증코드를 비교
        // 세션에 저장된 값이 있고, 그 값이 입력한 인증번호와 같다면 true, 그렇지 않다면 false를 반환
        String authCode = (String) session.getAttribute(email);
        return authCode != null && authCode.equals(inputAuthCode);
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
    public String selectCouponList(Authentication authentication,
                                   Model model) {
        System.out.println("쿠폰 목록");

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

        if (result > 0) {
            System.out.println("구매 확정 완료");
        } else {
            System.out.println("구매 확정 실패");
        }

        return "redirect:/participateProject";
    }

    @GetMapping("/supporterProject")
    public String supporterProject(Authentication authentication,
                                   Model model) {
        List<SupporterParticipatedProjectDTO> supporterParticipatedProjectDTOList = memberService.getSupporterProject(authentication.getName());
        for (SupporterParticipatedProjectDTO supporterParticipatedProjectDTO : supporterParticipatedProjectDTOList) {
            System.out.println(supporterParticipatedProjectDTO);
        }
        model.addAttribute("orderInfo", supporterParticipatedProjectDTOList);

        return "contents/member/supporterProject";
    }

//    // test용
//    @GetMapping("/supporterInquiry")
//    public String successPage() {
//        System.out.println("successPage로 이동");
//        return "/contents/member/inquiredSubmitSuccess";
//    }


    @GetMapping("/supporterInquiryPage/{proCode}")
    public String supporterSendInquiry(@PathVariable("proCode") int proCode,
                                       HttpSession session) {
        session.setAttribute("proCode123", proCode);

        return "/contents/member/supporterInquiryPage";
    }

    @PostMapping("/supporterInquiry")
    public String SupporterInquiryConfirmationPage(/*@ModelAttribute InquiryCateDTO inquiryCateDTO,*/
                                                   @RequestParam("inputtedText") String inputtedText,
                                                   @RequestParam("inqCateCode") String inqCategoryCode,
                                                   Authentication authentication,
                                                   HttpSession session) {
//        int categoryCode = Integer.parseInt(inqCategoryCode.trim());
        int categoryCode = Integer.parseInt(inqCategoryCode.substring(2));
        System.out.println(inqCategoryCode); // 가져온 categoryCode 값
//        System.out.println(inquiryCateDTO.getInqCateName()); // 확인용
        System.out.println(inputtedText);                    // 확인용

//        model.addAttribute("inquiryDetails", inquiryCateDTO);
//        model.addAttribute("inquiryContext", inputtedText);

        /* 현재시간으로 timestamp으로 포맷하는 방식 */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentTime = LocalDateTime.now();        // 현시간을 출력한다
        String formattedTime = currentTime.format(formatter);   // 시간 포맷
        Timestamp timestamp = Timestamp.valueOf(formattedTime); // timestamp 방식으로 저장을 한다

        InquiryDTO inquiryDTO = new InquiryDTO();
        inquiryDTO.setMemId(authentication.getName());              // 회원ID
        inquiryDTO.setProCode((int)session.getAttribute("proCode123"));                             // 프로젝트 코드
        inquiryDTO.setInqContent(inputtedText);                     // 작성한 내용
        inquiryDTO.setInqDateTime(timestamp);                       // 문의한 시간
        // inquiryDTO.setInqAnswer();                               // 아직 미정
        inquiryDTO.setInqCateCode(categoryCode); // categoryCode

        memberService.setSupporterInquiredProject(inquiryDTO); // 저장이 잘 됐으면 성공 페이지로 이동한다
        return "/contents/member/inquiredSubmitSuccess";
    }


    @GetMapping("/mypage/ongoingProject")
    public String ongoingPage() {
        return "/contents/member/mypage/ongoingProject";
    }

    @RequestMapping("/mypage/coupon")
    public String couponPage() {
            return "/contents/member/supportercoupon";
    }

}
