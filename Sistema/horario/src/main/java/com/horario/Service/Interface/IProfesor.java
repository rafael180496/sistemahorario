package com.horario.Service.Interface;

import com.horario.Model.Profesor;
import org.springframework.data.repository.CrudRepository;

public interface IProfesor extends CrudRepository<Profesor, Long> {
}
