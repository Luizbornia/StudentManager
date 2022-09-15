package com.api.gerenciador.dtos;

import com.api.gerenciador.models.CursoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

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
    @NotBlank
    private CursoModel curso;
}
