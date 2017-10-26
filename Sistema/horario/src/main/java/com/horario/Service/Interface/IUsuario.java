package com.horario.Service.Interface;


import com.horario.Model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuario extends CrudRepository<Usuario, Long> {
}
