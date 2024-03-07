package com.companimal.semiProject.project.controller;

import com.companimal.semiProject.project.model.dto.ProjectDTO;
import com.companimal.semiProject.project.model.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

//    @GetMapping("/project/projectRegist1")
//    public String insertProject() {
//
//        return "redirect:/projectRegist1";
//    }

}
