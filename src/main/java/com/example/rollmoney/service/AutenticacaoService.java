package com.example.rollmoney.service;

import com.example.rollmoney.dto.RetornoPerfilDTO;
import com.example.rollmoney.dto.auth.AutenticacaoDTO;
import com.example.rollmoney.dto.auth.AutenticacaoRetornoDTO;

public interface AutenticacaoService {

    AutenticacaoRetornoDTO auth(AutenticacaoDTO autenticacaoDTO);

    RetornoPerfilDTO verificar(String token);

}
