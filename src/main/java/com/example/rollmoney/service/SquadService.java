package com.example.rollmoney.service;

import com.example.rollmoney.dto.SquadDTO;

public interface SquadService {

    SquadDTO save(String token, SquadDTO squadDTO, Long idPerfil, String funcaoCriador, Integer cargaHoraria);
}
