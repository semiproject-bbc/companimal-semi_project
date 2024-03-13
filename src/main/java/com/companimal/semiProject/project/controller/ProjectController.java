package com.companimal.semiProject.project.controller;

import com.companimal.semiProject.order.model.dto.OrderPaymentDTO;
import com.companimal.semiProject.order.model.service.OrderService;
import com.companimal.semiProject.project.model.dto.ProjectDTO;
import com.companimal.semiProject.project.model.service.ProjectService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.thymeleaf.util.StringUtils.replace;
import static org.thymeleaf.util.StringUtils.substring;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    private ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

//    @GetMapping("/")
//    public String selectAllProject(Model model) {
//        List<ProjectDTO> selectAllProjectList = projectService.selectAllProject();
//
//        model.addAttribute("selectAllProjectList", selectAllProjectList);
//
//        return "main";
//    }

    @GetMapping("/projectPage")
    public String selectProject(Model model) {

        ProjectDTO selectProject = projectService.selectProject();

        model.addAttribute("selectProject", selectProject);

        return "contents/project/projectDetail";
    }

    @GetMapping("/projectDetail/{proCode}")
    public String selectProjectDetail(Model model, Integer proCode, ProjectDTO project) {

        ProjectDTO selectProject = projectService.selectProjectDetail(proCode, project);

        System.out.println(selectProject);

        model.addAttribute("selectProject", selectProject);

        return "contents/project/projectDetail";
    }

    @GetMapping("/projectRegistBefore")
    public String goInsertProjectBefore() {
        return "contents/project/projectRegistBefore";
    }

    @GetMapping("/projectRegist")
    public String goInsertProject() {
        return "contents/project/projectRegist";
    }

    @PostMapping("/projectRegist")
    public String insertProject(@RequestParam MultipartFile file
                                , @ModelAttribute ProjectDTO project) throws IOException {

        System.out.println(project);

        projectService.insertProject(file, project);

        return "contents/project/projectRegistAfter";

    }

    @GetMapping("/projectImage")
    public String imageInsert() {
        return "contents/project/projectImage";
    }

    @PostMapping("projectImage")
    public String projectImage(@RequestParam MultipartFile file1
                               /*@RequestParam MultipartFile file2*/) {

        projectService.insertImage(file1);

        return "contents/project/projectRegistAfter";
    }

    @GetMapping("/endprolist")
    public String selectEndProList(Model model) {
        List<ProjectDTO> selectEndProjectList = projectService.selectEndProjectList();

        model.addAttribute("endProjectList", selectEndProjectList);

        return "contents/project/creatorendpj";
    }

    @RequestMapping("/supportlist")
    public String selectSupportList(int id, Model model) {
        System.out.println("진행 종료 프로젝트 후원 내역 조회");

        ProjectDTO supportList = projectService.selectSupportList(id);

        model.addAttribute("supportList", supportList);

        return "contents/project/creatorsupportlist";
    }

//    @RequestMapping("/calculationlist")
//    public String selectCalculationList(Model model) {
//        System.out.println("후원금 정산 진행 현황");
//
//        List<ProjectDTO> calculationList = projectService.selectCalculationList();
//
//        model.addAttribute("calculationList", calculationList);
//
//        return "contents/project/calculationlist";
//    }

    @ResponseBody
    @PostMapping("/updateShipment")
    public String updateShipment(@RequestParam("proCode") int proCode, @RequestParam("estDate") String estDate) throws ParseException {
        System.out.println("가" + proCode);

//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date newShipment = (java.sql.Date)format.parse(estDate);
//
//        ProjectDTO estDateDto = new ProjectDTO();
//        estDateDto.setProCode(proCode);
//        estDateDto.setEstDate(newShipment);
//
//        int result = projectService.updateShipment(estDateDto);
//
//        if(result > 0) {
//            System.out.println(":)");
//        }else {
//            System.out.println(":(");
//        }

        return "redirect:endprolist";
    }

//    @PostMapping("/shipment")
//    public String updateShipment() {
//        System.out.println("발송 예정일 입력 완료222");
//
//        return "redirect:endprolist";
//    }
}
