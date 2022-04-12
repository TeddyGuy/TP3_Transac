package com.medi.tp3_transac.controller;

import com.medi.tp3_transac.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping("/")
    public String getRootRequest(Model model){
        model.addAttribute("pageTitle","JavaTown Library System");
        return "index";
    }

    @GetMapping("/clients")
    public String getClientsRequest(Model model){
        model.addAttribute("pageTitle","JavaTown Library System");
        model.addAttribute("clients",adminService.findAllClients());
        return "clients";
    }

    @GetMapping("/register-client")
    public String getRegisterClientRequest(Model model){
        model.addAttribute("pageTitle","JavaTown Library System");
        return "register-client";
    }
}
