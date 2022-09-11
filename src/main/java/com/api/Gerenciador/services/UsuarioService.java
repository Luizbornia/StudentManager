package com.api.gerenciador.services;

import com.api.gerenciador.models.UsuarioModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface UsuarioService {
    public List<UsuarioModel> listarUsuarios();

    public Optional<UsuarioModel> getUsuarioById(Integer codUsuario);

    public UsuarioModel criarUsuario(UsuarioModel usuarioModel);

    void deletarUsuario(Integer codUsuario);
}
