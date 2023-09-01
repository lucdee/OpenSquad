package com.example.rollmoney.repository;

import com.example.rollmoney.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNomeusuario(String usuario);

    Usuario findByEmail(String email);
}
