package com.api.gerenciador.repositories;

import com.api.gerenciador.models.HorarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<HorarioModel, Integer> {
}
