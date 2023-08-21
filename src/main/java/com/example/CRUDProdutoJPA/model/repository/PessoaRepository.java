package com.example.CRUDProdutoJPA.model.repository;

import com.example.CRUDProdutoJPA.model.entity.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface PessoaRepository extends JpaRepository<PessoaFisica, Long> {
    UserDetails findByLogin(String login);
}
