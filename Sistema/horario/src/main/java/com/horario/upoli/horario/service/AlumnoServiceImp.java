package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Alumno;
import com.horario.upoli.horario.repo.AlumnoRepo;
import com.horario.upoli.horario.seguridad.Permisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AlumnoServiceImp implements AlumnoService {

    @Autowired
    AlumnoRepo alumnoRepo;

    @Override
    public Iterable<Alumno> listarAlumno() {
        return alumnoRepo.findAll();
    }

    @Override
    public ArrayList<Alumno> listaAlumno() {
        Iterable<Alumno> source=alumnoRepo.findAll();
        ArrayList<Alumno> Listado= new ArrayList<>();
        source.forEach(Listado::add);



        return Listado;
    }

    @Override
    public ArrayList<Alumno> filtrarAlumno(String name) {
        Iterable<Alumno> source=alumnoRepo.findAll();
        ArrayList<Alumno> Listado= new ArrayList<>();
        ArrayList<Alumno> Listadoaux= new ArrayList<>();
        source.forEach(Listadoaux::add);

        name=name.replace(" ","");

        for (Alumno n:Listadoaux
                ) {
            n.setNombre(n.getNombre().replace(" ",""));
            n.setApellido(n.getApellido().replace(" ",""));
            if((n.getNombre().toLowerCase().matches(name+"(.*)")))
            {
                Listado.add(n);
            }
        }

        return Listado;
    }

    @Override
    public Alumno BuscarUno(Long id) {
        return alumnoRepo.findOne(id);
    }

    @Override
    public void EliminarAlumno(Long id) {
        alumnoRepo.delete(id);
    }

    @Override
    public void GuardarAlumno(Alumno alumno) {
        alumnoRepo.save(alumno);
    }

    @Override
    public Long Secuencia() {

        Iterable<Alumno> source=alumnoRepo.findAll();
        ArrayList<Alumno> Listado= new ArrayList<>();
        ArrayList<Long> Listadoid= new ArrayList<>();
        source.forEach(Listado::add);

        for (Alumno n:Listado
             ) {
            Listadoid.add(n.getId_alumno());
        }

        return Permisos.maximoSecuencial(Listadoid)+1;
    }
}
