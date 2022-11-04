package com.example.CRUDProdutoJPA.model.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.example.CRUDProdutoJPA.model.entity.PessoaFisica;

import java.util.List;
import javax.persistence.Query;

@Repository
public class PessoaFisicaRepository {
    
    @PersistenceContext
    private EntityManager em;

    public void create(PessoaFisica pessoaFisica) {
        em.persist(pessoaFisica);
    }

    public PessoaFisica read(Long id) {
        return em.find(PessoaFisica.class, id);
    }
    
    public List<PessoaFisica> readAll() {
        Query query = em.createQuery("from PessoaFisica");
        return query.getResultList();
    }

    public void update(PessoaFisica pessoaFisica) {
        em.merge(pessoaFisica);
    }

    public void delete(Long id) {
        em.remove(em.find(PessoaFisica.class, id));
    }
}
