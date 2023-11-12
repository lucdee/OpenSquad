package com.example.rollmoney.controller;

import com.example.rollmoney.dto.PerfilDTO;
import com.example.rollmoney.dto.SquadDTO;
import com.example.rollmoney.service.PerfilService;
import com.example.rollmoney.service.SquadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/squad")
public class SquadController {
    private final SquadService squadService;

    @PostMapping()
    public ResponseEntity<SquadDTO> save(@RequestBody SquadDTO squadDTO,
                                         @RequestHeader("token") String token,
                                         @RequestParam("idperfil") Long idPerfil,
                                         @RequestParam("funcao-criador") String funcaoCriador,
                                         @RequestParam("carga-horaria") Integer cargaHoraria
                                         ) {
        return ResponseEntity.ok(squadService.save(token, squadDTO, idPerfil, funcaoCriador, cargaHoraria));
    }
}
