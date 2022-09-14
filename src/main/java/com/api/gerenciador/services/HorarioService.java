package com.api.Gerenciador.services;

import com.api.Gerenciador.dtos.HorarioDTO;
import com.api.Gerenciador.models.HorarioModel;

import java.util.List;
import java.util.Optional;

public interface HorarioService {
    public List<HorarioModel> listarHorarios();

    public Optional<HorarioModel> getHorarioById(Integer codHorario);

    public HorarioModel criarHorario(HorarioModel horarioModel);
    public HorarioModel criarHorario(HorarioDTO horarioModel);

    void deletarHorario(Integer codHorario);
}
