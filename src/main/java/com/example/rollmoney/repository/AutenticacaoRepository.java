package com.example.rollmoney.repository;

import com.example.rollmoney.entity.Autenticacao;
import com.example.rollmoney.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutenticacaoRepository extends JpaRepository<Autenticacao, Long> {

    Autenticacao findByToken(String token);
}
