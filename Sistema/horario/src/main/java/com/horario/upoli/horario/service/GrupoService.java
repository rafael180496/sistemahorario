package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Grupo;

import java.util.ArrayList;

public interface GrupoService {

    Iterable<Grupo> listarGrupo();
    ArrayList<Grupo> listaGrupo();
    ArrayList<Grupo> filtrarGrupo(String name);
    Grupo BuscarUno(Long id);
    void  EliminarGrupo(Long id);
    void  GuardarGrupo(Grupo grupo);
    Long  Secuencia();
}
