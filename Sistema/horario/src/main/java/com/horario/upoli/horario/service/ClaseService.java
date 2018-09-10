package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.ClaseK;

import java.util.ArrayList;

public interface ClaseService {
    Iterable<ClaseK> listarClases();
    ArrayList<ClaseK> listaClase();
    ArrayList<ClaseK> filtrarClase(String name);
    ClaseK BuscarUno(Long  id);
    void  EliminarClase(Long id);
    void  GuardarClase(ClaseK clase);
    Long  Secuencia();
}
