//package com.companimal.semiProject.order.controller;
//
//import com.companimal.semiProject.order.model.dto.OrderOpDTO;
//import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;
//import com.companimal.semiProject.order.model.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@Controller
//@RequestMapping("/") // @RequestMapping (value = "hello")
//public class OrderController {
//
////    @Autowired
////    private final OrderService orderService;
////
////    public OrderController(OrderService orderService) {
////        this.orderService = orderService;
////    }
//
//    @GetMapping("/orderpayment") // 주문 결제 페이지로 이동
//    public String goOrderPaymentPage() {
//        return "content/order/orderpayment";
//    }
//
//    @GetMapping("/index") // test
//    public String getIndexPage() {
//        return "index"; // orderpayment page으로 이동이 되는지 확인할 것
//    }
//
////    @GetMapping("/orderpayment")
////    public OrderPaymentDTO getDeliverInfo (@ModelAttribute OrderPaymentDTO orderPaymentDTO, @RequestParam String recipient, @RequestParam String request, @RequestParam String address) {
////        orderPaymentDTO.setRecipient(recipient);
////        orderPaymentDTO.setRequest(request);
////        orderPaymentDTO.setAddress(address);
////        return orderPaymentDTO;
////    }
//
////    public String getOrderOpt (@ModelAttribute OrderOpDTO orderOpDTO, @RequestParam int orderAmount) {
////        orderOpDTO.setOrderAmount(orderAmount);
////
////        return null;
////    }
////
////    @GetMapping("/orderpayment")
////    public String getDeliverInfo (@ModelAttribute OrderPaymentDTO orderPaymentDTO, @RequestParam String address, @RequestParam String recipient, @RequestParam String request, RedirectAttributes rttr /* 또 추가할 것..*/) {
////        orderPaymentDTO.setAddress(address);
////        orderPaymentDTO.setRecipient(recipient);
////        orderPaymentDTO.setRequest(request);
////
////        orderService.rewDeliverInfo(orderPaymentDTO);
////
////        rttr.addFlashAttribute("message", "배송 정보 저장 성공");
////        return "redirect:/order/orderconfirmation";
////    }
//}