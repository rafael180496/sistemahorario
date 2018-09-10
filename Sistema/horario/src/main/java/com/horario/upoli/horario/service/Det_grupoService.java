package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Det_grupoK;

import java.util.ArrayList;

public interface Det_grupoService {
    Iterable<Det_grupoK> listarDet_grupo();
    ArrayList<Det_grupoK> listaDet_grupo();
    Det_grupoK BuscarUno(Long id);
    void  EliminarDet_grupo(Long id);
    void  GuardarDet_grupo(Det_grupoK det_grupo);
    Long  Secuencia();
}
