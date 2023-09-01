package com.example.rollmoney.mapper;

import com.example.rollmoney.dto.chat.MensagemChatGeralRetornoDTO;
import com.example.rollmoney.entity.MensagemChatGeral;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MensagemChatGeralMapper {

     MensagemChatGeralRetornoDTO  map(MensagemChatGeral mensagemChatGeral);

     List<MensagemChatGeralRetornoDTO>  map2(List<MensagemChatGeral> mensagemChatGeral);
}
