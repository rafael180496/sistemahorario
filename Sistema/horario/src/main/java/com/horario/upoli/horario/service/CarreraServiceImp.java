package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Carrera;
import com.horario.upoli.horario.repo.CarreraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CarreraServiceImp implements CarreraService{


    @Autowired
    private CarreraRepo carreraRepo;

    @Override
    public Iterable<Carrera> listarCarrera() {
        return carreraRepo.findAll();
    }

    @Override
    public ArrayList<Carrera> listaCarrera() {
        Iterable<Carrera> source=carreraRepo.findAll();
        ArrayList<Carrera> Listado= new ArrayList<>();
        source.forEach(Listado::add);

        return Listado;
    }

    @Override
    public ArrayList<Carrera> filtrarCarrera(String name) {
        Iterable<Carrera> source=carreraRepo.findAll();
        ArrayList<Carrera> Listado= new ArrayList<>();
        ArrayList<Carrera> Listadoaux= new ArrayList<>();
        source.forEach(Listadoaux::add);

        name=name.replace(" ","");

        for (Carrera n:Listadoaux
                ) {
            n.setNombre(n.getNombre().replace(" ",""));

            if((n.getNombre().toLowerCase().matches(name+"(.*)")))
            {
                Listado.add(n);
            }
        }

        return Listado;
    }

    @Override
    public Carrera BuscarUno(Long id) {
        return carreraRepo.findOne(id);
    }

    @Override
    public void EliminarCarrera(Long id) {
        carreraRepo.delete(id);
    }

    @Override
    public void GuardarCarrera(Carrera carrera) {
        carreraRepo.save(carrera);
    }

    @Override
    public Long Secuencia() {
        return carreraRepo.count()+1;
    }
}
