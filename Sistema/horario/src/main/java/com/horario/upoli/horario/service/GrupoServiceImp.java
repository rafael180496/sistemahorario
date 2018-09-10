package com.horario.upoli.horario.service;


import com.horario.upoli.horario.model.GrupoK;
import com.horario.upoli.horario.repo.GrupoRepo;
import com.horario.upoli.horario.seguridad.PermisosK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GrupoServiceImp implements GrupoService {

    @Autowired
    private GrupoRepo grupoRepo;

    @Override
    public Iterable<GrupoK> listarGrupo() {
        return grupoRepo.findAll();
    }

    @Override
    public ArrayList<GrupoK> listaGrupo() {
        Iterable<GrupoK> source=grupoRepo.findAll();
        ArrayList<GrupoK> Listado= new ArrayList<>();
        source.forEach(Listado::add);



        return Listado;
    }

    @Override
    public ArrayList<GrupoK> filtrarGrupo(String name) {
        Iterable<GrupoK> source=grupoRepo.findAll();
        ArrayList<GrupoK> Listado= new ArrayList<>();
        ArrayList<GrupoK> Listadoaux= new ArrayList<>();
        source.forEach(Listadoaux::add);

        name=name.replace(" ","");

        for (GrupoK n:Listadoaux
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
    public GrupoK BuscarUno(Long id) {
        return grupoRepo.findOne(id);
    }

    @Override
    public void EliminarGrupo(Long id) {
         grupoRepo.delete(id);
    }

    @Override
    public void GuardarGrupo(GrupoK grupo) {
        grupoRepo.save(grupo);
    }

    @Override
    public Long Secuencia() {
        Iterable<GrupoK> source=grupoRepo.findAll();
        ArrayList<GrupoK> Listado= new ArrayList<>();
        ArrayList<Long> Listadoid= new ArrayList<>();
        source.forEach(Listado::add);

        for (GrupoK n:Listado
                ) {
            Listadoid.add(n.getId_grupo());
        }

        return PermisosK.Companion.maximoSecuencial(Listadoid)+1;
    }
}
