package com.example.rollmoney.service;

import com.example.rollmoney.dto.auth.AutenticadorDTO;
import com.example.rollmoney.dto.auth.AutenticadorResponseDTO;
import com.example.rollmoney.entity.Autenticacao;
import com.example.rollmoney.entity.Usuario;
import com.example.rollmoney.mapper.UsuarioMapper;
import com.example.rollmoney.repository.AutenticacaoRepository;
import com.example.rollmoney.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{

   private final UsuarioRepository usuarioRepository;

   private final UsuarioMapper usuarioMapper;

   private final AutenticacaoRepository autenticacaoRepository;

    @Override
    public AutenticadorResponseDTO autenticar(AutenticadorDTO autenticadorDTO) {

        try {
         Usuario usuario = usuarioRepository.findByNomeusuario(autenticadorDTO.getUsuario());
          if(usuario.getSenha().equals(autenticadorDTO.getSenha())){
              UUID uuid = UUID.randomUUID();
              String myRandom = uuid.toString().substring(0,20);
              Autenticacao autenticacao = new Autenticacao();
              autenticacao.setDuracao("N");
              autenticacao.setUsuarioid(usuario.getId());
              autenticacao.setToken(myRandom);
              autenticacaoRepository.save(autenticacao);

              AutenticadorResponseDTO autenticadorResponseDTO = new AutenticadorResponseDTO();
              autenticadorResponseDTO.setDuracao("N");
              autenticadorResponseDTO.setUsuarioDTO(usuarioMapper.map(usuario));
              autenticadorResponseDTO.setToken(myRandom);

              return autenticadorResponseDTO;
          }
        }catch (Exception e){

        }
        return null;
    }
}
