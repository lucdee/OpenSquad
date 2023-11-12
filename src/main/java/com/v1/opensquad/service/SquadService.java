package com.v1.opensquad.service;

import com.v1.opensquad.dto.SquadDTO;

public interface SquadService {

    SquadDTO save(String token, SquadDTO squadDTO, Long idPerfil, String funcaoCriador, Integer cargaHoraria);
}
