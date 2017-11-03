package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Aula;

import java.util.ArrayList;

public interface AulaService {
    Iterable<Aula> listarAula();
    ArrayList<Aula> listaAula();
    ArrayList<Aula> filtrarAula(String name);
    Aula BuscarUno(Long  id);
    void  EliminarAula(Long id);
    void  GuardarAula(Aula aula);
    Long  Secuencia();
}
