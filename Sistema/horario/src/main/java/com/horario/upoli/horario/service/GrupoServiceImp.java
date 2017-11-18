package com.horario.upoli.horario.service;


import com.horario.upoli.horario.model.Grupo;
import com.horario.upoli.horario.repo.GrupoRepo;
import com.horario.upoli.horario.seguridad.Permisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GrupoServiceImp implements GrupoService {

    @Autowired
    private GrupoRepo grupoRepo;

    @Override
    public Iterable<Grupo> listarGrupo() {
        return grupoRepo.findAll();
    }

    @Override
    public ArrayList<Grupo> listaGrupo() {
        Iterable<Grupo> source=grupoRepo.findAll();
        ArrayList<Grupo> Listado= new ArrayList<>();
        source.forEach(Listado::add);



        return Listado;
    }

    @Override
    public ArrayList<Grupo> filtrarGrupo(String name) {
        Iterable<Grupo> source=grupoRepo.findAll();
        ArrayList<Grupo> Listado= new ArrayList<>();
        ArrayList<Grupo> Listadoaux= new ArrayList<>();
        source.forEach(Listadoaux::add);

        name=name.replace(" ","");

        for (Grupo n:Listadoaux
                ) {
            n.setNombre(n.getNombre().replace(" ",""));
            if((n.getNombre().toLowerCase().matches(name+"(.*)")))
            {
                Listado.add(n);
            }
        }

        return Listado;
    }

    @Override
    public Grupo BuscarUno(Long id) {
        return grupoRepo.findOne(id);
    }

    @Override
    public void EliminarGrupo(Long id) {
         grupoRepo.delete(id);
    }

    @Override
    public void GuardarGrupo(Grupo grupo) {
        grupoRepo.save(grupo);
    }

    @Override
    public Long Secuencia() {
        Iterable<Grupo> source=grupoRepo.findAll();
        ArrayList<Grupo> Listado= new ArrayList<>();
        ArrayList<Long> Listadoid= new ArrayList<>();
        source.forEach(Listado::add);

        for (Grupo n:Listado
                ) {
            Listadoid.add(n.getId_grupo());
        }

        return Permisos.maximoSecuencial(Listadoid)+1;
    }
}
