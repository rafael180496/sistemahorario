package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.CarreraK;

import java.util.ArrayList;

public interface CarreraService {
    Iterable<CarreraK> listarCarrera();
    ArrayList<CarreraK> listaCarrera();
    ArrayList<CarreraK> filtrarCarrera(String name);
    CarreraK BuscarUno(Long  id);
    void  EliminarCarrera(Long id);
    void  GuardarCarrera(CarreraK carrera);
    Long  Secuencia();
}
