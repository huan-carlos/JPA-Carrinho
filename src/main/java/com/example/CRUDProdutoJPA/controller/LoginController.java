package com.example.CRUDProdutoJPA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Transactional
@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String login(){
        return "/authentication/login";
    }
}
