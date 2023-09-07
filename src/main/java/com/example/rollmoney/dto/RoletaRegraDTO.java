package com.example.rollmoney.dto;

import com.example.rollmoney.entity.Roleta;
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
public class RoletaRegraDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("roleta")
    private RoletaDTO roleta;

    @JsonProperty("corregra")
    private String corregra;

    @JsonProperty("regra")
    private String regra;

    @JsonProperty("saldoganha")
    private Long saldoganha;

    @JsonProperty("tiporegra")
    private String tiporegra;



}
