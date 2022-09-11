package com.api.gerenciador.services;

import com.api.gerenciador.repositories.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {
    @Autowired
    HorarioRepository horarioRepository;
}
