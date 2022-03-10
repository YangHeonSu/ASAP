package com.project.ASAP.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class dashboardController {
    @GetMapping("dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
