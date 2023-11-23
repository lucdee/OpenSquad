package com.v1.opensquad.service;


import com.v1.opensquad.dto.ConviteDTO;
import com.v1.opensquad.entity.Autenticacao;
import com.v1.opensquad.entity.Convite;
import com.v1.opensquad.entity.Perfil;
import com.v1.opensquad.entity.Squad;
import com.v1.opensquad.mapper.ConviteMapper;
import com.v1.opensquad.repository.AutenticacaoRepository;
import com.v1.opensquad.repository.ConviteRepository;
import com.v1.opensquad.repository.PerfilRepository;
import com.v1.opensquad.repository.SquadRepository;
import com.v1.opensquad.service.exception.AuthDataException;
import com.v1.opensquad.service.exception.ProfileDataException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConviteServiceImpl implements ConviteService{

    private final ConviteRepository conviteRepository;

    private final AutenticacaoRepository autenticacaoRepository;

    private final PerfilRepository perfilRepository;

    private final SquadRepository squadRepository;

    private final ConviteMapper conviteMapper;

    @Override
    public ConviteDTO save(String token, ConviteDTO conviteDTO,  String usuario, Long idsquad) {
        Autenticacao autenticacao = autenticacaoRepository.findByToken(token);
        if(autenticacao == null){
            throw new AuthDataException("Token Inválido!");
        }
       List<Perfil> perfil =  perfilRepository.findByUsuario(usuario);

        if(perfil.size() == 0){
            throw new ProfileDataException("Usuário não encontrado");
        }

       Optional<Squad> squad = squadRepository.findById(idsquad);

       conviteDTO.setDataConvite(String.valueOf(LocalDateTime.now()));
       if(squad.isPresent()){
           conviteDTO.setIdSquad(squad.get());
       }
       if(perfil.size() != 0){
           conviteDTO.setIdPerfilEnvio(perfil.get(0));
       }
       conviteDTO.setStatus("A");
       Convite convite = conviteMapper.map(conviteDTO);
       Convite convite1 = conviteRepository.save(convite);
       return conviteMapper.map(convite1);
    }
}
