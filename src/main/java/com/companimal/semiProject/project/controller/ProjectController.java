package com.companimal.semiProject.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @RequestMapping("/endprolist")
    public String selectEndProList() {
        System.out.println("진행 종료 프로젝트 조회");

        return "contents/project/creatorendpj";
    }

    @RequestMapping("/supportlist")
    public String selectSupportList() {
        System.out.println("진행 종료 프로젝트 후원 내역 조회");

        return "contents/project/creatorsupportlist";
    }

    @RequestMapping("/calculationlist")
    public String selectCalculationList() {
        System.out.println("후원금 정산 진행 현황");

        return "contents/project/calculationlist";
    }

}
