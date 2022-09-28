package com.api.gerenciador.dtos;

import com.api.gerenciador.models.CursoModel;
import com.api.gerenciador.models.TurmaModel;
import com.api.gerenciador.models.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaDTO {

    @NotNull
    private UsuarioModel aluno;
    @NotNull
    private CursoModel curso;
    @NotNull
    private TurmaModel turma;
}
