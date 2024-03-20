package com.companimal.semiProject.kakaoPay.controller;

import com.companimal.semiProject.kakaoPay.service.KakaoPay;
import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import com.companimal.semiProject.order.model.dto.GetOrderDetailsInfoDTO;
import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;
import com.companimal.semiProject.order.model.service.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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


//    @GetMapping //localhost:8080
//    public String helloworld() {
//        return "main";
//    }

//    @GetMapping("/pay")
//    public String kakaoPayGet() {
//        return "kakaoPay"; // kakaopay Page으로 이동
//    }

    /* test용 */
//    @GetMapping("/ontoKakaoPayPage")
//    public String ontoKakaoPayPage() {
//        log.info("kakaoPay 결제화면으로 이동함");
//
//        return "redirect:" + kakaopay.kakaoPayReady(); // kakaopay 결제 화면으로 이동
//        // http://localhost:8080/kakaoPaySuccess?pg_token=ee334b6d479d0c10260a
//    }


    @PostMapping("/ontoKakaoPayPage") /* 주문결제 */
    public String kakaoPay(@RequestParam("recipient") String recipient,
                           @RequestParam("address") String address,
                           @RequestParam("request") String request,
                           @RequestParam(value = "couponCode", required = false) String couponCode, // couponCode를 안받아도 된다
                           @RequestParam("totalAmount") int totalAmount) {

        System.out.println("받은 쿠폰코드 : " + couponCode); // couponCode를 잘 받았는지 확인용
        System.out.println("받은 최종 결제 금액 : " + totalAmount); // 결제 최종 금액
        httpSession.setAttribute("usedCouponCode", couponCode); // 잘 받았으면 session에다가 담는다
        httpSession.setAttribute("totalAmount", totalAmount);   // 배송비, 쿠폰 할인을 포함한 최종 결제 금액


//        System.out.println(name);
        /* 결제할 때 정보를 입력을 하기 위해서 담는다 */
        httpSession.setAttribute("recipient", recipient);
        httpSession.setAttribute("address", address);
        httpSession.setAttribute("request", request);

        // user가 선택한 couponCode 값을 session에다가 setting 해놓는다

        /* 잘 넘어가는지 확인 */
        log.info("kakaoPay 결제화면으로 이동함");

        return "redirect:" + kakaopay.kakaoPayReady(); // kakaopay 결제 화면으로 이동
        // http://localhost:8080/kakaoPaySuccess?pg_token=ee334b6d479d0c10260a
    }


    @GetMapping("/kakaoPaySuccess")
    public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model, Authentication authentication) {

        log.info("kakaoPaySuccess get");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));

        model.addAttribute("partner_order_id", httpSession.getAttribute("partner_order_id"));

        // 결제 성공시 시간을 정해줘야 한다
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 현시간을 출력한다
        LocalDateTime currentTime = LocalDateTime.now();

        // Format the current time using the formatter
        String formattedTime = currentTime.format(formatter);

        // Convert the formatted time to a Timestamp
        Timestamp timestamp = Timestamp.valueOf(formattedTime);

        // 시간을 원하는 형식으로 format을 한다

        // 확인용
        System.out.println("Current Date and Time: " + formattedTime);
        model.addAttribute("orderedTime", formattedTime);
        model.addAttribute("member", authentication.getName());

        /* 주문결제를 하면서 선택한 값들을 출력 */
        MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("memberInfo");
        GetOrderDetailsInfoDTO getOrderDetailsInfoDTO = (GetOrderDetailsInfoDTO) httpSession.getAttribute("rewardInfo");
        OrderPaymentDTO orderPaymentDTO = new OrderPaymentDTO();
        /* 결제까지 다 성공을 했을 때 DB에다가 저장 */
        orderPaymentDTO.setOrderCode((String) httpSession.getAttribute("partner_order_id"));     // 주문 코드
        orderPaymentDTO.setOrderDate(timestamp);         // 주문일시
        orderPaymentDTO.setMemId(memberDTO.getMemberId());                                          // 회원id
        orderPaymentDTO.setAddress((String) httpSession.getAttribute("address"));                // 주소
        orderPaymentDTO.setRequest((String) httpSession.getAttribute("request"));                // 배송 시 요청 사항
        orderPaymentDTO.setRecipient((String) httpSession.getAttribute("recipient"));            // 수취인명
        orderPaymentDTO.setFinalPay((int) httpSession.getAttribute("totalAmount"));              // 총 금액
        orderPaymentDTO.setProCode(getOrderDetailsInfoDTO.getProCode());                            // 프로젝트 코드
        orderPaymentDTO.setCouCode((String) httpSession.getAttribute("usedCouponCode"));         // 사용한 쿠폰 코드
//        orderPaymentDTO.setPurchaseStatus(); // not null 이기 때문에 나중에 정한다

        System.out.println(orderPaymentDTO); // 확인용
        orderService.setOrderPaymentInfo(orderPaymentDTO); // 받은 값들을 저장을 하기 위해서 data 정보들을 보낸다..!
        /* 결제가 완료 됐으면, 사용한 coupon의 사용여부를 'n'로 바꿔야한다*/
        orderService.updateUsedCoupon((String) httpSession.getAttribute("usedCouponCode"));
        System.out.println(httpSession.getAttribute("usedCouponCode"));
        // 결제 성공 화면으로 이동


        return "contents/order/successPage";
    }
    @RequestMapping("kakaoPayCancel")
    public String kakaoPayFail() {
        return "contents/order/failedPage";
    }
}
