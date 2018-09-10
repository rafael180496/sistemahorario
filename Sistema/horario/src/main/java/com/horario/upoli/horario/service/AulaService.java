package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.AulaK;

import java.util.ArrayList;

public interface AulaService {
    Iterable<AulaK> listarAula();
    ArrayList<AulaK> listaAula();
    ArrayList<AulaK> filtrarAula(String name);
    AulaK BuscarUno(Long  id);
    void  EliminarAula(Long id);
    void  GuardarAula(AulaK aula);
    Long  Secuencia();
}
