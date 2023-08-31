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
@Table(name = "autenticacao")
public class Autenticacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    @Column(name = "ID")
    private Long id;

    @Column(name = "token")
    private String token;

    @Column(name = "usuarioid")
    private Long usuarioid;

    @Column(name = "duracao")
    private String duracao;
}
