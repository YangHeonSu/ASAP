package com.project.ASAP.Login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login.do")
    public String loginPage() {
        return "/login";
    }
}
