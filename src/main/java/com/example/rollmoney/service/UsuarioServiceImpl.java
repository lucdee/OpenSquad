package com.example.rollmoney.service;

import com.example.rollmoney.dto.UsuarioDTO;
import com.example.rollmoney.entity.Usuario;
import com.example.rollmoney.mapper.UsuarioMapper;
import com.example.rollmoney.repository.UsuarioRepository;
import com.example.rollmoney.service.exception.ProfileDataException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    @Override
    public String save(UsuarioDTO usuarioDTO, String senha, String email, String cpf) {


        Usuario usuario =  usuarioRepository.findByNomeusuario(usuarioDTO.getNomeusuario());
        if(usuario != null){
            throw new ProfileDataException("Usuário já existente");
        }

        Usuario usuario1 = usuarioRepository.findByEmail(email);
        if(usuario1 != null){
            throw new ProfileDataException("Email já existente");
        }

        usuarioDTO.setLevel(0L);
        usuarioDTO.setDataregistro(LocalDate.now());
        Usuario usuario2 = usuarioMapper.map(usuarioDTO);
        usuario2.setSenha(senha);
        usuario2.setCpf(cpf);
        usuario2.setEmail(email);
        usuarioRepository.save(usuario2);
        return "usuario criado";
    }

    @Override
    public UsuarioDTO findByNomeUsuario(String nomeUsuario) {
        try{
            Usuario usuario = usuarioRepository.findByNomeusuario(nomeUsuario);
            return usuarioMapper.map(usuario);
        }catch (Exception e){
            throw new ProfileDataException("Usuário não encontrado");
        }

    }
}
