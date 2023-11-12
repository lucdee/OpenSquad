package com.v1.opensquad.mapper;

import com.v1.opensquad.dto.ParticipanteDTO;
import com.v1.opensquad.entity.Participante;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParticipanteMapper {

    ParticipanteDTO map(Participante participante);

    Participante map(ParticipanteDTO participante);
}
