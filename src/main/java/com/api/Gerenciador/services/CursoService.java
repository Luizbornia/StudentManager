package com.api.gerenciador.services;

import com.api.gerenciador.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    @Autowired
    CursoRepository cursoRepository;
}
