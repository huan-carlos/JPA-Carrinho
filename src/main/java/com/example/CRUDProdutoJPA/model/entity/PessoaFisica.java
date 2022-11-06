package com.example.CRUDProdutoJPA.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component
@Entity
@Table(name = "tb_pessoafisica")
public class PessoaFisica extends Pessoa implements Serializable {

    private String nome;
    private String cpf;

    @OneToMany(mappedBy = "pessoa")
    private List<Venda> compras;

    public PessoaFisica() {
        this.compras = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Venda> getCompras() {
        return compras;
    }

    public void addCompra(Venda venda) {
        this.compras.add(venda);
    }
}