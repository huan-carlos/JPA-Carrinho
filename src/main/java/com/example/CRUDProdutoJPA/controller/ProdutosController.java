    package com.example.CRUDProdutoJPA.controller;

import com.example.CRUDProdutoJPA.model.entity.ItemVenda;
import com.example.CRUDProdutoJPA.model.entity.Produto;
import com.example.CRUDProdutoJPA.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("produtos")
public class ProdutosController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping("/form")
    public String form(Produto produto) {
        return "/produtos/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ItemVenda itemVenda, ModelMap model) {
        model.addAttribute("produtos", repository.buscarProdutos());
        return new ModelAndView("/home", model);
    }
    
    @PostMapping("/save")
    public ModelAndView save(Produto produto) {
        repository.save(produto);
        return new ModelAndView("redirect:/produtos/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na
     *               URL
     */
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") int id) {
        repository.remove(id);
        return new ModelAndView("redirect:/produtos/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na
     *               URL
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("produto", repository.buscarProduto(id));
        return new ModelAndView("/produtos/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Produto produto) {
        repository.update(produto);
        return new ModelAndView("redirect:/produtos/list");
    }

}
