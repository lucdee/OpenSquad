package com.example.rollmoney.controller;


import com.example.rollmoney.dto.RoletaDTO;
import com.example.rollmoney.dto.RoletaRegraDTO;
import com.example.rollmoney.entity.Roleta;
import com.example.rollmoney.mapper.RoletaRegraMapper;
import com.example.rollmoney.service.RoletaRegraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/roletaregra")
public class RoletaRegraController {

    private final RoletaRegraService roletaRegraService;

    @PostMapping
    public ResponseEntity<RoletaRegraDTO> save(
            @RequestBody RoletaRegraDTO roletaDTO,
            @RequestParam("idroleta") Long idRoleta,
            @RequestHeader("token") String token){

        return ResponseEntity.ok(roletaRegraService.save(roletaDTO,idRoleta ,token));
    }

    @GetMapping
    public ResponseEntity<List<RoletaRegraDTO>> save(
            @RequestParam("idroleta") Long idRoleta,
            @RequestHeader("token") String token){

        return ResponseEntity.ok(roletaRegraService.findByRoleta(idRoleta ,token));
    }

}
