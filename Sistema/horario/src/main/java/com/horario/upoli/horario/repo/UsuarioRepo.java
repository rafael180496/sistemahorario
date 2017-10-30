package com.horario.upoli.horario.repo;

import com.horario.upoli.horario.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UsuarioRepo extends CrudRepository<Usuario,Long> {
}
