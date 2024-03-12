package com.companimal.semiProject.project.controller;

import com.companimal.semiProject.project.model.dto.ProjectDTO;
import com.companimal.semiProject.project.model.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    private ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projectPage")
    public String selectProject(Model model) {

        List<ProjectDTO> selectProjectList = projectService.selectProject();

        System.out.println(selectProjectList);

        model.addAttribute("selectProjectList", selectProjectList);

        return "contents/project/projectDetail";
    }

    @GetMapping("/projectDetail")
    public String selectProjectDetail(Model model) {
        List<ProjectDTO> selectProjectList = projectService.selectProjectDetail();

        System.out.println(selectProjectList);

        model.addAttribute("selectProjectList", selectProjectList);

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

        projectService.insertProject(file, project);

        return "contents/project/projectRegistAfter";
    }

}
