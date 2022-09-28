package com.api.gerenciador.dtos;

import com.api.gerenciador.models.CursoModel;
import com.api.gerenciador.models.TurmaModel;
import com.api.gerenciador.models.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaDTO {

    @NotBlank
    private Integer codMatricula;

    /*@NotBlank
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario", referencedColumnName = "codUsuario")
    private UsuarioModel usuario;

    @NotBlank
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso", referencedColumnName = "codCurso")
    private CursoModel curso;

    @NotBlank
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turma", referencedColumnName = "codTurma")
    private TurmaModel turma;
*/
}
