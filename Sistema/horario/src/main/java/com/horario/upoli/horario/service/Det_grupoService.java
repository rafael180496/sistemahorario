package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Det_grupo;

import java.util.ArrayList;

public interface Det_grupoService {
    Iterable<Det_grupo> listarDet_grupo();
    ArrayList<Det_grupo> listaDet_grupo();
    Det_grupo BuscarUno(Long id);
    void  EliminarDet_grupo(Long id);
    void  GuardarDet_grupo(Det_grupo det_grupo);
    Long  Secuencia();
}
