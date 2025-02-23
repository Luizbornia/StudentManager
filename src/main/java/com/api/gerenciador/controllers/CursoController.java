package com.api.gerenciador.controllers;

import com.api.gerenciador.dtos.CursoDTO;
import com.api.gerenciador.models.CursoModel;
import com.api.gerenciador.services.CursoService;
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
public class CursoController {

    @Autowired
    CursoService cursoService;

    //Metodo para listar todas as curso
    @GetMapping("/curso")
    public ResponseEntity<List<CursoModel>> listarCursos() {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.listarCursos());
    }

    //Metodo para listar curso por ID
    @GetMapping("/curso/{codCurso}")
    public ResponseEntity<Optional<CursoModel>> listarCursoPorId(@PathVariable Integer codCurso) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.getCursoById(codCurso));
    }

    //Metodo para criar curso
    @PostMapping("/curso")
    public ResponseEntity<CursoModel> salvarCurso(@RequestBody @Valid CursoDTO cursoDTO) {
        var cursoModel = new CursoModel();
        BeanUtils.copyProperties(cursoDTO,cursoModel); //Converte DTO para Model
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.criarCurso(cursoModel));
    }

    //Metodo para deletar curso
    @DeleteMapping("/curso/{codCurso}")
    public ResponseEntity<String> deletarCurso(@PathVariable Integer codCurso) {
        cursoService.deletarCurso(codCurso);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso");
    }

    @PutMapping("/curso/{codCurso}")
    public ResponseEntity<CursoModel> atualizarCurso(@PathVariable Integer codCurso, @RequestBody @Valid CursoDTO cursoDTO){
        var cursoInformado = cursoService.getCursoById(codCurso);
        if(cursoInformado.isPresent()){
            var cursoModel = cursoInformado.get();
            BeanUtils.copyProperties(cursoDTO,cursoModel);
            return ResponseEntity.status(HttpStatus.OK).body(cursoService.atualizarCurso(cursoModel));
        }
        return ResponseEntity.notFound().build();
    }


}
