package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Clase;
import com.horario.upoli.horario.repo.ClaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ClaseServiceImp  implements  ClaseService{


    @Autowired
    private ClaseRepo claseRepo;

    @Override
    public Iterable<Clase> listarClases() {
        return claseRepo.findAll();
    }

    @Override
    public ArrayList<Clase> listaClase() {
        Iterable<Clase> source=claseRepo.findAll();
        ArrayList<Clase> Listado= new ArrayList<>();
        source.forEach(Listado::add);

        return Listado;
    }

    @Override
    public ArrayList<Clase> filtrarClase(String name) {
        Iterable<Clase> source=claseRepo.findAll();
        ArrayList<Clase> Listado= new ArrayList<>();
        ArrayList<Clase> Listadoaux= new ArrayList<>();
        source.forEach(Listadoaux::add);

        name=name.replace(" ","");

        for (Clase n:Listadoaux
                ) {
            n.setNombre(n.getNombre().replace(" ",""));
            if((n.getNombre().toUpperCase().matches(name+"(.*)")))
            {
                Listado.add(n);
            }
        }

        return Listado;
    }

    @Override
    public Clase BuscarUno(Long id) {
        return claseRepo.findOne(id);
    }

    @Override
    public void EliminarClase(Long id) {
        claseRepo.delete(id);
    }

    @Override
    public void GuardarClase(Clase clase) {
        claseRepo.save(clase);
    }

    @Override
    public Long Secuencia() {
        return claseRepo.count()+1;
    }
}
