package com.example.rollmoney.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class ChatGeralDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nomechat")
    private String nomechat;
}
