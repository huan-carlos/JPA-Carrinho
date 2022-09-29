package com.example.CRUDProdutoJPA.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.CRUDProdutoJPA.model.entity.ItemVenda;
import com.example.CRUDProdutoJPA.model.entity.Venda;
import com.example.CRUDProdutoJPA.model.repository.ProdutoRepository;

@Scope(value = "request")
@Transactional
@Controller
@RequestMapping("inicio")
public class InicioController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping("/inicio")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("itemVenda", new ItemVenda());
        model.addAttribute("carrinho", new Venda());
        model.addAttribute("produtos", repository.buscarProdutos());
        return new ModelAndView("/home", model);
    }
    
}
