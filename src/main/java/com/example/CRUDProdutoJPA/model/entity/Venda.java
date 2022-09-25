package com.example.CRUDProdutoJPA.model.entity;

import java.io.Serializable;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double total() {
        double totalVenda = 0;
        for (int i = 0; i < itensVenda.size(); i++) {
            totalVenda += itensVenda.get(i).total();
        }
        return totalVenda;
    }

}
