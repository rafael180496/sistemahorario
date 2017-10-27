package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Profesor;
import com.horario.upoli.horario.repo.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImp implements ProfesorService{

    @Autowired
    ProfesorRepo  profesorRepo;

    @Override
    public Iterable<Profesor> listarProfesores() {
        return profesorRepo.findAll();
    }
}
