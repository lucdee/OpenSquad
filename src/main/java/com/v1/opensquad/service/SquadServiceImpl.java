package com.v1.opensquad.service;

import com.v1.opensquad.dto.ParticipanteDTO;
import com.v1.opensquad.dto.SquadDTO;
import com.v1.opensquad.entity.Autenticacao;
import com.v1.opensquad.entity.Squad;
import com.v1.opensquad.mapper.SquadMapper;
import com.v1.opensquad.repository.AutenticacaoRepository;
import com.v1.opensquad.repository.PerfilRepository;
import com.v1.opensquad.repository.SquadRepository;
import com.v1.opensquad.service.exception.AuthDataException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SquadServiceImpl implements SquadService{

    public final SquadRepository squadRepository;

    public final AutenticacaoRepository autenticacaoRepository;

    public final PerfilRepository perfilRepository;

    public final ParticipanteService participanteService;

    public final SquadMapper squadMapper;

    @Override
    public SquadDTO save(String token, SquadDTO squadDTO, Long idPerfil, String funcaoCriador, Integer cargaHoraria) {
       Autenticacao autenticacao = autenticacaoRepository.findByToken(token);
       if(autenticacao == null){
           throw new AuthDataException("Token não existente");
       }
        squadDTO.setStatus("A");
        squadDTO.setDataCriacao(String.valueOf(LocalDateTime.now()));
        Squad squad = squadRepository.save(squadMapper.map(squadDTO));

        ParticipanteDTO participanteDTO = new ParticipanteDTO();
       participanteDTO.setIdSquad(squadMapper.map(squad));
       participanteDTO.setDataEntrada(String.valueOf(LocalDateTime.now()));
       participanteDTO.setFuncao(funcaoCriador);
       participanteDTO.setStatus("D");
       participanteDTO.setCargaHoraria(cargaHoraria);
       participanteDTO.setParticipacao(100);
       try {
           participanteService.save(token, idPerfil, participanteDTO);
       }catch (Exception e){
           squadRepository.deleteById(squad.getId());
       }
     return squadMapper.map(squad);
    }
}
