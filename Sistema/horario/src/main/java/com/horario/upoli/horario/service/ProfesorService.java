package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.ProfesorK;

import java.util.ArrayList;

public interface ProfesorService {
    Iterable<ProfesorK> listarProfesores();
    ArrayList<ProfesorK> listaProfesores();
    ArrayList<ProfesorK> filtrarProfesores(String name);
    ProfesorK BuscarUno(Long  id);
    void  EliminarProfesor(Long id);
    void  GuardarProfesor(ProfesorK profesor);
    Long  Secuencia();
}
