package com.api.gerenciador.services;

import com.api.gerenciador.models.CursoModel;


import java.util.List;
import java.util.Optional;

public interface CursoService{

    public CursoModel criarCurso(CursoModel cursoModel);

    public List<CursoModel> listarCursos();

    public Optional<CursoModel> getCursoById(Integer codCurso);

    public void deletarCurso(Integer codCurso);

    public CursoModel atualizarCurso(CursoModel cursoModel);

}
