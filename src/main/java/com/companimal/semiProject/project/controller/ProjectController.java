package com.companimal.semiProject.project.controller;

import com.companimal.semiProject.project.model.dao.ProjectMapper;
import com.companimal.semiProject.project.model.dto.ProjectDTO;
import com.companimal.semiProject.project.model.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/project")
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

    @GetMapping("/endprolist")
    public String selectEndProList(Model model) {
        List<ProjectDTO> selectEndProjectList = projectService.selectEndProjectList();

        model.addAttribute("endProjectList", selectEndProjectList);

        return "contents/project/creatorendpj";
    }

    @RequestMapping("/supportlist")
    public String selectSupportList(@RequestParam Long id, Model model) {
        System.out.println("진행 종료 프로젝트 후원 내역 조회");
        System.out.println(id);

//        List<>

//        model.addAttribute("supportList", selectSupportList);

        return "contents/project/creatorsupportlist";
    }

    @RequestMapping("/calculationlist")
    public String selectCalculationList() {
        System.out.println("후원금 정산 진행 현황");

        return "contents/project/calculationlist";
    }

    @PostMapping("/updateShipment")
    public String updateShipment(@RequestParam("shipmentDate") String shipmentDate) {
        System.out.println("발송 예정일 입력 완료111");

        return "redirect:shipment";
    }

    @PostMapping("/shipment")
    public String updateShipment() {
        System.out.println("발송 예정일 입력 완료222");

        return "redirect:endprolist";
    }

}
