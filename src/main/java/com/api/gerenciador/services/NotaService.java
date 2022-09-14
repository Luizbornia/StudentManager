package com.api.gerenciador.services;

import com.api.gerenciador.models.NotaModel;
import com.api.gerenciador.models.UsuarioModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface NotaService {
    public List<NotaModel> listarNotas();

    public Optional<NotaModel> getNotaById(Integer codNotas);

    public NotaModel criarNota(NotaModel notaModel);

}
