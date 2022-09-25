package com.example.CRUDProdutoJPA.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.example.CRUDProdutoJPA.model.entity.Venda;

@Repository
public class VendaRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Venda venda){
        em.persist(venda);
    }

    public Venda buscarVenda(int id){
        return em.find(Venda.class, id);
    }

    public List<Venda> buscarVendas(){
        Query query = em.createQuery("from Venda");
        return query.getResultList();
    }

    public void remove(int id) {
        Venda v = em.find(Venda.class, id);
        em.remove(v);
    }

    public void update(Venda venda){
        em.merge(venda);
    }
}
