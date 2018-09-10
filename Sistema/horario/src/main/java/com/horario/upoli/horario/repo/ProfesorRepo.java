package com.horario.upoli.horario.repo;

import com.horario.upoli.horario.model.ProfesorK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProfesorRepo extends CrudRepository<ProfesorK,Long> {
}
