package com.horario.upoli.horario.service;

import com.horario.upoli.horario.repo.ProfesorRepo;
import com.horario.upoli.horario.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidacionServiceImp {
    @Autowired
    private  ProfesorRepo profesorRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;
}
