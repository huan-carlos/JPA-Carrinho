package com.example.CRUDProdutoJPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.CRUDProdutoJPA.model.entity.Venda;
import com.example.CRUDProdutoJPA.model.repository.VendaRepository;
import org.springframework.context.annotation.Scope;

@Scope(value = "request")
@Transactional
@Controller
@RequestMapping("vendas")
public class VendaController {
    
    @Autowired
    Venda venda;

    @Autowired
    VendaRepository repository;

    @GetMapping("/form")
    public String form(Venda venda) {
        return "/vendas/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("vendas", repository.buscarVendas());
        return new ModelAndView("/vendas/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(Venda venda) {
        repository.save(venda);
        return new ModelAndView("redirect:/vendas/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") int id) {
        repository.remove(id);
        return new ModelAndView("redirect:/vendas/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("venda", repository.buscarVenda(id));
        return new ModelAndView("/vendas/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Venda venda) {
        repository.update(venda);
        return new ModelAndView("redirect:/vendas/list");
    }

}
