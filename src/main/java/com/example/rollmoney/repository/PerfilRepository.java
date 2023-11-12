package com.example.rollmoney.repository;

import com.example.rollmoney.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    Perfil findByEmail(String emailUsuario);

    Perfil findByUsuario(String emailUsuario);
}
