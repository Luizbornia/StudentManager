package com.api.gerenciador.services;

import com.api.gerenciador.models.UsuarioModel;
import com.api.gerenciador.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioModel> listarUsuarios(){
        return usuarioRepository.findAll();
    }
    @Override
    public Optional<UsuarioModel> getUsuarioById(Integer codUsuario){
        return usuarioRepository.findById(codUsuario);
    }
    @Override
    public UsuarioModel criarUsuario(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);

    }
    @Override
    public void deletarUsuario(Integer codUsuario){
        usuarioRepository.deleteById(codUsuario);
    }

}
