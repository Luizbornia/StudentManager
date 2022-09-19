package com.api.gerenciador.dtos;

import com.api.gerenciador.models.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class HorarioDTO {

    @NotBlank
    private String diaDaSemana;
    @NotBlank
    private String periodo;
    @NotBlank
    private String horario;
    @NotNull
    private UsuarioModel professor;
}
