package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.model.Profesor;
import com.horario.upoli.horario.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfesorController {

    @Autowired
    private ProfesorService  profesorService;

    @RequestMapping("/profesores")
    public  Iterable<Profesor> list()
    {
        return profesorService.listarProfesores();
    }

}
