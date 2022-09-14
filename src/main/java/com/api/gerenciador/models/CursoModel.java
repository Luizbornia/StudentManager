package com.api.gerenciador.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name="Curso")
public class CursoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codCurso;
    @Column(nullable = false,length = 140)
    private String descricao;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UsuarioModel", referencedColumnName = "codUsuario")
    private UsuarioModel professor;

}
