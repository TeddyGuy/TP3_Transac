package com.medi.tp3_transac.controller;

import com.medi.tp3_transac.service.AdminService;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }
}
