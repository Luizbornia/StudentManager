package com.api.gerenciador.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="Matricula")
public class MatriculaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codMatricula;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UsuarioModel", referencedColumnName = "codUsuario")
    private UsuarioModel usuario;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CursoModel", referencedColumnName = "codCurso")
    private CursoModel curso;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TurmaModel", referencedColumnName = "codTurma")
    private TurmaModel turma;

}
