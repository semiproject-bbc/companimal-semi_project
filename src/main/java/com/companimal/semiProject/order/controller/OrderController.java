package com.companimal.semiProject.order.controller;

import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import com.companimal.semiProject.order.model.dto.GetOrderDetailsInfoDTO;
import com.companimal.semiProject.order.model.service.OrderService;
import com.companimal.semiProject.project.model.dto.ProjectRewardDTO;
import com.companimal.semiProject.project.model.dto.ProjectRewardOptDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final HttpSession httpSession;

    @Autowired
    public OrderController(OrderService orderService, HttpSession httpSession) {
        this.orderService = orderService;
        this.httpSession = httpSession;
    }

//    @PostMapping("/orderPayment") // 메인 페이지에서 주문 결제 화면으로 넘어오면 값들이 화면에 출력한다
//    public String orderPaymentPage(Model model,
//                                   @ModelAttribute GetOrderDetailsInfoDTO getOrderDetailsInfoDTO,
//                                   Authentication authentication) {
//////        List<ProjectRewardOptDTO> projectRewardOptDTOList = ProjectRewardDTO
////
//        CouponDTO couponDTO = orderService.couponInfo(authentication.getName()); // memId에 맞는 coupon 정보들을 가져한다
//        MemberDTO memberDTO = orderService.memberInfo(authentication.getName()); // memId에 맞는 member 정보들을 가져온다
//////
//////        // 결제화면에서 결제 성공시 DB에서 정보를 저장을 할 수 있겠금 정보를 session에 담는다
//////        httpSession.setAttribute("rewardInfo", getOrderDetailsInfoDTO);
//////        httpSession.setAttribute("couponInfo", couponDTO);
//////        httpSession.setAttribute("memberInfo", memberDTO);
//////
//////        // 받은 정보들을 화면에 띄우기 위해서 model에 set을 해서 th:each/ th:text로 출력을 한다
//////        model.addAttribute("rewardInfo", getOrderDetailsInfoDTO);
//        model.addAttribute("couponInfo", couponDTO);
//        model.addAttribute("memberInfo", memberDTO);
////
////        orderService.showAllInfo(model); // SELECT ... 필요없지 않나?
//        return "contents/order/orderpayment";
//    }

    @GetMapping("/orderpayment") // {memId}
    public String ontoOrderPaymentPage(Model model,
                                       Authentication authentication) {
        GetOrderDetailsInfoDTO getOrderDetailsInfoDTO = new GetOrderDetailsInfoDTO();


        CouponDTO couponDTO = orderService.couponInfo(authentication.getName()); // memId에 맞는 coupon 정보들을 가져한다
        MemberDTO memberDTO = orderService.memberInfo(authentication.getName()); // memId에 맞는 member 정보들을 가져온다

        model.addAttribute("couponInfo", couponDTO);
        model.addAttribute("memberInfo", memberDTO);
        {
            // Setting values for GetOrderDetailsInfoDTO
            getOrderDetailsInfoDTO.setProCode(123);  // Set project code
            getOrderDetailsInfoDTO.setNoOfOrder(2);  // Set order quantity
            getOrderDetailsInfoDTO.setOrderAmount(200000);  // Set total amount
            getOrderDetailsInfoDTO.setProName("Project X");  // Set project name

            // Creating a new ProjectRewardDTO object
            ProjectRewardDTO projectRewardDTO = new ProjectRewardDTO();
            projectRewardDTO.setRewCode("R001");  // Set reward code
            projectRewardDTO.setRewNum(1);        // Set reward number
            projectRewardDTO.setProCode(123);      // Set project code
            projectRewardDTO.setRewName("Reward 1");  // Set reward name
            projectRewardDTO.setRewExplain("Reward 1 Explanation");  // Set reward explanation
            projectRewardDTO.setRewSf(5000);          // 배송비

            // Creating a new ProjectRewardOptDTO object
            ProjectRewardOptDTO projectRewardOptDTO = new ProjectRewardOptDTO();
            projectRewardOptDTO.setRewOptCode("RO001");     // Set reward option code
            projectRewardOptDTO.setRewCode("R001");         // Set reward code
            projectRewardOptDTO.setRewOptNum(1);            // Set reward option number
            projectRewardOptDTO.setRewOptName("Option 1");  // Set option name
            projectRewardOptDTO.setRewOptVal("Value 1");    // Set option value
            projectRewardOptDTO.setRewOptLimit(10);         // Set option limit
            projectRewardOptDTO.setRewAmount(20);           // Set option amount

            // Adding ProjectRewardOptDTO to ProjectRewardDTO
            List<ProjectRewardOptDTO> rewardOptList = new ArrayList<>();
            rewardOptList.add(projectRewardOptDTO);
            projectRewardDTO.setRewardOpt(rewardOptList);

            // Adding ProjectRewardDTO to GetOrderDetailsInfoDTO
            List<ProjectRewardDTO> projectRewardDTOList = new ArrayList<>();
            projectRewardDTOList.add(projectRewardDTO);
            getOrderDetailsInfoDTO.setProjectRewardDTOList(projectRewardDTOList);

            // 정보가 다 GetOrderDetailsInfo에 저장이 되었다..!
            model.addAttribute("getOrderDetailsInfoDTO", getOrderDetailsInfoDTO);
        }
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

        return "redirect:selectPurchaseStatus";
      
    }

}