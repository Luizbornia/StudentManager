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
@Table(name="notas")
public class NotaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codNotas;
    @Column(nullable = false)
    private String materia;
    @Column(nullable = false)
    private String semestre;
    @Column(nullable = false)
    private Float notaProvaUm;
    @Column(nullable = false)
    private Float notaProvaDois;
    @Column(nullable = false)
    private Float notaProvaFinal;
    @Column(nullable = false)
    private Float notaFinal;
    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "matricula", referencedColumnName = "codMatricula")
    private MatriculaModel matricula;
}
