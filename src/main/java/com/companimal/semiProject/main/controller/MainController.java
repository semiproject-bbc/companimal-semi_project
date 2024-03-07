package com.companimal.semiProject.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String defaultPage() {
        return "index";
    }

    @GetMapping("index")
    public void main() {}
}
