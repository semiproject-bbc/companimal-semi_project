package com.companimal.semiProject.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FourthTncController {

    @GetMapping("/fourthTnc")
    public String firstPage(Model model) {
        return "/contents/order/fourth";
    }
}
