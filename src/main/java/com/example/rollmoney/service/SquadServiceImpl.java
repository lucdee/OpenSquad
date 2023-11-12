package com.example.rollmoney.service;

import com.example.rollmoney.dto.ParticipanteDTO;
import com.example.rollmoney.dto.SquadDTO;
import com.example.rollmoney.entity.Autenticacao;
import com.example.rollmoney.entity.Participante;
import com.example.rollmoney.entity.Perfil;
import com.example.rollmoney.entity.Squad;
import com.example.rollmoney.mapper.SquadMapper;
import com.example.rollmoney.repository.AutenticacaoRepository;
import com.example.rollmoney.repository.PerfilRepository;
import com.example.rollmoney.repository.SquadRepository;
import com.example.rollmoney.service.exception.AuthDataException;
import com.example.rollmoney.service.exception.ProfileDataException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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
