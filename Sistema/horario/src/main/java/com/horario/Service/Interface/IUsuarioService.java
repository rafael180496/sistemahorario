package com.horario.Service.Interface;

import com.horario.Model.Usuario;

public interface IUsuarioService {

    public Iterable<Usuario> listAllUsuario();

    public Usuario getUsuarioById(long id);

    public Usuario saveUsuario(Usuario usuario);

    public void deleteUsuario(long id);
}
