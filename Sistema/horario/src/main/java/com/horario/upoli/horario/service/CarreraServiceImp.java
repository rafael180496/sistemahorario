package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.CarreraK;
import com.horario.upoli.horario.repo.CarreraRepo;
import com.horario.upoli.horario.seguridad.PermisosK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CarreraServiceImp implements CarreraService{


    @Autowired
    private CarreraRepo carreraRepo;

    @Override
    public Iterable<CarreraK> listarCarrera() {
        return carreraRepo.findAll();
    }

    @Override
    public ArrayList<CarreraK> listaCarrera() {
        Iterable<CarreraK> source=carreraRepo.findAll();
        ArrayList<CarreraK> Listado= new ArrayList<>();
        source.forEach(Listado::add);

        return Listado;
    }

    @Override
    public ArrayList<CarreraK> filtrarCarrera(String name) {
        Iterable<CarreraK> source=carreraRepo.findAll();
        ArrayList<CarreraK> Listado= new ArrayList<>();
        ArrayList<CarreraK> Listadoaux= new ArrayList<>();
        source.forEach(Listadoaux::add);

        name=name.replace(" ","");

        for (CarreraK n:Listadoaux
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
    public CarreraK BuscarUno(Long id) {
            return carreraRepo.findOne(id);
    }

    @Override
    public void EliminarCarrera(Long id) {
        carreraRepo.delete(id);
    }

    @Override
    public void GuardarCarrera(CarreraK carrera) {
        carreraRepo.save(carrera);
    }

    @Override
    public Long Secuencia() {
        Iterable<CarreraK> source=carreraRepo.findAll();
        ArrayList<CarreraK> Listado= new ArrayList<>();
        ArrayList<Long> Listadoid= new ArrayList<>();
        source.forEach(Listado::add);

        for (CarreraK n:Listado
                ) {
            Listadoid.add(n.getId_carrera());
        }

        return PermisosK.Companion.maximoSecuencial(Listadoid)+1;
    }
}
