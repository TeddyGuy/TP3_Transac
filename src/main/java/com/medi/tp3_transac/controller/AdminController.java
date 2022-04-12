package com.medi.tp3_transac.controller;

import com.medi.tp3_transac.dto.BookForm;
import com.medi.tp3_transac.dto.ClientForm;
import com.medi.tp3_transac.dto.DocumentLoanForm;
import com.medi.tp3_transac.model.user.Client;
import com.medi.tp3_transac.service.AdminService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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

    @GetMapping("/client/{id}/borrowing-history")
    public String getClientDocumentLoanHistory(Model model, @PathVariable String id){
        model.addAttribute("pageTitle","JavaTown Library System");
        model.addAttribute("client",adminService.findClientByIdWithBorrowingHistory(Long.parseLong(id)).get());
        return "client-borrowing-history";
    }

    @GetMapping("/register-client")
    public String getRegisterClientRequest(Model model){
        model.addAttribute("pageTitle","JavaTown Library System");
        model.addAttribute("clientForm", new ClientForm());
        return "register-client";
    }

    @PostMapping("/register-client")
    public String postRegisterClientRequest(@ModelAttribute ClientForm clientForm){
        adminService.saveClient(clientForm.getUsername().trim(),clientForm.getPassword(),clientForm.getEmail().trim());
        return "redirect:clients";
    }

    @GetMapping("/documents")
    public String getDocumentsRequest(Model model){
        model.addAttribute("pageTitle","JavaTown Library System");
        model.addAttribute("books", adminService.findAllBooks());
        return "documents";
    }

    @GetMapping("/add-book")
    public String getAddDocumentRequest(Model model){
        model.addAttribute("pageTitle","JavaTown Library System");
        model.addAttribute("bookForm", new BookForm());
        return "add-book";
    }

    @PostMapping("/add-book")
    public String postAddBook(@ModelAttribute BookForm bookForm){
        adminService.saveBook(bookForm.getTitle(),bookForm.getAuthor(),bookForm.getGenre(),bookForm.getPublicationYear(),bookForm.getPublisher(), bookForm.getPages());
        return "redirect:documents";
    }

    @GetMapping("/lend-document")
    public String getLendDocumentRequest(Model model){
        model.addAttribute("pageTitle","JavaTown Library System");
        model.addAttribute("documentLoanForm", new DocumentLoanForm());
        return "lend-document";
    }

    @PostMapping("/lend-document")
    public String postLendDocumentRequest(@ModelAttribute DocumentLoanForm documentLoanForm){
        adminService.lendDocumentByIdToClientById(documentLoanForm.getDocumentId(),documentLoanForm.getClientId());
        return "redirect:/client/" + documentLoanForm.getClientId() + "/borrowing-history";
    }
}
