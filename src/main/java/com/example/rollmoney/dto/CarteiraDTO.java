package com.example.rollmoney.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class CarteiraDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("usuarioDTO")
    private UsuarioDTO usuario;

    @JsonProperty("saldo")
    private BigInteger saldo;
}
