package com.api.gerenciador.controllers;


import com.api.gerenciador.dtos.UsuarioDTO;
import com.api.gerenciador.models.FuncaoEnum;
import com.api.gerenciador.models.UsuarioModel;
import com.api.gerenciador.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/gerenciador")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //Metodo para listar todos usuarios
    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioModel>> listarUsuarios(){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.listarUsuarios());
    }

    //Metodo para listar um usuario por ID
    @GetMapping("/usuario/{codUsuario}")
    public ResponseEntity<Optional<UsuarioModel>> listarUsuarioPorId(@PathVariable Integer codUsuario){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getUsuarioById(codUsuario));
    }
    //Metodo para criar usuario
    @PostMapping("/usuario")
    public ResponseEntity<UsuarioModel> salvaUsuario(@RequestBody UsuarioModel usuarioModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarUsuario(usuarioModel));
    }
    //Metodo para deletar usuario
    @DeleteMapping("/usuario/{codUsuario}")
    public ResponseEntity<String> deletarUsuario (@PathVariable Integer codUsuario){
        usuarioService.deletarUsuario(codUsuario);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso");
    }

    //Meotodo para update
    @PutMapping("/usuario/{codUsuario}")
    public ResponseEntity<Object> atualizarUsuario (@RequestBody UsuarioModel usuarioModel, @PathVariable Integer codUsuario) {
        Optional<UsuarioModel> usuario = usuarioService.getUsuarioById(codUsuario);
        if (usuario.isPresent()) { //Verificar se o usuario puxado existe
            UsuarioModel usuarioAtualizado = usuario.get(); //instancia um novo usuario recebendo a informações passadas no corpo
            usuarioAtualizado.setFuncao(usuarioModel.getFuncao());
            usuarioAtualizado.setNome(usuarioModel.getNome());
            usuarioAtualizado.setCidade(usuarioAtualizado.getCidade());
            usuarioAtualizado.setBairro(usuarioAtualizado.getBairro());
            usuarioAtualizado.setNumero(usuarioAtualizado.getNumero());
            usuarioAtualizado.setComplemento(usuarioAtualizado.getComplemento());
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.criarUsuario(usuarioAtualizado));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }
    }
    /* Deixar desabilitado por enquanto, com problemas de transferencia dos arquivos DTO para Model
    @PostMapping
    public ResponseEntity<UsuarioModel> criarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDTO,usuarioModel);
        usuarioModel.setFuncao(FuncaoEnum.valueOf(usuarioDTO.getFuncao()));
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarUsuario(usuarioModel));

    } */


}
