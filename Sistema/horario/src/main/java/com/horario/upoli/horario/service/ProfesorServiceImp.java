package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Profesor;
import com.horario.upoli.horario.repo.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProfesorServiceImp implements ProfesorService{

    @Autowired
    private ProfesorRepo  profesorRepo;

    @Override
    public Iterable<Profesor> listarProfesores() {
        return profesorRepo.findAll();
    }

    @Override
    public ArrayList<Profesor> listaProfesores() {
        Iterable<Profesor> source=profesorRepo.findAll();
        ArrayList<Profesor> Listado= new ArrayList<>();
        source.forEach(Listado::add);

        return Listado;
    }

    @Override
    public ArrayList<Profesor> filtrarProfesores(String name) {
        Iterable<Profesor> source=profesorRepo.findAll();
        ArrayList<Profesor> Listado= new ArrayList<>();
        ArrayList<Profesor> Listadoaux= new ArrayList<>();
        source.forEach(Listadoaux::add);

        name=name.replace(" ","");

        for (Profesor n:Listadoaux
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
    public Profesor BuscarUno(Long id) {
        return profesorRepo.findOne(id);
    }

    @Override
    public void EliminarProfesor(Long id) {
        profesorRepo.delete(id);

    }
}
