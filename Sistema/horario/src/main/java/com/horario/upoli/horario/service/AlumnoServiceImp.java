package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.AlumnoK;
import com.horario.upoli.horario.repo.AlumnoRepo;
import com.horario.upoli.horario.seguridad.PermisosK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AlumnoServiceImp implements AlumnoService {

    @Autowired
    AlumnoRepo alumnoRepo;

    @Override
    public Iterable<AlumnoK> listarAlumno() {
        return alumnoRepo.findAll();
    }

    @Override
    public ArrayList<AlumnoK> listaAlumno() {
        Iterable<AlumnoK> source=alumnoRepo.findAll();
        ArrayList<AlumnoK> Listado= new ArrayList<>();
        source.forEach(Listado::add);



        return Listado;
    }

    @Override
    public ArrayList<AlumnoK> filtrarAlumno(String name) {
        Iterable<AlumnoK> source=alumnoRepo.findAll();
        ArrayList<AlumnoK> Listado= new ArrayList<>();
        ArrayList<AlumnoK> Listadoaux= new ArrayList<>();
        source.forEach(Listadoaux::add);

        name=name.replace(" ","");

        for (AlumnoK n:Listadoaux
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
    public AlumnoK BuscarUno(Long id) {
        return alumnoRepo.findOne(id);
    }

    @Override
    public void EliminarAlumno(Long id) {
        alumnoRepo.delete(id);
    }

    @Override
    public void GuardarAlumno(AlumnoK alumno) {
        alumnoRepo.save(alumno);
    }

    @Override
    public Long Secuencia() {

        Iterable<AlumnoK> source=alumnoRepo.findAll();
        ArrayList<AlumnoK> Listado= new ArrayList<>();
        ArrayList<Long> Listadoid= new ArrayList<>();
        source.forEach(Listado::add);

        for (AlumnoK n:Listado
             ) {
            Listadoid.add(n.getId_alumno());
        }

        return PermisosK.Companion.maximoSecuencial(Listadoid)+1;
    }
}
