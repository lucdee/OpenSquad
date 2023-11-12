package com.v1.opensquad.repository;

import com.v1.opensquad.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    Perfil findByEmail(String emailUsuario);

    Perfil findByUsuario(String emailUsuario);
}
