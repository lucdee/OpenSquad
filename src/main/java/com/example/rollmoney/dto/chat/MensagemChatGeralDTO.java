package com.example.rollmoney.dto.chat;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class MensagemChatGeralDTO {

    @JsonProperty("usuarioid")
    private Long usuarioid;

    @JsonProperty("mensagem")
    private String mensagem;

    @JsonProperty("chatgeralid")
    private Long chatgeral;

    @JsonProperty("dataenvio")
    private String dataenvio;
}
