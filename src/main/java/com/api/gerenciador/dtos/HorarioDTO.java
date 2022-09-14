package com.api.gerenciador.dtos;


import com.api.gerenciador.models.UsuarioModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

public class HorarioDTO {

    @NotBlank
    private String diaDaSemana;
    @NotBlank
    private String periodo;
    @NotBlank
    private String horario;
    @NotBlank
    private Integer codUsuario;
}
