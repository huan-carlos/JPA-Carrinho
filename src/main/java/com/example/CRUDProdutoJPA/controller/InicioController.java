package com.example.CRUDProdutoJPA.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.CRUDProdutoJPA.model.entity.ItemVenda;
import com.example.CRUDProdutoJPA.model.entity.Produto;
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
    public ModelAndView listar(ModelMap model, HttpServletRequest request ,HttpServletResponse response) {
        HttpSession session = request.getSession(true);

        Venda carrinho = new Venda();
        ItemVenda itemVenda = new ItemVenda();
        List<Produto> produtos = repository.buscarProdutos();

        session.setAttribute("carrinho", carrinho);
        //session.setAttribute("itemVenda", itemVenda);
        session.setAttribute("produtos", produtos);

        model.addAttribute("itemVenda", itemVenda);
        //model.addAttribute("carrinho", carrinho);
        //model.addAttribute("produtos", produtos);
        return new ModelAndView("/home", model);
    }
    
}
