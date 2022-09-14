package com.api.gerenciador.services;

import com.api.gerenciador.models.TurmaModel;
import com.api.gerenciador.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaServiceImpl implements TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;

    public List<TurmaModel> listarTurma() {
        return turmaRepository.findAll();
    }

    @Override
    public Optional<TurmaModel> getTurmaById(Integer codTurma) {
        return turmaRepository.findById(codTurma);
    }

    @Override
    public TurmaModel criarTurma(TurmaModel turmaModel) {
        return turmaRepository.save(turmaModel);
    }

    @Override
    public void deletarTurma(Integer codTurma) {
        turmaRepository.deleteById(codTurma);
    }

}