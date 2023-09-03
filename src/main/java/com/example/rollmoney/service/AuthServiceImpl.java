package com.example.rollmoney.service;

import com.example.rollmoney.dto.UsuarioDTO;
import com.example.rollmoney.dto.auth.AutenticadorDTO;
import com.example.rollmoney.dto.auth.AutenticadorResponseDTO;
import com.example.rollmoney.entity.Autenticacao;
import com.example.rollmoney.entity.Usuario;
import com.example.rollmoney.mapper.UsuarioMapper;
import com.example.rollmoney.repository.AutenticacaoRepository;
import com.example.rollmoney.repository.UsuarioRepository;
import com.example.rollmoney.service.exception.ProfileDataException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{

   private final UsuarioRepository usuarioRepository;

   private final UsuarioMapper usuarioMapper;

   private final AutenticacaoRepository autenticacaoRepository;

    @Override
    public AutenticadorResponseDTO autenticar(AutenticadorDTO autenticadorDTO) {


         Usuario usuario = usuarioRepository.findByNomeusuario(autenticadorDTO.getUsuario());
         if(usuario == null){
             throw new ProfileDataException("Erro na autenticação");
         }

          if(usuario.getSenha().equals(autenticadorDTO.getSenha())){


              List<Autenticacao> autenticacao2 = autenticacaoRepository.findByUsuarioid(usuario.getId());
              if(autenticacao2.size() != 0){
                  AutenticadorResponseDTO autenticadorResponseDTO = new AutenticadorResponseDTO();
                  autenticadorResponseDTO.setUsuarioDTO(usuarioMapper.map(usuario));
                  autenticadorResponseDTO.setDuracao(autenticadorResponseDTO.getDuracao());
                  autenticadorResponseDTO.setToken(autenticacao2.get(0).getToken());
                  return autenticadorResponseDTO;
              }

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

        throw new ProfileDataException("Erro na autenticação");
    }

    @Override
    public UsuarioDTO verificarUsuarioPorToken(String token) {

        try {
            Autenticacao autenticacao = autenticacaoRepository.findByToken(token);
            Optional<Usuario> usuario = usuarioRepository.findById(autenticacao.getUsuarioid()) ;
            return usuarioMapper.map(usuario.get());
        }catch (Exception e){
            throw new ProfileDataException("Usuário não encontrado");
        }

    }
}
