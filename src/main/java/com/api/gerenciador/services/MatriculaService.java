package com.api.gerenciador.services;

import com.api.gerenciador.models.MatriculaModel;
import java.util.List;
import java.util.Optional;

public interface MatriculaService {
    public List<MatriculaModel> listarMatricula();

    public Optional<MatriculaModel> getMatriculaById(Integer codMatricula);

    public MatriculaModel criarMatricula(MatriculaModel matriculaModel);

    public MatriculaModel atualizarMatricula(MatriculaModel matriculaModel);

    public void deletarMatricula(Integer codMatricula);
}
