package com.api.gerenciador.services;

import com.api.gerenciador.models.CursoModel;
import com.api.gerenciador.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService{

    final
    CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public CursoModel criarCurso(CursoModel cursoModel) {
        return cursoRepository.save(cursoModel);
    }

    @Override
    public List<CursoModel> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<CursoModel> getCursoById(Integer codCurso) {
        return cursoRepository.findById(codCurso);
    }

    @Override
    public void deletarCurso(Integer codCurso) {
        cursoRepository.deleteById(codCurso);
    }

    @Override
    public CursoModel atualizarCurso(CursoModel cursoModel){
        return cursoRepository.save(cursoModel);
    }
}
