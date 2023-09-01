package com.example.rollmoney.service;

import com.example.rollmoney.dto.UsuarioDTO;

public interface UsuarioService {

    String save(UsuarioDTO usuarioDTO, String senha, String email, String cpf);

    UsuarioDTO findByNomeUsuario(String nomeUsuario);
}
