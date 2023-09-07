package com.example.rollmoney.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roleta")
public class Roleta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    @Column(name = "ID")
    private Long id;

    @Column(name = "corrodada")
    private String corrodada;

    @ManyToOne
    @JoinColumn(name = "usuariodono")
    private Usuario usuariodono;

    @Column(name = "datacriada")
    private String datacriada;

    @Column(name = "entrada")
    private BigInteger entrada;

    @Column(name = "nome")
    private String nome;

}
