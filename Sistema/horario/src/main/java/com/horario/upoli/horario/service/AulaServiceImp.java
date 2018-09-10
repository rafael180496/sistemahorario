package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.AulaK;
import com.horario.upoli.horario.repo.AulaRepo;
import com.horario.upoli.horario.seguridad.PermisosK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AulaServiceImp implements  AulaService{
    @Autowired
    private AulaRepo aulaRepo;

    @Override
    public Iterable<AulaK> listarAula() {
        return  aulaRepo.findAll();
    }

    @Override
    public ArrayList<AulaK> listaAula() {
        Iterable<AulaK> source=aulaRepo.findAll();
        ArrayList<AulaK> Listado= new ArrayList<>();
        source.forEach(Listado::add);
        return Listado;
    }

    @Override
    public ArrayList<AulaK> filtrarAula(String name) {
        Iterable<AulaK> source=aulaRepo.findAll();
        ArrayList<AulaK> Listado= new ArrayList<>();
        ArrayList<AulaK> Listadoaux= new ArrayList<>();
        source.forEach(Listadoaux::add);

        name=name.replace(" ","");

        for (AulaK n:Listadoaux
                ) {
            n.setDesc_aula(n.getDesc_aula().replace(" ",""));

            if((n.getDesc_aula().toLowerCase().matches(name+"(.*)")))
            {
                Listado.add(n);
            }
        }

        return Listado;
    }

    @Override
    public AulaK BuscarUno(Long id) {
        return aulaRepo.findOne(id);
    }

    @Override
    public void EliminarAula(Long id) {
         aulaRepo.delete(id);
    }

    @Override
    public void GuardarAula(AulaK aula) {
        aulaRepo.save(aula);
    }

    @Override
    public Long Secuencia() {

        Iterable<AulaK> source=aulaRepo.findAll();
        ArrayList<AulaK> Listado= new ArrayList<>();
        ArrayList<Long> Listadoid= new ArrayList<>();
        source.forEach(Listado::add);

        for (AulaK n:Listado
                ) {
            Listadoid.add(n.getId_aula());
        }

        return PermisosK.Companion.maximoSecuencial(Listadoid)+1;
    }
}
