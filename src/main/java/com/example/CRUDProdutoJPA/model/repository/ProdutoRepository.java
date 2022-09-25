package com.example.CRUDProdutoJPA.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.example.CRUDProdutoJPA.model.entity.Produto;

@Repository
public class ProdutoRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Produto produto){
        em.persist(produto);
    }

    public Produto buscarProduto(int id){
        return em.find(Produto.class, id);
    }

    public List<Produto> buscarProdutos(){
        Query query = em.createQuery("from Produto");
        return query.getResultList();
    }

    public void remove(int id) {
        Produto p = em.find(Produto.class, id);
        em.remove(p);
    }

    public void update(Produto produto){
        em.merge(produto);
    }
}
