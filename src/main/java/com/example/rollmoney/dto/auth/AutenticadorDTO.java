package com.example.rollmoney.dto.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class AutenticadorDTO {

    @JsonProperty("usuario")
    private String usuario;

    @JsonProperty("senha")
    private String senha;
}
