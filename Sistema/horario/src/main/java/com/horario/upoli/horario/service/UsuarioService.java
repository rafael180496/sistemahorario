package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Usuario;

public interface UsuarioService {
    Iterable<Usuario> listarUsuarios();
    public Usuario getUsuarioById(Long id);
    public Usuario Ingresar(String usuario,String Clave);

}
