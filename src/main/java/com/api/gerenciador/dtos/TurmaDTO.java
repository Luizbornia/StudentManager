package com.api.gerenciador.dtos;

import com.api.gerenciador.models.CursoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurmaDTO {

    @NotBlank
    private String numeracao;
    @NotBlank
    private String periodo;
    @NotBlank
    private String semestre;
    /*
    @NotNull
    private Integer curso; */
}
