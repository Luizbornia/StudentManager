package com.api.gerenciador.services;

import com.api.gerenciador.models.HorarioModel;
import com.api.gerenciador.repositories.HorarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioServiceImpl implements HorarioService {
    private final HorarioRepository horarioRepository;

    public HorarioServiceImpl(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    @Override
    public List<HorarioModel> listarHorarios() {
        return horarioRepository.findAll();
    }

    @Override
    public Optional<HorarioModel> getHorarioById(Integer codHorario) {
        return horarioRepository.findById(codHorario);
    }

    @Override
    public HorarioModel criarHorario(HorarioModel horarioModel) {
        return horarioRepository.save(horarioModel);
    }

    @Override
    public void deletarHorario(Integer codHorario) {
        horarioRepository.deleteById(codHorario);
    }

    @Override
    public HorarioModel atualizarHorario(HorarioModel horarioModel){
        return horarioRepository.save(horarioModel);
    };
}
