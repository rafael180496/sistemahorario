package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Carrera;

import java.util.ArrayList;

public interface CarreraService {
    Iterable<Carrera> listarCarrera();
    ArrayList<Carrera> listaCarrera();
    ArrayList<Carrera> filtrarCarrera(String name);
    Carrera BuscarUno(Long  id);
    void  EliminarCarrera(Long id);
    void  GuardarCarrera(Carrera carrera);
    Long  Secuencia();
}
