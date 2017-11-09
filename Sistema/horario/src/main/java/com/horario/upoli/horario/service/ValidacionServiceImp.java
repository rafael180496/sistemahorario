package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Alumno;
import com.horario.upoli.horario.model.Profesor;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.repo.AlumnoRepo;
import com.horario.upoli.horario.repo.ProfesorRepo;
import com.horario.upoli.horario.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ValidacionServiceImp implements ValidacionService {
    @Autowired
    private  ProfesorRepo profesorRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private AlumnoRepo alumnoRepo;

    @Override
    public ArrayList<Profesor> ProfesoresSinUsuario() {
        Iterable<Profesor> source=profesorRepo.findAll();
        ArrayList<Profesor> ListadoP= new ArrayList<>();
        source.forEach(ListadoP::add);


        Iterable<Usuario> source2=usuarioRepo.findAll();
        ArrayList<Usuario> ListadoU= new ArrayList<>();
        source2.forEach(ListadoU::add);

        ArrayList<Profesor> Resultado= new ArrayList<>();


        for (Profesor p:ListadoP
             ) {

                Resultado.add(p);


        }

        return  Resultado;
    }

    @Override
    public boolean CarnetRepetido(String carnet) {

        Iterable<Alumno> source=alumnoRepo.findAll();
        ArrayList<Alumno> ListadoA= new ArrayList<>();
        source.forEach(ListadoA::add);

        for (Alumno n:ListadoA
             ) {
            if (n.getCarnet().equals(carnet)) {

                return true;

            }

        }


        return false;
    }


}
