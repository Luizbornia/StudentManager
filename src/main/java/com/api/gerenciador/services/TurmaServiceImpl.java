package com.api.gerenciador.services;

import com.api.gerenciador.models.TurmaModel;
import com.api.gerenciador.repositories.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaServiceImpl implements TurmaService {
    private final TurmaRepository turmaRepository;

    public TurmaServiceImpl(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    @Override
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

    @Override
    public TurmaModel atualizarTurma(TurmaModel turmaModel){
        return turmaRepository.save(turmaModel);
    }

}
