package com.example.rollmoney.service;

import com.example.rollmoney.dto.RoletaDTO;

import java.util.List;

public interface RoletaService {

    RoletaDTO save(RoletaDTO roletaDTO, String token);

    List<RoletaDTO> listar(String token);

    RoletaDTO editar(RoletaDTO roletaDTO, Long idroleta,String token);

    String deletar(Long idroleta,String token);
}
