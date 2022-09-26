package com.api.gerenciador.repositories;

import com.api.gerenciador.models.MatriculaModel;
import com.api.gerenciador.models.NotaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotaRepository extends JpaRepository<NotaModel, Integer> {

    @Query("SELECT * FROM notas WHERE notas.aluno = :#{#matricula.aluno}")
    public Optional<NotaModel> getNotasByMatricula(@Param("matricula")MatriculaModel matriculaModel);
}
