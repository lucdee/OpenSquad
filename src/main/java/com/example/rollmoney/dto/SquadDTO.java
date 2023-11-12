package com.example.rollmoney.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class SquadDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String imgSquad;
    private String area;
    private String dataCriacao;
    private String status;
}
