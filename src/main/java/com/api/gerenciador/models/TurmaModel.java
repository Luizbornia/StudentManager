package com.api.gerenciador.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="turma")
public class TurmaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codTurma;
    @Column(nullable = false,unique = true)
    private String numeracao;
    @Column(nullable = false)
    private String periodo;
    @Column(nullable = false)
    private String semestre;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario", referencedColumnName = "codCurso")
    private CursoModel curso;

}
