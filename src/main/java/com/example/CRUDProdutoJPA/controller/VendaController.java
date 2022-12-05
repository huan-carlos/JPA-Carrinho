package com.example.CRUDProdutoJPA.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.CRUDProdutoJPA.model.entity.ItemVenda;
import com.example.CRUDProdutoJPA.model.entity.PessoaFisica;
import com.example.CRUDProdutoJPA.model.entity.Venda;
import com.example.CRUDProdutoJPA.model.repository.PessoaFisicaRepository;
import com.example.CRUDProdutoJPA.model.repository.VendaRepository;
import org.springframework.context.annotation.Scope;

@Scope(value = "request")
@Transactional
@Controller
@RequestMapping("vendas")
public class VendaController {

    @Autowired
    VendaRepository repository;

    @Autowired
    PessoaFisicaRepository pf;

    @Autowired
    Venda venda;

    @GetMapping("/form")
    public String form(Venda venda) {
        return "/vendas/form";
    }

    @GetMapping("/pedidos")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("vendas", repository.buscarVendas());
        return new ModelAndView("/vendas/pedidos", model);
    }

    @PostMapping("/addcliente")
    public ModelAndView setCliente(PessoaFisica pessoaFisica){
        venda.setPessoa(pessoaFisica);
        pessoaFisica.addCompra(venda);
        return new ModelAndView("redirect:/vendas/save");
    }

    @GetMapping("/save")
    public ModelAndView save(HttpSession httpsession, SessionStatus status) {
        repository.save(venda);
        venda = new Venda();
        status.setComplete();
        httpsession.invalidate();
        return new ModelAndView("redirect:/vendas/pedidos");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") int id) {
        repository.remove(id);
        return new ModelAndView("redirect:/vendas/list");
    }

    @GetMapping("/list/{id}")
    public ModelAndView list(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("vendadetalhes", repository.buscarVenda(id));
        return new ModelAndView("/vendas/pedido");
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

    @PostMapping("/addcarrinho")
    public ModelAndView addCarrinho(ItemVenda itemVenda) {
        itemVenda.setVenda(venda);
        venda.addItensVenda(itemVenda);
        return new ModelAndView("redirect:/produtos/list");
    }

    @GetMapping("/removeritem/{id}")
    public ModelAndView removerItem(@PathVariable("id") int idProduto) {
        Iterator<ItemVenda> itt = this.venda.getItensVenda().iterator();

        while (itt.hasNext()) {
            if (itt.next().getProduto().getId() == idProduto) {
                itt.remove();
            }
        }
        return new ModelAndView("redirect:/vendas/carrinho");
    }

    @GetMapping("/carrinho")
    public ModelAndView carrinho(ModelMap model, PessoaFisica pessoaFisica) {
        model.addAttribute("clientes", pf.readAll());
        return new ModelAndView("/vendas/carrinho", model);
    }
}
