package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Usuario;

import java.util.ArrayList;

public interface UsuarioService {
    Iterable<Usuario> listarUsuarios();
    public Usuario getUsuarioById(Long id);
    ArrayList<Usuario> listaUsuarios();
    public Usuario Ingresar(String usuario,String Clave);
    public  boolean Recuperacion(String correo);
    public boolean Cambiar_clave(Long id,String clave);
    void  EliminarUsuario(Long id);
    void  GuardarUsuario(Usuario usuario);
    Long  Secuencia();
    ArrayList<Usuario> filtrarUsuario(String name);
}
