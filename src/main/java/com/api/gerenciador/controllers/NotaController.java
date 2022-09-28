package com.api.gerenciador.controllers;

import com.api.gerenciador.dtos.NotaDTO;
import com.api.gerenciador.models.NotaModel;
import com.api.gerenciador.services.MatriculaService;
import com.api.gerenciador.services.NotaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gerenciador")
public class NotaController {

    final
    NotaService notaService;
    MatriculaService matriculaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    //Metodo para listar todas as nota
    @GetMapping("/nota")
    public ResponseEntity<List<NotaModel>> listarCursos() {
        return ResponseEntity.status(HttpStatus.OK).body(notaService.listarNotas());
    }

    //Metodo para listar nota por ID
    @GetMapping("/nota/{codNota}")
    public ResponseEntity<Optional<NotaModel>> listarCursoPorId(@PathVariable Integer codNota) {
        return ResponseEntity.status(HttpStatus.OK).body(notaService.getNotaById(codNota));
    }

    //Metodo para listar nota por Matricula
    @GetMapping("/nota/matricula/{codMatricula}")
    public ResponseEntity<Optional<NotaModel>> listarCursoPorMatricula(@PathVariable Integer codMatricula) {
        return ResponseEntity.status(HttpStatus.OK).body(notaService.getNotasByMatricula(codMatricula));
    }

    //Metodo para criar nota
    @PostMapping("/nota")
    public ResponseEntity<NotaModel> salvarCurso(@RequestBody @Valid NotaDTO notaDTO) {
        var notaModel = new NotaModel();
        BeanUtils.copyProperties(notaDTO,notaModel); //Converte DTO para Model
        float notaFinal = (notaDTO.getNotaProvaUm()+notaDTO.getNotaProvaDois()+ notaDTO.getNotaProvaFinal())/3;
        if (notaFinal!=0){
            notaModel.setNotaFinal(notaFinal);
        }else {
            notaModel.setNotaFinal(0.0F);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(notaService.criarNota(notaModel));
    }

    //Metodo para deletar nota
    @DeleteMapping("/nota/{codNota}")
    public ResponseEntity<String> deletarCurso(@PathVariable Integer codNota) {
        notaService.deletarNota(codNota);
        return ResponseEntity.status(HttpStatus.OK).body("Nota deletada com sucesso");
    }

    @PutMapping("/nota/{codNota}")
    public ResponseEntity<NotaModel> atualizarCurso(@PathVariable Integer codNota, @RequestBody @Valid NotaDTO notaDTO){
        var NotaInformado = notaService.getNotaById(codNota);
        if(NotaInformado.isPresent()){
            var notaModel = NotaInformado.get();
            BeanUtils.copyProperties(notaDTO,notaModel);
            float notaFinal = (notaDTO.getNotaProvaUm()+notaDTO.getNotaProvaDois()+ notaDTO.getNotaProvaFinal())/3;
            if (notaFinal!=0){
                notaModel.setNotaFinal(notaFinal);
            }else {
                notaModel.setNotaFinal(0.0F);
            }
            return ResponseEntity.status(HttpStatus.OK).body(notaService.atualizarNota(notaModel));
        }
        return ResponseEntity.notFound().build();
    }

}
