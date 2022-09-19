package com.api.gerenciador.services;

import com.api.gerenciador.models.HorarioModel;

import java.util.List;
import java.util.Optional;

public interface HorarioService {
    public List<HorarioModel> listarHorarios();

    public Optional<HorarioModel> getHorarioById(Integer codHorario);

    public HorarioModel criarHorario(HorarioModel horarioModel);

    public void deletarHorario(Integer codHorario);

    public HorarioModel atualizarHorario(HorarioModel horarioModel);
}
