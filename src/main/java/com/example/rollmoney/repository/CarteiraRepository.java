package com.example.rollmoney.repository;

import com.example.rollmoney.entity.Autenticacao;
import com.example.rollmoney.entity.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

    Carteira findByUsuarioId(Long id);
}
