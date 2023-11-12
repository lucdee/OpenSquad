package com.v1.opensquad.service;
import com.v1.opensquad.dto.ParticipanteDTO;
import com.v1.opensquad.entity.Autenticacao;
import com.v1.opensquad.entity.Participante;
import com.v1.opensquad.entity.Perfil;
import com.v1.opensquad.mapper.ParticipanteMapper;
import com.v1.opensquad.repository.AutenticacaoRepository;
import com.v1.opensquad.repository.ParticipanteRepository;
import com.v1.opensquad.repository.PerfilRepository;
import com.v1.opensquad.service.exception.AuthDataException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ParticipanteServiceImpl implements ParticipanteService{

    private final AutenticacaoRepository autenticacaoRepository;

    private final ParticipanteRepository participanteRepository;

    private final PerfilRepository perfilRepository;

    private final ParticipanteMapper participanteMapper;

    @Override
    public ParticipanteDTO save(String token, Long idPerfil, ParticipanteDTO participanteDTO) {
        Autenticacao autenticacao = autenticacaoRepository.findByToken(token);
        if(autenticacao == null || !idPerfil.equals(autenticacao.getIdPerfil().getId())){
            throw new AuthDataException("Token Inválido!");
        }
       Participante participante =  participanteMapper.map(participanteDTO);


       Optional<Perfil> perfil = perfilRepository.findById(idPerfil);
        perfil.ifPresent(participante::setIdPerfil);

        participanteRepository.save(participante);
        return participanteMapper.map(participante);
    }
}
