package com.companimal.semiProject.order.controller;

import com.companimal.semiProject.order.model.service.OrderService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log
@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //
//    @Autowired
//    public OrderController(OrderService orderService) {
//        this.orderService = orderService;
//    }

//    @GetMapping // main page로 가기
//    public String mainPage() {
//        return "index";
//    }

    @GetMapping("/orderpayment") // 주문 결제 페이지로 이동
    public String goOrderPaymentPage(/*@RequestParam int memName,
                                     @RequestParam String memEmail,
                                     @RequestParam int memPhone,
                                     @RequestParam int finalPay,
                                     @RequestParam String rewName,
                                     @RequestParam String proName,
                                     @RequestParam int orderAmount,
                                     @RequestParam int couAmount*/) {
        return "/content/order/orderpayment";
    }

    @RequestMapping("/first") // 첫번째 약관동의
    public String firsttNcPage() {
        return "content/order/TermsAndConditions/first";
    }

    @RequestMapping("/second") // 두번째 약관동의
    public String secondtNcPage() {
        return "content/order/TermsAndConditions/second";
    }

    @RequestMapping("/third") // 세번째 약관동의
    public String thirdtNcPage() {
        return "content/order/TermsAndConditions/third";
    }

    @RequestMapping("/fourth") // 네번째 약관동의
    public String fourthtNcPage() {
        return "content/order/TermsAndConditions/fourth";
    }

//    @GetMapping("/index") // test
//    public String getIndexPage() {
//        return "index"; // orderpayment page으로 이동이 되는지 확인할 것
//    }

//    @PostMapping("/orderpayment")
//    public String sendOrderDetails (ModelAndView mv, @ModelAttribute OrderPaymentDTO orderPaymentDTO, @RequestParam String recipient, @RequestParam String address, @RequestParam String request) {
//        orderPaymentDTO.setAddress(address);
//        orderPaymentDTO.setRecipient(recipient);
//        orderPaymentDTO.setRequest(request);
//
//        orderService.rewDeliverInfo(orderPaymentDTO);
//
//        return "/content/order/orderpayment";
//    }



//    @GetMapping("/orderpayment")
//    public String TermsAndConditions() {
//        return "/content/order/TermsAndConditions/first";
//    }
    // 프로젝트명, 리워드명, 갯수, 쿠폰 할인, 주문 금액

//    @GetMapping("/orderpayment")
//    public String firstTermsAndCondition() {
//
//        if() {
//            return "/content/order/TermsAndConditions/first";
//        } else if () {
//            return "/content/order/TermsAndConditions/second";
//        } else if () {
//            return "/content/order/TermsAndConditions/third";
//        } else {
//            return "/content/order/TermsAndConditions/fourth";
//        }
//    }

//    @GetMapping("/orderpayment")
//    public OrderPaymentDTO getDeliverInfo (@ModelAttribute OrderPaymentDTO orderPaymentDTO, @RequestParam String recipient, @RequestParam String request, @RequestParam String address) {
//        orderPaymentDTO.setRecipient(recipient);
//        orderPaymentDTO.setRequest(request);
//        orderPaymentDTO.setAddress(address);
//        return orderPaymentDTO;
//    }

//    public String getOrderOpt (@ModelAttribute OrderOpDTO orderOpDTO, @RequestParam int orderAmount) {
//        orderOpDTO.setOrderAmount(orderAmount);
//
//        return null;
//    }
//
//    @GetMapping("/orderpayment")
//    public String getDeliverInfo (@ModelAttribute OrderPaymentDTO orderPaymentDTO, @RequestParam String address, @RequestParam String recipient, @RequestParam String request, RedirectAttributes rttr /* 또 추가할 것..*/) {
//        orderPaymentDTO.setAddress(address);
//        orderPaymentDTO.setRecipient(recipient);
//        orderPaymentDTO.setRequest(request);
//
//        orderService.rewDeliverInfo(orderPaymentDTO);
//
//        rttr.addFlashAttribute("message", "배송 정보 저장 성공");
//        return "redirect:/order/orderconfirmation";
//    }

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