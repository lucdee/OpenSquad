package com.example.rollmoney.controller;

import com.example.rollmoney.dto.UsuarioDTO;
import com.example.rollmoney.dto.auth.AutenticadorDTO;
import com.example.rollmoney.dto.auth.AutenticadorResponseDTO;
import com.example.rollmoney.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<AutenticadorResponseDTO> autenticar(
            @RequestBody AutenticadorDTO autenticadorDTO){

        return ResponseEntity.ok(authService.autenticar(autenticadorDTO));
    }

    @GetMapping("/verificar")
    public ResponseEntity<UsuarioDTO> verificarUsuarioPorToken(
            @RequestParam("token") String token){
        return ResponseEntity.ok(authService.verificarUsuarioPorToken(token));
    }

}
