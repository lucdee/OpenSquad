package com.example.rollmoney.dto.auth;

import com.example.rollmoney.dto.PerfilDTO;
import com.example.rollmoney.dto.RetornoPerfilDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class AutenticacaoRetornoDTO {

    private String token;

    private RetornoPerfilDTO retornoPerfilDTO;
}
