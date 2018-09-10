package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.GrupoK;

import java.util.ArrayList;

public interface GrupoService {

    Iterable<GrupoK> listarGrupo();
    ArrayList<GrupoK> listaGrupo();
    ArrayList<GrupoK> filtrarGrupo(String name);
    GrupoK BuscarUno(Long id);
    void  EliminarGrupo(Long id);
    void  GuardarGrupo(GrupoK grupo);
    Long  Secuencia();
}
