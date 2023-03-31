package com.ll.gramgram.boundedContext.home.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adm")
public class AdminController {

    @GetMapping("")
    @PreAuthorize("hasAuthority('admin')")
    public String showMain() {
        return "adm/home/main";
    }

}
