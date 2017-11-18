package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Aula;
import com.horario.upoli.horario.repo.AulaRepo;
import com.horario.upoli.horario.seguridad.Permisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AulaServiceImp implements  AulaService{
    @Autowired
    private AulaRepo aulaRepo;

    @Override
    public Iterable<Aula> listarAula() {
        return  aulaRepo.findAll();
    }

    @Override
    public ArrayList<Aula> listaAula() {
        Iterable<Aula> source=aulaRepo.findAll();
        ArrayList<Aula> Listado= new ArrayList<>();
        source.forEach(Listado::add);
        return Listado;
    }

    @Override
    public ArrayList<Aula> filtrarAula(String name) {
        Iterable<Aula> source=aulaRepo.findAll();
        ArrayList<Aula> Listado= new ArrayList<>();
        ArrayList<Aula> Listadoaux= new ArrayList<>();
        source.forEach(Listadoaux::add);

        name=name.replace(" ","");

        for (Aula n:Listadoaux
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
    public Aula BuscarUno(Long id) {
        return aulaRepo.findOne(id);
    }

    @Override
    public void EliminarAula(Long id) {
         aulaRepo.delete(id);
    }

    @Override
    public void GuardarAula(Aula aula) {
        aulaRepo.save(aula);
    }

    @Override
    public Long Secuencia() {

        Iterable<Aula> source=aulaRepo.findAll();
        ArrayList<Aula> Listado= new ArrayList<>();
        ArrayList<Long> Listadoid= new ArrayList<>();
        source.forEach(Listado::add);

        for (Aula n:Listado
                ) {
            Listadoid.add(n.getId_aula());
        }

        return Permisos.maximoSecuencial(Listadoid)+1;
    }
}
