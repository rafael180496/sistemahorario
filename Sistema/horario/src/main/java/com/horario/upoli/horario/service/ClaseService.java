package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Clase;

import java.util.ArrayList;

public interface ClaseService {
    Iterable<Clase> listarClases();
    ArrayList<Clase> listaClase();
    ArrayList<Clase> filtrarClase(String name);
    Clase BuscarUno(Long  id);
    void  EliminarClase(Long id);
    void  GuardarClase(Clase clase);
    Long  Secuencia();
}
