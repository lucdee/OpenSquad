package com.example.rollmoney.controller;

import com.example.rollmoney.dto.UsuarioDTO;
import com.example.rollmoney.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<String> save(
            @RequestParam("senha") String senha,
            @RequestParam("email") String email,
            @RequestParam("cpf") String cpf,
            @RequestBody UsuarioDTO usuarioDTO){

        return ResponseEntity.ok(usuarioService.save(usuarioDTO, senha,email,cpf));
    }

    @GetMapping("/find")
    public ResponseEntity<UsuarioDTO> findByNomeUsuario(
            @RequestParam("nomeusuario") String nomeusuario){

        return ResponseEntity.ok(usuarioService.findByNomeUsuario(nomeusuario));
    }
}
