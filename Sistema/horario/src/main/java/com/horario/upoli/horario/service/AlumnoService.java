package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Alumno;

import java.util.ArrayList;

public interface AlumnoService {
    Iterable<Alumno> listarAlumno();
    ArrayList<Alumno> listaAlumno();
    ArrayList<Alumno> filtrarAlumno(String name);
    Alumno BuscarUno(Long id);
    void  EliminarAlumno(Long id);
    void  GuardarAlumno(Alumno alumno);
    Long  Secuencia();
}
