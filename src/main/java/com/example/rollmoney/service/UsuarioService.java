package com.example.rollmoney.service;

import com.example.rollmoney.dto.UsuarioDTO;

public interface UsuarioService {

    UsuarioDTO save(UsuarioDTO usuarioDTO, String senha);

    UsuarioDTO findByNomeUsuario(String nomeUsuario);
}
