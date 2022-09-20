package com.api.gerenciador.services;

import com.api.gerenciador.models.NotaModel;
import com.api.gerenciador.repositories.HorarioRepository;
import com.api.gerenciador.repositories.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class NotaServiceImpl implements NotaService{

    @Autowired
    NotaRepository notaRepository;

    @Override
    public NotaModel criarNota(NotaModel notaModel){
        return notaRepository.save(notaModel);
    }

    @Override
    public void deletarNota(Integer codNota){
        notaRepository.deleteById(codNota);
    }

    @Override
    public List<NotaModel> listarNotas(){
        return notaRepository.findAll();
    }

    @Override
    public Optional<NotaModel> getNotaById(Integer codNota){
        return notaRepository.findById(codNota);
    }

    @Override
    public Optional<NotaModel> getNotaByMatricula(Integer codMatricula){

    }

}
