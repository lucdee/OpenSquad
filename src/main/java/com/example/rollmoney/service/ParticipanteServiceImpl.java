package com.example.rollmoney.service;
import com.example.rollmoney.dto.ParticipanteDTO;
import com.example.rollmoney.entity.Autenticacao;
import com.example.rollmoney.entity.Participante;
import com.example.rollmoney.entity.Perfil;
import com.example.rollmoney.mapper.ParticipanteMapper;
import com.example.rollmoney.repository.AutenticacaoRepository;
import com.example.rollmoney.repository.ParticipanteRepository;
import com.example.rollmoney.repository.PerfilRepository;
import com.example.rollmoney.service.exception.AuthDataException;
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
