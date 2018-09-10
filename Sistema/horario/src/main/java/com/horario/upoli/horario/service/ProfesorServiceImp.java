package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.ProfesorK;
import com.horario.upoli.horario.repo.ProfesorRepo;
import com.horario.upoli.horario.seguridad.PermisosK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProfesorServiceImp implements ProfesorService{

    @Autowired
    private ProfesorRepo  profesorRepo;

    @Override
    public Iterable<ProfesorK> listarProfesores() {
        return profesorRepo.findAll();
    }

    @Override
    public ArrayList<ProfesorK> listaProfesores() {
        Iterable<ProfesorK> source=profesorRepo.findAll();
        ArrayList<ProfesorK> Listado= new ArrayList<>();
        source.forEach(Listado::add);

        return Listado;
    }

    @Override
    public ArrayList<ProfesorK> filtrarProfesores(String name) {
        Iterable<ProfesorK> source=profesorRepo.findAll();
        ArrayList<ProfesorK> Listado= new ArrayList<>();
        ArrayList<ProfesorK> Listadoaux= new ArrayList<>();
        source.forEach(Listadoaux::add);

        name=name.replace(" ","");

        for (ProfesorK n:Listadoaux
             ) {
            n.setNombre(n.getNombre().replace(" ",""));
            n.setApellido(n.getApellido().replace(" ",""));
            if((n.getNombre().toLowerCase().matches(name+"(.*)")))
            {
                Listado.add(n);
            }
        }

        return Listado;
    }

    @Override
    public ProfesorK BuscarUno(Long id) {
        return profesorRepo.findOne(id);
    }

    @Override
    public void EliminarProfesor(Long id) {
        profesorRepo.delete(id);

    }

    @Override
    public void GuardarProfesor(ProfesorK profesor) {
        profesorRepo.save(profesor);
    }

    @Override
    public Long Secuencia() {
        Iterable<ProfesorK> source=profesorRepo.findAll();
        ArrayList<ProfesorK> Listado= new ArrayList<>();
        ArrayList<Long> Listadoid= new ArrayList<>();
        source.forEach(Listado::add);

        for (ProfesorK n:Listado
                ) {
            Listadoid.add(n.getId_profesor());
        }

        return PermisosK.Companion.maximoSecuencial(Listadoid)+1;
    }
}
