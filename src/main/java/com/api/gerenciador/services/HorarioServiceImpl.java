package com.api.gerenciador.services;

import com.api.gerenciador.models.HorarioModel;
import com.api.gerenciador.repositories.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioServiceImpl implements HorarioService {
    @Autowired
    private HorarioRepository horarioRepository;

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

}
