package com.example.rollmoney.controller;

import com.example.rollmoney.dto.CarteiraDTO;
import com.example.rollmoney.dto.RoletaDTO;
import com.example.rollmoney.service.RoletaService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/roleta")
public class RoletaController {

    private final RoletaService roletaService;

    @PostMapping
    public ResponseEntity<RoletaDTO> save(
            @RequestBody RoletaDTO roletaDTO,
            @RequestHeader("token") String token){

        return ResponseEntity.ok(roletaService.save(roletaDTO, token));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<RoletaDTO>> listar(
            @RequestHeader("token") String token){

        return ResponseEntity.ok(roletaService.listar(token));
    }

    @PutMapping("/editar")
    public ResponseEntity<RoletaDTO> listar(
            @RequestBody RoletaDTO roletaDTO,
            @RequestParam("idroleta") Long idRoleta,
            @RequestHeader("token") String token){

        return ResponseEntity.ok(roletaService.editar(roletaDTO, idRoleta ,token));
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<String> listar(
            @RequestParam("idroleta") Long idRoleta,
            @RequestHeader("token") String token){

        return ResponseEntity.ok(roletaService.deletar(idRoleta ,token));
    }
}
