package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Profesor;
import com.horario.upoli.horario.repo.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProfesorServiceImp implements ProfesorService{

    @Autowired
    ProfesorRepo  profesorRepo;

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
    public ArrayList<Profesor> listaProfesores(String name) {
        Iterable<Profesor> source=profesorRepo.findAll();
        ArrayList<Profesor> Listado= new ArrayList<>();
        ArrayList<Profesor> Listadoaux= new ArrayList<>();
        source.forEach(Listadoaux::add);

        name=name.replace(" ","");

        for (Profesor n:Listadoaux
             ) {
            if((n.getNombre().compareToIgnoreCase(name)<=4) &&(n.getNombre().compareToIgnoreCase(name)>=-4))
            {
                Listado.add(n);
            }
        }

        return Listado;
    }
}
