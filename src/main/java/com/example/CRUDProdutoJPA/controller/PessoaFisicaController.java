package com.example.CRUDProdutoJPA.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.CRUDProdutoJPA.model.entity.PessoaFisica;
import com.example.CRUDProdutoJPA.model.repository.PessoaFisicaRepository;

@Scope(value = "request")
@Transactional
@Controller
@RequestMapping("/fisica")
public class PessoaFisicaController {
    
    @Autowired
    PessoaFisicaRepository repository;

    @GetMapping("/form")
    public String form(PessoaFisica pessoaFisica) {
        return "/fisica/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("pessoasFisicas", repository.readAll());
        return new ModelAndView("/fisica/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(PessoaFisica pessoaFisica) {
        repository.create(pessoaFisica);
        return new ModelAndView("redirect:/fisica/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        repository.delete(id);
        return new ModelAndView("redirect:/fisica/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("fisica", repository.read(id));
        return new ModelAndView("/fisica/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(PessoaFisica pessoaFisica) {
        repository.update(pessoaFisica);
        return new ModelAndView("redirect:/fisica/list");
    }
}
