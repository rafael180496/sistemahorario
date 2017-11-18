package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Det_grupo;
import com.horario.upoli.horario.repo.Det_grupoRepo;
import com.horario.upoli.horario.seguridad.Permisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Det_grupoServiceImp implements  Det_grupoService {
    @Autowired
    private Det_grupoRepo det_grupoRepo;


    @Override
    public Iterable<Det_grupo> listarDet_grupo() {
      return det_grupoRepo.findAll();
    }

    @Override
    public ArrayList<Det_grupo> listaDet_grupo() {
        Iterable<Det_grupo> source=det_grupoRepo.findAll();
        ArrayList<Det_grupo> Listado= new ArrayList<>();
        source.forEach(Listado::add);



        return Listado;
    }

    @Override
    public Det_grupo BuscarUno(Long id) {
        return det_grupoRepo.findOne(id);
    }

    @Override
    public void EliminarDet_grupo(Long id) {
        det_grupoRepo.delete(id);
    }

    @Override
    public void GuardarDet_grupo(Det_grupo det_grupo) {
        det_grupoRepo.save(det_grupo);
    }

    @Override
    public Long Secuencia() {
        Iterable<Det_grupo> source=det_grupoRepo.findAll();
        ArrayList<Det_grupo> Listado= new ArrayList<>();
        ArrayList<Long> Listadoid= new ArrayList<>();
        source.forEach(Listado::add);

        for (Det_grupo n:Listado
                ) {
            Listadoid.add(n.getId_det_grupo());
        }

        return Permisos.maximoSecuencial(Listadoid)+1;
    }
}
