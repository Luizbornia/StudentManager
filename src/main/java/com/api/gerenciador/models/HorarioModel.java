package com.api.gerenciador.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="Horario")
public class HorarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codHorario;
    @Column(nullable = false,length = 50)
    private String diaDaSemana;
    @Column(nullable = false,length = 50)
    private String periodo;
    @Column(nullable = false,length = 50)
    private String horario;
    /*
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Turma",referencedColumnName = "codTurma")
    private TurmaModel turma; */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Usuario", referencedColumnName = "codUsuario")
    private UsuarioModel professor;

}
