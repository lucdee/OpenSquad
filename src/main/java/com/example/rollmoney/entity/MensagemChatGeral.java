package com.example.rollmoney.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mensagemchatgeral")
public class MensagemChatGeral {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuarioid")
    private Usuario usuario;

    @Column(name = "mensagem")
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "chatid")
    private ChatGeral chatgeral;

    @Column(name = "dataenvio")
    private String dataenvio;
}
