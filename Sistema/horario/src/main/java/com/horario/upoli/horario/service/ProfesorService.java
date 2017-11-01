package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Profesor;

import java.util.ArrayList;

public interface ProfesorService {
    Iterable<Profesor> listarProfesores();
    ArrayList<Profesor> listaProfesores();
    ArrayList<Profesor> filtrarProfesores(String name);
    Profesor BuscarUno(Long  id);
    void  EliminarProfesor(Long id);
}
