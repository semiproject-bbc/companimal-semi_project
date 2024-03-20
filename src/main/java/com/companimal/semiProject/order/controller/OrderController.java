package com.companimal.semiProject.order.controller;

import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dto.CouponDTO;
import com.companimal.semiProject.order.model.dto.GetOrderDetailsInfoDTO;
import com.companimal.semiProject.order.model.dto.GetOrderOptionsInfoDTO;
import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;
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

    @PostMapping("/orderPayment")
    public String orderPaymentPage(Model model,
                                   @ModelAttribute GetOrderDetailsInfoDTO getOrderDetailsInfoDTO,
                                   @ModelAttribute GetOrderOptionsInfoDTO getOrderOptionsInfoDTOList,
                                   Authentication authentication) {

        System.out.println(getOrderDetailsInfoDTO);                                         // 확인용
        System.out.println(getOrderOptionsInfoDTOList);                                     // 확인용

        // form에서 받아온 값들을 process 해준다
        String[] sArr1 = getOrderOptionsInfoDTOList.getRewName().split(",");
        String[] sArr2 = getOrderOptionsInfoDTOList.getRewSf().split(",");
        String[] sArr3 = getOrderOptionsInfoDTOList.getRewOptCode().split(",");
        String[] sArr4 = getOrderOptionsInfoDTOList.getRewOptName().split(",");
        String[] sArr5 = getOrderOptionsInfoDTOList.getRewOptVal().split(",");
        String[] sArr6 = getOrderOptionsInfoDTOList.getRewAmount().split(",");
        String[] sArr7 = getOrderOptionsInfoDTOList.getNoOfOrder().split(",");

        // 각 옵션들의 정보들을 가져와서 묶는 코드
        List<GetOrderOptionsInfoDTO> realGetOrderOptionsInfoDTOList = new ArrayList<>();
        for(int i = 0; i < sArr1.length; i++) {
            GetOrderOptionsInfoDTO temp = new GetOrderOptionsInfoDTO(sArr1[i], sArr2[i], sArr3[i],sArr4[i], sArr5[i], sArr6[i], sArr7[i]);
            realGetOrderOptionsInfoDTOList.add(temp);
        }

        System.out.println(realGetOrderOptionsInfoDTOList);                                 // 확인용
        List<CouponDTO> couponDTO = orderService.couponInfo(authentication.getName());      // memId에 맞는 coupon 정보들을 가져한다
        MemberDTO memberDTO = orderService.memberInfo(authentication.getName());            // memId에 맞는 member 정보들을 가져온다

        List<CouponDTO> couponDTOList = orderService.couponInfo(authentication.getName());  // memId에 맞는 coupon 정보들을 가져한다
        for(CouponDTO couponDTO1 : couponDTOList) {
            System.out.println(couponDTO1);
        }

        /* 화면에 띄우기 위한 정보들 */
        model.addAttribute("rewardInfo", getOrderDetailsInfoDTO);               // 리워드 정보를 화면에 출력을 하기 위해서
        model.addAttribute("rewardOptInfo", realGetOrderOptionsInfoDTOList);    // 리워드 옵션 정보를 화면에 출력을 하기 위해서

        /* login 한 회원에 대한 정보들을 담았다 */
        model.addAttribute("couponInfo", couponDTOList);                        // coupon 정보를 화면에 출력을 하기 위해서
        model.addAttribute("memberInfo", memberDTO);                            // 회원 정보를 화면에 출력을 하기 위해서


        /* 결제화면에서 결제 성공시 DB에 담기 위해서 정보를 session에다가 담는다 */
        httpSession.setAttribute("rewardInfo", getOrderDetailsInfoDTO);                   // 리워드 정보를 session에 담음
        httpSession.setAttribute("rewardOptInfo", realGetOrderOptionsInfoDTOList);        // 리워드 옵션 정보를 session에 담음
        httpSession.setAttribute("couponInfo", couponDTO);                                // 쿠폰 정보를 session에 담음
        httpSession.setAttribute("memberInfo", memberDTO);                                // 회원 정보를 session에 담음

        System.out.println("주문 결제화면으로 이동");                                              // 확인용

        return "contents/order/orderpayment";
    }

    /* hard coding *//*
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
    }*/

}