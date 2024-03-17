package com.companimal.semiProject.main.controller;

import com.companimal.semiProject.project.model.dto.ProjectDTO;
import com.companimal.semiProject.project.model.service.ProjectService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final ProjectService projectService;

    private MainController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(value = {"/", "/main"})
    public String home(Model model) {

        List<ProjectDTO> selectAllProjectList = projectService.selectAllProject();

        model.addAttribute("selectAllProjectList", selectAllProjectList);

        return "main";
    }

    @GetMapping("/main/storyPage")
    public String story() {
        return "contents/main/storyPage";
    }
}
