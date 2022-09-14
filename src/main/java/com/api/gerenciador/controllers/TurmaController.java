package com.api.Gerenciador.controllers;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.gerenciador.models.TurmaModel;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/gerenciador")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    //Metodo para listar todas as Turmas
    @GetMapping("/turma")
    public ResponseEntity<List<TurmaModel>> listarturma() {
    	var turmaModel = new TurmaModel();
        BeanUtils.copyProperties(turmaDTO,turmaModel);
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.listarturma());
    }

    //Metodo para listar turma por ID
    @GetMapping("/turma/{codTurma}")
    public ResponseEntity<Optional<TurmaModel>> listarTurmaPorId(@PathVariable Integer codTurma) {
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.getHorarioById(codTurma));
    }

    //Metodo para criar turma
    @PostMapping("/turma")
    public ResponseEntity<TurmaModel> salvaTurma(@RequestBody TurmaDTO turmaModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.criarTurma(turmaModel));
    }

    //Metodo para deletar turma
    @DeleteMapping("/turma/{codTurma}")
    public ResponseEntity<String> deletarTurma(@PathVariable Integer codTurma) {
        turmaService.deletarTurma(codTurma);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso");
    }
}
