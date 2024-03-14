package com.companimal.semiProject.order.controller;

import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import com.companimal.semiProject.order.model.dto.OrderDetailsDTO;
import com.companimal.semiProject.order.model.dto.OrderRewardInfoDTO;
import com.companimal.semiProject.order.model.service.OrderService;
import com.companimal.semiProject.project.model.dto.ProjectDTO;
import com.companimal.semiProject.project.model.dto.ProjectRewardDTO;
import com.companimal.semiProject.project.model.dto.ProjectRewardOptDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final HttpSession httpSession;

    @Autowired
    public OrderController(OrderService orderService, HttpSession httpSession) {
        this.orderService = orderService;
        this.httpSession = httpSession;
    }

    @PostMapping("/orderPayment") // 메인 페이지에서 주문 결제 화면으로 넘어오면 값들이 화면에 출력한다
    public String orderPaymentPage(Model model,
                                   @ModelAttribute OrderDetailsDTO orderDetailsDTO,
                                   Authentication authentication) {

        CouponDTO couponDTO = orderService.couponInfo(authentication.getName()); // memId에 맞는 coupon 정보들을 가져한다
        MemberDTO memberDTO = orderService.memberInfo(authentication.getName()); // memId에 맞는 member 정보들을 가져온다

        httpSession.setAttribute("rewardInfo", orderDetailsDTO);
        httpSession.setAttribute("couponInfo", couponDTO);
        httpSession.setAttribute("memberInfo", memberDTO);

        model.addAttribute("rewardInfo", orderDetailsDTO);
        model.addAttribute("couponInfo", couponDTO);
        model.addAttribute("memberInfo", memberDTO);

        orderService.showAllInfo(model);
        return "contents/order/orderpayment";
    }

    @GetMapping("/orderpayment")
    public String ontoOrderPaymentPage() {
        return "/contents/order/orderpayment";
    }

    @ResponseBody
    @PostMapping("/updatePurchaseStatus")
    public String updatePurchaseConfirm(@RequestParam("orderCode") String orderCode) {

        int result = orderService.updatePurchaseConfirm(orderCode);

        if(result > 0) {
            System.out.println("구매 확정 완료");
        }else {
            System.out.println("구매 확정 실패");
        }

        return "redirect:participateProject";
    }
}