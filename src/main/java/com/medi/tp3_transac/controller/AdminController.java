package com.medi.tp3_transac.controller;

import com.medi.tp3_transac.dto.BookForm;
import com.medi.tp3_transac.dto.ClientForm;
import com.medi.tp3_transac.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("clientForm", new ClientForm());
        return "register-client";
    }

    @PostMapping("/register-client")
    public String postRegisterClientRequest(@ModelAttribute ClientForm clientForm, Model model, BindingResult errors, RedirectAttributes redirectAttributes){
        adminService.saveClient(clientForm.getUsername().trim(),clientForm.getPassword(),clientForm.getEmail().trim());
        return "redirect:clients";
    }

    @GetMapping("/documents")
    public String getDocumentsRequest(Model model){
        model.addAttribute("pageTitle","JavaTown Library System");
        model.addAttribute("documents", adminService.findAllDocuments());
        return "documents";
    }

    @GetMapping("/add-book")
    public String getAddDocumentRequest(Model model){
        model.addAttribute("pageTitle","JavaTown Library System");
        model.addAttribute("bookForm", new BookForm());
        return "add-book";
    }
}
