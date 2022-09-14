package com.api.gerenciador.services;

import com.api.gerenciador.models.NotaModel;
import com.api.gerenciador.repositories.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//
//@Service
//public class NotaServiceImpl implements NotaService {
//
//    @Autowired
//    private NotaRepository notaRepository;
//
//    @Override
//    public List<NotaModel> listarNotas() {
//        return notaRepository.findAll();
//    }
//
//    @Override
//    public List<NotaModel> getNotaById(Integer codNotas) {
//        return Optional.empty();
//    }
//
//    @Override
//    public NotaModel criarNota(NotaModel notaModel) {
//        return null;
//    }
//}
