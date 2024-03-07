package com.companimal.semiProject.project.controller;

import com.companimal.semiProject.project.model.dto.ProjectDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contents")
public class ProjectController {

//    private final ProjectService projectService;
//
//    private ProjectController(ProjectService projectService) {
//        this.projectService = projectService;
//    }

    @GetMapping("/project/projectDetail")
    public String selectProject() {

//        List<ProjectDTO> selectProjectList = projectService.selectProject();
//
//        model.addAttribute("selectProjectList", selectProjectList);

        return "contents/project/projectDetail";
    }

}
