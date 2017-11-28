package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.*;

import java.util.ArrayList;

public interface ValidacionService {

    ArrayList<Profesor> ProfesoresSinUsuario();
    ArrayList<Det_grupo> DetalleFiltrado(Grupo grupo);
    ArrayList<Carrera> CarrerasConAlumnos();
    boolean CarnetRepetido(String carnet,Long id);
    boolean ValidarUsuario(Usuario usuario);
    boolean ValidarCarrera(Carrera carrera);
    boolean ValidarAlumno(Alumno alumno);
    boolean ValidarClase(Clase clase);
    boolean ValidarProfesor(Profesor profesor);
}
