package com.api.gerenciador.repositories;

import com.api.gerenciador.models.HorarioModel;
import com.api.gerenciador.models.NotaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotaRepository extends JpaRepository<NotaModel, Integer> {

    @Query("SELECT * FROM notas WHERE notas.codMatricula = :#{#horario.aluno.getCodMatricula}")
    public Optional<HorarioModel> getNotasByMatricula(@Param("customer") HorarioModel horarioModel);
}
