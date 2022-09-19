package com.api.gerenciador.controllers;


import com.api.gerenciador.dtos.TurmaDTO;
import com.api.gerenciador.services.TurmaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.gerenciador.models.TurmaModel;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gerenciador")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    //Metodo para listar todas as Turmas
    @GetMapping("/turma")
    public ResponseEntity<List<TurmaModel>> listarturma() {
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.listarTurma());
    }

    //Metodo para listar turma por ID
    @GetMapping("/turma/{codTurma}")
    public ResponseEntity<Optional<TurmaModel>> listarTurmaPorId(@PathVariable Integer codTurma) {
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.getTurmaById(codTurma));
    }

    //Metodo para criar turma
    @PostMapping("/turma")
    public ResponseEntity<TurmaModel> salvaTurma(@RequestBody @Valid TurmaDTO turmaDTO) {
        var turmaModel = new TurmaModel();
        BeanUtils.copyProperties(turmaDTO,turmaModel); //Converte DTO para Model
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.criarTurma(turmaModel));
    }

    //Metodo para deletar turma
    @DeleteMapping("/turma/{codTurma}")
    public ResponseEntity<String> deletarTurma(@PathVariable Integer codTurma) {
        turmaService.deletarTurma(codTurma);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso");
    }

    @PutMapping("/turma/{codTurma}")
    public ResponseEntity<TurmaModel> atualizarTurma(@PathVariable Integer codTurma, @RequestBody @Valid TurmaDTO turmaDTO){
       var turmaInformada = turmaService.getTurmaById(codTurma);
       if(turmaInformada.isPresent()){
           var turmaModel = turmaInformada.get();
           BeanUtils.copyProperties(turmaDTO,turmaModel);
           return ResponseEntity.status(HttpStatus.OK).body(turmaService.atualizarTurma(turmaModel));
       }
     return ResponseEntity.notFound().build();
    }
}
