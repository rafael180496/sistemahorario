package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.AlumnoK;

import java.util.ArrayList;

public interface AlumnoService {
    Iterable<AlumnoK> listarAlumno();
    ArrayList<AlumnoK> listaAlumno();
    ArrayList<AlumnoK> filtrarAlumno(String name);
    AlumnoK BuscarUno(Long id);
    void  EliminarAlumno(Long id);
    void  GuardarAlumno(AlumnoK alumno);
    Long  Secuencia();
}
