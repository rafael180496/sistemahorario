package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Det_grupoK;
import com.horario.upoli.horario.repo.Det_grupoRepo;
import com.horario.upoli.horario.seguridad.PermisosK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Det_grupoServiceImp implements  Det_grupoService {
    @Autowired
    private Det_grupoRepo det_grupoRepo;


    @Override
    public Iterable<Det_grupoK> listarDet_grupo() {
      return det_grupoRepo.findAll();
    }

    @Override
    public ArrayList<Det_grupoK> listaDet_grupo() {
        Iterable<Det_grupoK> source=det_grupoRepo.findAll();
        ArrayList<Det_grupoK> Listado= new ArrayList<>();
        source.forEach(Listado::add);



        return Listado;
    }

    @Override
    public Det_grupoK BuscarUno(Long id) {
        return det_grupoRepo.findOne(id);
    }

    @Override
    public void EliminarDet_grupo(Long id) {
        det_grupoRepo.delete(id);
    }

    @Override
    public void GuardarDet_grupo(Det_grupoK det_grupo) {
        det_grupoRepo.save(det_grupo);
    }

    @Override
    public Long Secuencia() {
        Iterable<Det_grupoK> source=det_grupoRepo.findAll();
        ArrayList<Det_grupoK> Listado= new ArrayList<>();
        ArrayList<Long> Listadoid= new ArrayList<>();
        source.forEach(Listado::add);

        for (Det_grupoK n:Listado
                ) {
            Listadoid.add(n.getId_det_grupo());
        }

        return PermisosK.Companion.maximoSecuencial(Listadoid)+1;
    }
}
