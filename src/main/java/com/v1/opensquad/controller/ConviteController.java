package com.v1.opensquad.controller;


import com.v1.opensquad.dto.ConviteDTO;
import com.v1.opensquad.dto.SquadDTO;
import com.v1.opensquad.service.ConviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/convite")
public class ConviteController {

    private final ConviteService conviteService;

    @PostMapping()
    public ResponseEntity<ConviteDTO> save(@RequestBody ConviteDTO conviteDTO,
                                         @RequestHeader("token") String token,
                                         @RequestParam("usuario") String usuario,
                                         @RequestParam("idsquad") Long idsquad
    ) {
        return ResponseEntity.ok(conviteService.save(token, conviteDTO,usuario, idsquad));
    }

}
