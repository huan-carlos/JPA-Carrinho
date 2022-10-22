package com.example.CRUDProdutoJPA.model.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component
@Entity
@Table(name = "tb_venda")
public class Venda implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @CreationTimestamp
    private Date data;

    @OneToMany(mappedBy = "venda")
    List<ItemVenda> itensVenda;

    public Venda() {
        this.itensVenda = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYY");
        String auxData = sdf.format(data);
        return auxData;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double total() {
        double totalVenda = 0;
        for (ItemVenda i : itensVenda) {
            totalVenda += i.total();
        }
        return totalVenda;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void addItensVenda(ItemVenda itenVenda) {
        this.itensVenda.add(itenVenda);
    }

}
