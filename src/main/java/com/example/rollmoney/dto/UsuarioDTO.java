package com.example.rollmoney.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class UsuarioDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nomecompleto")
    private String nomecompleto;

    @JsonProperty("nomeusuario")
    private String nomeusuario;

    @JsonProperty("email")
    private String email;

    @JsonProperty("senha")
    private String senha;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("datanascimento")
    private LocalDate datanascimento;

    @JsonProperty("dataregistro")
    private LocalDate dataregistro;

    @JsonProperty("level")
    private Long level;

}
