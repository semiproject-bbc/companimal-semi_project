package com.companimal.semiProject.kakaoPay.controller;


import com.companimal.semiProject.kakaoPay.service.KakaoPay;
import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import com.companimal.semiProject.order.model.dto.GetOrderDetailsInfoDTO;
import com.companimal.semiProject.order.model.dto.OrderDetailsDTO;
import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;
import com.companimal.semiProject.order.model.service.OrderService;
import com.companimal.semiProject.project.model.dto.ProjectRewardDTO;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

@Log
@Controller
public class KakaoPayController {

    private final KakaoPay kakaopay;
    private final HttpSession httpSession;
    private final OrderService orderService;

    @Autowired
    public KakaoPayController(KakaoPay kakaoPay, HttpSession httpSession, OrderService orderService) {
        this.kakaopay = kakaoPay;
        this.httpSession = httpSession;
        this.orderService = orderService;
    }

    @GetMapping("/kakaoPay")
    public String kakaoPayGet() {
        return "kakaoPay"; // kakaopay Page으로 이동
    }

    @GetMapping("/kakaoPayFail")
    public String kakaoPayFail() {
        return "kakaoPayFail";
    }

    @PostMapping("/kakaoPay")
    public String kakaoPay(@RequestParam("recipient") String recipient,
                           @RequestParam("address") String address,
                           @RequestParam("request") String request) {
        log.info("kakaoPay 결제화면으로 이동함"); // 확인용

        MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("memberInfo");
        GetOrderDetailsInfoDTO getOrderDetailsInfoDTO = (GetOrderDetailsInfoDTO) httpSession.getAttribute("rewardInfo");
        // 입력한 값들을 session에다가 담는다
        httpSession.setAttribute("recipient", recipient);
        httpSession.setAttribute("address", address);
        httpSession.setAttribute("request", request);

        return "redirect:" + kakaopay.kakaoPayReady(getOrderDetailsInfoDTO,memberDTO); // kakaopay 결제 화면으로 이동
        // http://localhost:8080/kakaoPaySuccess?pg_token=ee334b6d479d0c10260a
    }

    @RequestMapping("/kakaoPaySuccess") // 결제 완료 되기 때문에 여기서 DB 저장할 것
    public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
        log.info("kakaoPaySuccess get");
        log.info("kakaoPaySuccess pg_token : " + pg_token);

        OrderPaymentDTO orderPaymentDTO = new OrderPaymentDTO(); // 정보를 담기 위해서

        MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("memberInfo");
        GetOrderDetailsInfoDTO getOrderDetailsInfoDTO = (GetOrderDetailsInfoDTO) httpSession.getAttribute("rewardInfo");
        CouponDTO couponDTO = (CouponDTO) httpSession.getAttribute("couponInfo");

        orderPaymentDTO.setOrderCode((String) httpSession.getAttribute("franchiseNo"));  // 주문 코드
        orderPaymentDTO.setOrderDate(new Timestamp(System.currentTimeMillis()));            // 주문 일시
        orderPaymentDTO.setMemId(memberDTO.getMemberId());                                  // memberId
        orderPaymentDTO.setAddress((String) httpSession.getAttribute("address"));        // 주소
        orderPaymentDTO.setRequest((String) httpSession.getAttribute("request"));        // 배송 시 요청 사항
        orderPaymentDTO.setRecipient((String) httpSession.getAttribute("recipient"));    // 수취인명
        orderPaymentDTO.setFinalPay((int) httpSession.getAttribute("finalPay"));         // 최종 결제 금액
        orderPaymentDTO.setProCode(orderPaymentDTO.getProCode());                           // 프로젝트 코드
        orderPaymentDTO.setCouCode(couponDTO.getCouCode());                                 // 쿠폰 코드
//        orderPaymentDTO.setPurchaseStatus();                                              // 구매 확정 일시 아직 정하지 않음

        orderService.insertOrderPaymentInfo(orderPaymentDTO);

        return "/kakaoPaySuccess";
    }
}