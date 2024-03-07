package com.companimal.semiProject.project.controller;

import com.companimal.semiProject.project.model.dto.ProjectDTO;
import com.companimal.semiProject.project.model.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProjectController {

    private final ProjectService projectService;

    private ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projectDetail")
    public String selectProject(Model model) {

        List<ProjectDTO> selectProjectList = projectService.selectProject();

        model.addAttribute("selectProjectList", selectProjectList);

        return "contents/project/projectDetail";
    }
  
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
