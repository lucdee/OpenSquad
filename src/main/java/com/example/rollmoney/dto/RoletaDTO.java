package com.example.rollmoney.dto;

import com.example.rollmoney.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigInteger;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class RoletaDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("corrodada")
    private String corrodada;

    @JsonProperty("usuariodono")
    private Usuario usuariodono;

    @JsonProperty("datacriada")
    private String datacriada;

    @JsonProperty("entrada")
    private BigInteger entrada;

    @JsonProperty("nome")
    private String nome;



}
