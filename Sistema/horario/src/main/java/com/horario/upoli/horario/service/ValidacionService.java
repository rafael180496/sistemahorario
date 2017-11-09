package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Profesor;

import java.util.ArrayList;

public interface ValidacionService {

    ArrayList<Profesor> ProfesoresSinUsuario();
    boolean CarnetRepetido(String carnet);

}
