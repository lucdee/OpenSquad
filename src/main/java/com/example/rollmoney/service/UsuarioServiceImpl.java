package com.example.rollmoney.service;

import com.example.rollmoney.dto.UsuarioDTO;
import com.example.rollmoney.mapper.UsuarioMapper;
import com.example.rollmoney.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {

        usuarioRepository.save(usuarioMapper.map(usuarioDTO));
        return null;
    }
}
