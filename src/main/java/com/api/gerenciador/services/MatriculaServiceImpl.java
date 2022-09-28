package com.api.gerenciador.services;

import com.api.gerenciador.models.MatriculaModel;
import com.api.gerenciador.repositories.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {
    private final MatriculaRepository matriculaRepository;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository){
        this.matriculaRepository = matriculaRepository;
    }

    @Override
    public List<MatriculaModel> listarMatricula() {
        return matriculaRepository.findAll();
    }

    @Override
    public Optional<MatriculaModel> getMatriculaById(Integer codMatricula) {
        return matriculaRepository.findById(codMatricula);
    }

    @Override
    public MatriculaModel criarMatricula(MatriculaModel matriculaModel) {
        return matriculaRepository.save(matriculaModel);
    }

    @Override
    public MatriculaModel atualizarMatricula(MatriculaModel matriculaModel) {
        return matriculaRepository.save(matriculaModel);
    }

    @Override
    public void deletarMatricula(Integer codMatricula) {
        matriculaRepository.deleteById(codMatricula);
    }
}
