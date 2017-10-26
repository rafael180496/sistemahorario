package com.horario.Service.Implement;

import com.horario.Model.Profesor;
import com.horario.Service.Interface.IProfesor;
import com.horario.Service.Interface.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfesorService implements IProfesorService {


    private IProfesor profesorRepo;

    @Autowired
    public void setProfesorRepo(IProfesor profesorRepo) {
        this.profesorRepo = profesorRepo;
    }

    @Override
    public Iterable<Profesor> listAllProfesor() {
        return profesorRepo.findAll();
    }

    @Override
    public Profesor getProfesorById(long id) {
        return profesorRepo.findOne(id);
    }

    @Override
    public Profesor saveProfesor(Profesor profesor) {
        return profesorRepo.save(profesor);
    }

    @Override
    public void deleteProfesor(long id) {
        profesorRepo.delete(id);
    }
}
