package com.horario.Service.Interface;

import com.horario.Model.Profesor;

public interface IProfesorService {

    public Iterable<Profesor> listAllProfesor();

    public Profesor getProfesorById(long id);

    public Profesor saveProfesor(Profesor profesor);

    public void deleteProfesor(long id);
}
