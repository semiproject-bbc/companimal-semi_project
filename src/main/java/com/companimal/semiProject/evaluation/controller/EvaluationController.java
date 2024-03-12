package com.companimal.semiProject.evaluation.controller;

import com.companimal.semiProject.evaluation.model.dto.CalculationListDTO;
import com.companimal.semiProject.evaluation.model.service.EvaluationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
/*    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping("/evacalculationlist")
    public String selectEvaCalculationList(Model model) {
        System.out.println("후원금 최종 정산 심사");

        List<CalculationListDTO> calculationList = evaluationService.selectEvaCalculationList();

        model.addAttribute("calculationList", calculationList);

        return "contents/evaluation/evacalculationlist";
    }*/
}
