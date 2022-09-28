package com.api.gerenciador.dtos;


import com.api.gerenciador.models.MatriculaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class NotaDTO {

    @NotBlank
    private String semestre;
    @NotBlank
    private String materia;
    @NotNull
    private Float notaProvaUm;
    @NotNull
    private Float notaProvaDois;
    @NotNull
    private Float notaProvaFinal;
    @NotNull
    private MatriculaModel matricula;
}
