package com.companimal.semiProject.evaluation.controller;

import com.companimal.semiProject.evaluation.model.dto.CalculationListDTO;
import com.companimal.semiProject.evaluation.model.service.CreatorEvaluationService;
import com.companimal.semiProject.evaluation.model.service.EvaluationService;
import com.companimal.semiProject.project.model.dto.CreatorInfoDTO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {

//    private final EvaluationService evaluationService;
    private final CreatorEvaluationService creatorEvaluationService;

    public EvaluationController(CreatorEvaluationService creatorEvaluationService) {
        this.creatorEvaluationService = creatorEvaluationService;
    }

    /*
    @GetMapping("/evacalculationlist")
    public String selectEvaCalculationList(Model model) {
        System.out.println("후원금 최종 정산 심사");

        List<CalculationListDTO> calculationList = evaluationService.selectEvaCalculationList();

        model.addAttribute("calculationList", calculationList);

        return "contents/evaluation/evacalculationlist";
    }*/


    @GetMapping("/creatorEvaluationRegist")
    public String creatorEvaluationRegist() {
        return "/contents/evaluation/creatorEvaluationRegist";
    }

    @PostMapping("/creatorEvaluationRegist")
    public String creatorEvaluationRegist(@RequestParam MultipartFile creatorProductPlan
            , @RequestParam MultipartFile creatorProductPortfolio
            , @RequestParam MultipartFile creatorImg
            , @ModelAttribute CreatorInfoDTO creatorInfoDTO
            , Authentication authentication) throws IOException {

        String creatorId = authentication.getName();

        creatorEvaluationService.insertCreatorInfo(creatorProductPlan, creatorProductPortfolio, creatorImg, creatorInfoDTO, creatorId);

        return "/main";
    }

}

