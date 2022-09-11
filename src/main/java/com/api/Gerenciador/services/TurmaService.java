package com.api.gerenciador.services;

import com.api.gerenciador.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {
    @Autowired
    TurmaRepository turmaRepository;
}
