package com.api.gerenciador.services;

import com.api.gerenciador.models.UsuarioModel;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public List<UsuarioModel> listarUsuarios();

    public Optional<UsuarioModel> getUsuarioById(Integer codUsuario);

    public UsuarioModel criarUsuario(UsuarioModel usuarioModel);

    public void deletarUsuario(Integer codUsuario);

    public UsuarioModel atualizarUsuario(UsuarioModel usuarioModel);

}
