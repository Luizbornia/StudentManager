package com.api.gerenciador.repositories;

import com.api.gerenciador.models.NotaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<NotaModel, Integer> {
}
