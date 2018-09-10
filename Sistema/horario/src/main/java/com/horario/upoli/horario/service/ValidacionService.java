package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.*;

import java.util.ArrayList;

public interface ValidacionService {

    ArrayList<ProfesorK> ProfesoresSinUsuario();
    ArrayList<Det_grupoK> DetalleFiltrado(GrupoK grupo);
    ArrayList<CarreraK> CarrerasConAlumnos();
    boolean CarnetRepetido(String carnet,Long id);
    boolean ValidarUsuario(UsuarioK usuario);
    boolean ValidarCarrera(CarreraK carrera);
    boolean ValidarAlumno(AlumnoK alumno);
    boolean ValidarClase(ClaseK clase);
    boolean ValidarProfesor(ProfesorK profesor);
}
