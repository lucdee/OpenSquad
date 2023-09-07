package com.example.rollmoney.service;

import com.example.rollmoney.dto.RoletaRegraDTO;

import java.util.List;

public interface RoletaRegraService {

    RoletaRegraDTO save(RoletaRegraDTO roletaRegraDTO,Long idroleta ,String token);

    List<RoletaRegraDTO> findByRoleta(Long idroleta ,String token);
}
