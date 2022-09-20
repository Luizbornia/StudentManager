package com.api.gerenciador.dtos;


import com.api.gerenciador.models.MatriculaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class NotaDTO {

    @NotBlank
    private Integer semestre;
    @NotBlank
    private Float notaProvaUm;
    @NotBlank
    private Float notProvaDois;
    @NotBlank
    private Float notaProvaFinal;
    @NotBlank
    private Float notaFinal;
    /*@NotBlank
    private MatriculaModel matricula;*/
}
