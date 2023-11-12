package com.example.rollmoney.mapper;

import com.example.rollmoney.dto.ParticipanteDTO;
import com.example.rollmoney.dto.PerfilDTO;
import com.example.rollmoney.entity.Participante;
import com.example.rollmoney.entity.Perfil;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParticipanteMapper {

    ParticipanteDTO map(Participante participante);

    Participante map(ParticipanteDTO participante);
}
