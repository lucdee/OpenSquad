package com.example.rollmoney.controller;

import com.example.rollmoney.dto.CarteiraDTO;
import com.example.rollmoney.dto.auth.AutenticadorDTO;
import com.example.rollmoney.dto.auth.AutenticadorResponseDTO;
import com.example.rollmoney.service.CarteiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/carteira")
public class CarteiraController {

    private final CarteiraService carteiraService;

    @PostMapping
    public ResponseEntity<CarteiraDTO> save(
            @RequestParam("id") Long id){

        return ResponseEntity.ok(carteiraService.save(id));
    }
}
