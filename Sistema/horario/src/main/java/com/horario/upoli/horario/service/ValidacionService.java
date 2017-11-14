package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Carrera;
import com.horario.upoli.horario.model.Profesor;
import com.horario.upoli.horario.model.Usuario;

import java.util.ArrayList;

public interface ValidacionService {

    ArrayList<Profesor> ProfesoresSinUsuario();
    boolean CarnetRepetido(String carnet,Long id);
    boolean ValidarUsuario(Usuario usuario);
    boolean ValidarCarrera(Carrera carrera);


}
