package com.api.gerenciador.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name="curso")
public class CursoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codCurso;
    @Column(nullable = false,length = 140)
    private String descricao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario", referencedColumnName = "codUsuario")
    private UsuarioModel professor;

}
