package com.v1.opensquad.service;

import com.v1.opensquad.dto.ParticipanteDTO;

public interface ParticipanteService {

   ParticipanteDTO save(String token, Long idPerfil, ParticipanteDTO participanteDTO);
}
