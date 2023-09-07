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
@Table(name = "roletaregra")
public class RoletaRegra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "roletaid")
    private Roleta roleta;

    @Column(name = "corregra")
    private String corregra;

    @Column(name = "regra")
    private String regra;

    @Column(name = "saldoganha")
    private Long saldoganha;

    @Column(name = "tiporegra")
    private String tiporegra;

}
