package com.example.rollmoney.service;


import com.example.rollmoney.dto.ChatGeralDTO;
import com.example.rollmoney.dto.chat.MensagemChatGeralDTO;
import com.example.rollmoney.dto.chat.MensagemChatGeralRetornoDTO;

import java.util.List;


public interface ChatGeralService{

    ChatGeralDTO save(ChatGeralDTO chatGeralDTO);

    String enviarmensagem(MensagemChatGeralDTO mensagemChatGeralDTO);

    List<MensagemChatGeralRetornoDTO> listarmensagens(Long mensagemchatid);
}
