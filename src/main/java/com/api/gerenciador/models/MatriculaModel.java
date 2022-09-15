package com.api.gerenciador.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="matricula")
public class MatriculaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codMatricula;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario", referencedColumnName = "codUsuario")
    private UsuarioModel usuario;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso", referencedColumnName = "codCurso")
    private CursoModel curso;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turma", referencedColumnName = "codTurma")
    private TurmaModel turma;

}
