package com.api.gerenciador.services;

import com.api.gerenciador.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {
    @Autowired
    MatriculaRepository matriculaRepository;
}
