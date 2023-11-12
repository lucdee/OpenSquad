package com.example.rollmoney.controller;

import com.example.rollmoney.dto.PerfilDTO;
import com.example.rollmoney.dto.RetornoPerfilDTO;
import com.example.rollmoney.dto.auth.AutenticacaoDTO;
import com.example.rollmoney.dto.auth.AutenticacaoRetornoDTO;
import com.example.rollmoney.service.AutenticacaoService;
import com.example.rollmoney.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AuthController {

    private final AutenticacaoService autenticacaoService;

    @PostMapping()
    public ResponseEntity<AutenticacaoRetornoDTO> save(@RequestBody AutenticacaoDTO autenticacaoDTO) {
        return ResponseEntity.ok(autenticacaoService.auth(autenticacaoDTO));
    }

    @GetMapping("/verificar")
    public ResponseEntity<RetornoPerfilDTO> save(@RequestParam("token") String token) {
        return ResponseEntity.ok(autenticacaoService.verificar(token));
    }
}
