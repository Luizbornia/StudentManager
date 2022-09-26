package com.api.gerenciador.services;

import com.api.gerenciador.models.MatriculaModel;
import com.api.gerenciador.models.NotaModel;

import java.util.List;
import java.util.Optional;

public interface NotaService {

    public NotaModel criarNota(NotaModel notaModel);

    public List<NotaModel> listarNotas();

    public Optional<NotaModel> getNotaById(Integer codNota);

    public void deletarNota(Integer codNota);

    public Optional<NotaModel> getNotasByMatricula(MatriculaModel matriculaModel);
}
