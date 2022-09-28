package com.api.gerenciador.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="Usuario")
public class UsuarioModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codUsuario;
    @Enumerated(EnumType.STRING)
    private FuncaoEnum funcao;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false, unique = true)
    private String rg;
    @Column(nullable = false,length = 100)
    private String cidade;
    @Column(nullable = false, length = 100)
    private String bairro;
    @Column(nullable = false)
    private String numero;
    @Column(length = 140)
    private String complemento;

}
