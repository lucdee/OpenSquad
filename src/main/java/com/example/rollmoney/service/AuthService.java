package com.example.rollmoney.service;

import com.example.rollmoney.dto.auth.AutenticadorDTO;
import com.example.rollmoney.dto.auth.AutenticadorResponseDTO;

public interface AuthService {


  AutenticadorResponseDTO autenticar(AutenticadorDTO autenticadorDTO);
}
