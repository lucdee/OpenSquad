package com.example.rollmoney.dto.chat;

import com.example.rollmoney.dto.ChatGeralDTO;
import com.example.rollmoney.dto.UsuarioDTO;
import com.example.rollmoney.entity.ChatGeral;
import com.example.rollmoney.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class MensagemChatGeralRetornoDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("usuario")
    private UsuarioDTO usuario;

    @JsonProperty("mensagem")
    private String mensagem;

    @JsonProperty("chatgeral")
    private ChatGeralDTO chatgeral;

    @JsonProperty("dataenvio")
    private String dataenvio;

}
