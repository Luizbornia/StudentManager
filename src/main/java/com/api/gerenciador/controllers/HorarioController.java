package com.api.gerenciador.controllers;

import com.api.gerenciador.dtos.HorarioDTO;
import com.api.gerenciador.models.HorarioModel;
import com.api.gerenciador.services.HorarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gerenciador")
public class HorarioController {

    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    //Metodo para criar horario
    @PostMapping("/horario")
    public ResponseEntity<Object> salvaHorario(@Valid @RequestBody HorarioDTO horarioDTO) {
        var horarioModel = new HorarioModel();
        BeanUtils.copyProperties(horarioDTO,horarioModel); //Copia as propriedades do DTO para o Model
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioService.criarHorario(horarioModel));
    }

    //Metodo para deletar horario
    @DeleteMapping("/horario/{codHorario}")
    public ResponseEntity<HorarioModel> deletarHorario(@PathVariable Integer codHorario) {
        horarioService.deletarHorario(codHorario);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //Metodo para atualizar horario
    @PutMapping("/horario/{codHorario}")
    public ResponseEntity<HorarioModel> atualizarHorario(@PathVariable Integer codHorario, @RequestBody @Valid HorarioDTO horarioDTO){
        var horarioInformado = horarioService.getHorarioById(codHorario);
        if(horarioInformado.isPresent()){
            HorarioModel horarioAtualizado = horarioInformado.get();
            BeanUtils.copyProperties(horarioDTO,horarioAtualizado);
            return ResponseEntity.status(HttpStatus.OK).body(horarioService.atualizarHorario(horarioAtualizado));
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //Metodo para listar todos horarios
    @GetMapping("/horario")
    public ResponseEntity<List<HorarioModel>> listarHorarios() {
        return ResponseEntity.status(HttpStatus.OK).body(horarioService.listarHorarios());
    }

    //Metodo para listar um horario por ID
    @GetMapping("/horario/{codHorario}")
    public ResponseEntity<Optional<HorarioModel>> listarHorarioPorId(@PathVariable Integer codHorario) {
        return ResponseEntity.status(HttpStatus.OK).body(horarioService.getHorarioById(codHorario));
    }


}
