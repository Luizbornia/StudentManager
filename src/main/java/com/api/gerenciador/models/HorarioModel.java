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
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UsuarioModel", referencedColumnName = "codUsuario")
    private UsuarioModel codUsuario;

}
