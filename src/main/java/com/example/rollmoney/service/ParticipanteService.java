package com.example.rollmoney.service;

import com.example.rollmoney.dto.ParticipanteDTO;

public interface ParticipanteService {

   ParticipanteDTO save(String token, Long idPerfil, ParticipanteDTO participanteDTO);
}
