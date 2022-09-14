package com.api.Gerenciador.services;

import com.api.Gerenciador.dtos.HorarioDTO;
import com.api.Gerenciador.models.HorarioModel;
import com.api.Gerenciador.repositories.HorarioRepository;
import com.api.Gerenciador.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioServiceImpl implements HorarioService {
    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

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
    public HorarioModel criarHorario(HorarioDTO horarioModel) {
        return horarioRepository.save(modelFromDto(horarioModel));
    }

    @Override
    public void deletarHorario(Integer codHorario) {
        horarioRepository.deleteById(codHorario);
    }

    private HorarioModel modelFromDto(HorarioDTO horarioDTO) {
        var horarioModel = new HorarioModel();

        horarioModel.setCodHorario(horarioDTO.getCodHorario());
        horarioModel.setHorario(horarioDTO.getHorario());
        horarioModel.setPeriodo(horarioDTO.getPeriodo());
        horarioModel.setDiaDaSemana(horarioDTO.getDiaDaSemana());
        horarioModel.setProfessor(usuarioRepository.getReferenceById(horarioDTO.getProfessor()));

        return horarioModel;
    }
}
