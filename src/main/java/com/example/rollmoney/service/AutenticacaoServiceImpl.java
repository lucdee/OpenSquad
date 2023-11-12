package com.example.rollmoney.service;


import com.example.rollmoney.dto.PerfilDTO;
import com.example.rollmoney.dto.RetornoPerfilDTO;
import com.example.rollmoney.dto.auth.AutenticacaoDTO;
import com.example.rollmoney.dto.auth.AutenticacaoRetornoDTO;
import com.example.rollmoney.entity.Autenticacao;
import com.example.rollmoney.entity.Perfil;
import com.example.rollmoney.mapper.PerfilMapper;
import com.example.rollmoney.repository.AutenticacaoRepository;
import com.example.rollmoney.repository.PerfilRepository;
import com.example.rollmoney.service.exception.AuthDataException;
import com.example.rollmoney.service.exception.ProfileDataException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AutenticacaoServiceImpl implements AutenticacaoService{

    private final AutenticacaoRepository autenticacaoRepository;

    private final PerfilRepository perfilRepository;

    private final PerfilMapper perfilMapper;

    @Override
    public AutenticacaoRetornoDTO auth(AutenticacaoDTO autenticacaoDTO) {
        Perfil perfilByEmail = perfilRepository.findByEmail(autenticacaoDTO.getEmailUsuario());
        Perfil perfilByUsuario = perfilRepository.findByUsuario(autenticacaoDTO.getEmailUsuario());
        Perfil perfilEncontrado = null;

        if(perfilByUsuario == null && perfilByEmail != null){
            perfilEncontrado = perfilByEmail;
        }else if(perfilByUsuario != null && perfilByEmail == null){
            perfilEncontrado = perfilByUsuario;
        }else {
            throw new ProfileDataException("Perfil não encontrado com o email ou usuario");
        }
        if(!perfilEncontrado.getSenha().equals(autenticacaoDTO.getSenha())){
            throw new ProfileDataException("Senha Incorreta");
        }


        Autenticacao autenticacao = new Autenticacao();
        autenticacao.setDataCriacao(String.valueOf(LocalDateTime.now()));
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();
        autenticacao.setToken(myRandom.substring(0,30));
        autenticacao.setIdPerfil(perfilEncontrado);

        Autenticacao autenticacao1 = autenticacaoRepository.findByIdPerfilId(perfilEncontrado.getId());
        AutenticacaoRetornoDTO autenticacaoRetornoDTO = new AutenticacaoRetornoDTO();
        autenticacaoRetornoDTO.setRetornoPerfilDTO(perfilMapper.mapRetorno(perfilEncontrado));
        if(autenticacao1 != null){
            autenticacaoRetornoDTO.setToken(autenticacao1.getToken());
            return autenticacaoRetornoDTO;
        }
        try {
            autenticacaoRepository.save(autenticacao);
            autenticacaoRetornoDTO.setToken(myRandom.substring(0,30));
            return autenticacaoRetornoDTO;
        }catch (Exception e){
            throw new AuthDataException("Erro ao salvar token");
        }
    }

    @Override
    public RetornoPerfilDTO verificar(String token) {
        Autenticacao autenticacao = autenticacaoRepository.findByToken(token);
        if(autenticacao == null){
            throw new AuthDataException("Token não encontrado");
        }
        Optional<Perfil> perfil = perfilRepository.findById(autenticacao.getIdPerfil().getId());
        if(perfil.isPresent()){
          RetornoPerfilDTO perfilDTO = perfilMapper.mapRetorno(perfil.get());
            return perfilDTO;
        }
        throw new AuthDataException("Perfil não encontrado porém o token é válido");
    }
}
