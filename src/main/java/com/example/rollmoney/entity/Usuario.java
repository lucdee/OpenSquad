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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    @Column(name = "ID")
    private Long id;

    @Column(name = "nomecompleto")
    private String nomecompleto;

    @Column(name = "nomeusuario")
    private String nomeusuario;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "datanascimento")
    private String datanascimento;

    @Column(name = "dataregistro")
    private String dataregistro;

    @Column(name = "level")
    private Long level;
}
