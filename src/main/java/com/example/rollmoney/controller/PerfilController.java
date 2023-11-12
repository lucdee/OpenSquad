package com.example.rollmoney.controller;

import com.example.rollmoney.dto.PerfilDTO;
import com.example.rollmoney.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/perfil")
public class PerfilController {

    private final PerfilService perfilService;

    @PostMapping()
    public ResponseEntity<PerfilDTO> save(@RequestBody PerfilDTO perfilDto) {
        return ResponseEntity.ok(perfilService.save(perfilDto));
    }

}
