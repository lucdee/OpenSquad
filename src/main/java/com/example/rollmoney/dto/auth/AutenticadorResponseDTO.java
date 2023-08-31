package com.example.rollmoney.dto.auth;

import com.example.rollmoney.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class AutenticadorResponseDTO {

    @JsonProperty("token")
    private String token;

    @JsonProperty("usuarioDTO")
    private UsuarioDTO usuarioDTO;

    @JsonProperty("duracao")
    private String duracao;
}
