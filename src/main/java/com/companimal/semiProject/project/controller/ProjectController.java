package com.companimal.semiProject.project.controller;

import com.companimal.semiProject.auth.model.AuthDetails;
import com.companimal.semiProject.project.model.dto.ProjectDTO;
import com.companimal.semiProject.project.model.dto.ProjectRewardDTO;
import com.companimal.semiProject.project.model.dto.ProjectRewardOptDTO;
import com.companimal.semiProject.project.model.service.ProjectService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    private int rewardNumber = 1;

    private ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public String selectAllProject(Model model) {
        List<ProjectDTO> selectAllProjectList = projectService.selectAllProject();

        model.addAttribute("selectAllProjectList", selectAllProjectList);

        return "main";
    }

    @GetMapping("/projectPage")
    public String selectProject(Model model) {

        ProjectDTO selectProject = projectService.selectProject();

        model.addAttribute("selectProject", selectProject);

        return "contents/project/projectDetail";
    }

    @GetMapping("/projectDetail/{proCode}")
    public String selectProjectDetail(Model model, @PathVariable Integer proCode) {

        ProjectDTO selectProject = projectService.selectProjectDetail(proCode);

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

    @ResponseBody
    @PostMapping("/projectRegist")
    public String insertProject(@RequestParam("files") MultipartFile[] files,
                                @ModelAttribute ProjectDTO project,
                                Authentication authentication) throws IOException {

        AuthDetails authDetails = (AuthDetails) authentication.getPrincipal();
        String memId = authDetails.getUsername();

        System.out.println("Logged-in User ID: " + memId);

        ProjectRewardDTO reward = project.getReward();
        List<ProjectRewardOptDTO> rewardOpt = project.getReward().getRewardOpt();
        System.out.println(reward);
        System.out.println(rewardOpt);

        project.setMemId(memId);

        project.setProStory(Arrays.toString(files));
        project.setEvaStatus("N");
//        project.setAchRate(0);
//        project.setEstDate(null);
        projectService.insertProject(files, project, memId);

        System.out.println("Uploaded files: " + Arrays.toString(files));
        System.out.println("ProjectDTO: " + project);

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
    public String selectEndProList(Authentication authentication, Model model) {
        String id = authentication.getName();

        List<ProjectDTO> selectEndProjectList = projectService.selectEndProjectList(id);

        model.addAttribute("endProjectList", selectEndProjectList);

        return "contents/project/creatorendpj";
    }

    @ResponseBody
    @PostMapping("/updateShipment")
    public String updateShipment(@RequestParam("proCode") int proCode, @RequestParam("estDate") String estDate) {
        ProjectDTO estDateDto = new ProjectDTO();
        estDateDto.setProCode(proCode);
        estDateDto.setEstDate(Date.valueOf(estDate));

        int result = projectService.updateShipment(estDateDto);

        if (result > 0) {
            System.out.println(":)");
        } else {
            System.out.println(":(");
        }

        return "redirect:/creatorendpj";
    }

    @GetMapping("/supportlist/{proCode}")
    public String selectSupportList(@PathVariable("proCode") int proCode, Model model) {
        System.out.println("진행 종료 프로젝트 후원 내역 조회");
        System.out.println("프로젝트 번호 확인 " + proCode);

        List<ProjectDTO> supportList = projectService.selectSupportList(proCode);

        System.out.println("으아아아아아 ::::: " + supportList.toString());

        model.addAttribute("supportList", supportList);

        return "contents/project/creatorsupportlist";
    }

    @RequestMapping("/calculationlist")
    public String selectCalculationList(Authentication authentication, Model model) {
        String id = authentication.getName();

        List<ProjectDTO> calculationList = projectService.selectCalculationList(id);

        for (int i = 0; i < calculationList.size(); i++) {
            System.out.println("each ::::: " + calculationList.get(i));
            for (int j = 0; j < calculationList.get(i).getOrderPayment().size(); j++) {
                System.out.println("each2 ::::: " + calculationList.get(i).getOrderPayment().get(j).getPurchaseStatus());
            }
        }

        model.addAttribute("calculationList", calculationList);


        return "contents/project/calculationlist";
    }

}
