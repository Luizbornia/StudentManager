package com.api.gerenciador.controllers;

import com.api.gerenciador.dtos.MatriculaDTO;
import com.api.gerenciador.models.MatriculaModel;
import com.api.gerenciador.services.MatriculaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gerenciador")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("/matricula")
    public ResponseEntity<List<MatriculaModel>> listarMatricula(){
        return ResponseEntity.status(HttpStatus.OK).body(matriculaService.listarMatricula());
    }

    @GetMapping("/matricula/{codMatricula}")
    public ResponseEntity<Optional<MatriculaModel>> listarMatriculaPorId(@PathVariable Integer codMatricula){
        return ResponseEntity.status(HttpStatus.OK).body(matriculaService.getMatriculaById(codMatricula));
    }

    @PostMapping("/matricula")
    public ResponseEntity<MatriculaModel> salvaMatricula(@RequestBody @Valid MatriculaDTO matriculaDTO){
        var matriculaModel = new MatriculaModel();
        BeanUtils.copyProperties(matriculaDTO,matriculaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(matriculaService.criarMatricula(matriculaModel));
    }

    @PutMapping("/matricula/{codMatricula}")
    public ResponseEntity<MatriculaModel> atualizarMatricula(@PathVariable Integer codMatricula, @RequestBody @Valid MatriculaDTO matriculaDTO){
        var matriculaInformada = matriculaService.getMatriculaById(codMatricula);
        if (matriculaInformada.isPresent()){
            var matriculaModel = matriculaInformada.get();
            BeanUtils.copyProperties(matriculaDTO,matriculaModel);
            return ResponseEntity.status(HttpStatus.OK).body(matriculaService.atualizarMatricula(matriculaModel));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/matricula/{codMatricula}")
    public ResponseEntity<String> deletarMatricula(@PathVariable Integer codMatricula){
        matriculaService.deletarMatricula(codMatricula);
        return ResponseEntity.status(HttpStatus.OK).body("Matrícula deletada com sucesso!");
    }
}
