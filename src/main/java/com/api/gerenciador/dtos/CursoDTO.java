package com.api.gerenciador.dtos;

import com.api.gerenciador.models.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CursoDTO {

    @NotBlank
    private String descricao;
    @NotNull
    private UsuarioModel professor;


}
