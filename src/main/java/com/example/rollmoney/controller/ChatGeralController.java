package com.example.rollmoney.controller;

import com.example.rollmoney.dto.ChatGeralDTO;
import com.example.rollmoney.dto.chat.MensagemChatGeralDTO;
import com.example.rollmoney.dto.chat.MensagemChatGeralRetornoDTO;
import com.example.rollmoney.service.ChatGeralService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/chatgeral")
public class ChatGeralController {

    private final ChatGeralService chatGeralService;

    @PostMapping
    public ResponseEntity<ChatGeralDTO> save(
            @RequestBody ChatGeralDTO chatGeralDTO){
        return ResponseEntity.ok(chatGeralService.save(chatGeralDTO));
    }

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarmensagem(
            @RequestBody MensagemChatGeralDTO mensagemChatGeralDTO){
        return ResponseEntity.ok(chatGeralService.enviarmensagem(mensagemChatGeralDTO));
    }

    @GetMapping("/listarmensagens")
    public ResponseEntity<List<MensagemChatGeralRetornoDTO>> listarmensagens(
            @RequestParam("chatid") Long chatid){
        return ResponseEntity.ok(chatGeralService.listarmensagens(chatid));
    }
}
