package com.companimal.semiProject.order.controller;

import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import com.companimal.semiProject.order.model.dto.OrderRewardInfoDTO;
import com.companimal.semiProject.order.model.service.OrderService;
import com.companimal.semiProject.project.model.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orderPayment") // 메인 페이지에서 주문 결제 화면으로 넘어오면 값들이 화면에 출력한다
    public String orderPaymentPage(Model model, ProjectDTO project, Authentication authentication) {

        System.out.println(project);

//        List <OrderRewardInfoDTO> orderRewardInfoDTOS = orderService.findRewardInfo(authentication.getName());
//        List <CouponDTO> couponDTO = orderService.couponInfo(authentication.getName());
//        List <MemberDTO> memberDTO = orderService.memberInfo(authentication.getName());
//
//        model.addAttribute("rewardInfo", orderRewardInfoDTOS);
//        model.addAttribute("couponInfo", couponDTO);
//        model.addAttribute("memberInfo", memberDTO);
////        model.addAttribute("orderAmount", orderAmount); // 옵션 수량
////        model.addAttribute("orderCode", orderCode);     // 주문 코드
//        orderService.showAllInfo(model);
        return "contents/order/orderpayment";
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