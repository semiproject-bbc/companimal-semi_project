package com.companimal.semiProject.evaluation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {

    @RequestMapping("/evacalculationlist")
    public String selectEvaCalculationList() {
        System.out.println("후원금 최종 정산 심사");

        return "contents/evaluation/evacalculationlist";
    }
}
