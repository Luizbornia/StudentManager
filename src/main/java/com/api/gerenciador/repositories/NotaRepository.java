package com.api.gerenciador.repositories;

import com.api.gerenciador.models.NotaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotaRepository extends JpaRepository<NotaModel, Integer> {

    @Query(value = "SELECT * FROM notas n WHERE n.matricula = :#{#matricula}", nativeQuery = true)
    public Optional<NotaModel> getNotasByMatricula(@Param("matricula")Integer codMatricula);

}
