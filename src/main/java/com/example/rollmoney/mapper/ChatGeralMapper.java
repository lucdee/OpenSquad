package com.example.rollmoney.mapper;

import com.example.rollmoney.dto.ChatGeralDTO;
import com.example.rollmoney.entity.ChatGeral;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatGeralMapper {

    ChatGeralDTO map(ChatGeral chatGeral);

    ChatGeral map(ChatGeralDTO chatGeralDTO);
}
