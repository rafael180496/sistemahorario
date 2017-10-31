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
}
