package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.UsuarioK;

import java.util.ArrayList;

public interface UsuarioService {
    Iterable<UsuarioK> listarUsuarios();
    public UsuarioK getUsuarioById(Long id);
    ArrayList<UsuarioK> listaUsuarios();
    public UsuarioK Ingresar(String usuario,String Clave);
    public  boolean Recuperacion(String correo);
    public boolean Cambiar_clave(Long id,String clave);
    void  EliminarUsuario(Long id);
    void  GuardarUsuario(UsuarioK usuario);
    Long  Secuencia();
    ArrayList<UsuarioK> filtrarUsuario(String name);
}
