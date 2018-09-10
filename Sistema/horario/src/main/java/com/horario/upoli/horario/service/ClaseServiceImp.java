package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.ClaseK;
import com.horario.upoli.horario.repo.ClaseRepo;
import com.horario.upoli.horario.seguridad.PermisosK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ClaseServiceImp  implements  ClaseService{


    @Autowired
    private ClaseRepo claseRepo;

    @Override
    public Iterable<ClaseK> listarClases() {
        return claseRepo.findAll();
    }

    @Override
    public ArrayList<ClaseK> listaClase() {
        Iterable<ClaseK> source=claseRepo.findAll();
        ArrayList<ClaseK> Listado= new ArrayList<>();
        source.forEach(Listado::add);

        return Listado;
    }

    @Override
    public ArrayList<ClaseK> filtrarClase(String name) {
        Iterable<ClaseK> source=claseRepo.findAll();
        ArrayList<ClaseK> Listado= new ArrayList<>();
        ArrayList<ClaseK> Listadoaux= new ArrayList<>();
        source.forEach(Listadoaux::add);

        name=name.replace(" ","");

        for (ClaseK n:Listadoaux
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
    public ClaseK BuscarUno(Long id) {
        return claseRepo.findOne(id);
    }

    @Override
    public void EliminarClase(Long id) {
        claseRepo.delete(id);
    }

    @Override
    public void GuardarClase(ClaseK clase) {
        claseRepo.save(clase);
    }

    @Override
    public Long Secuencia() {
        Iterable<ClaseK> source=claseRepo.findAll();
        ArrayList<ClaseK> Listado= new ArrayList<>();
        ArrayList<Long> Listadoid= new ArrayList<>();
        source.forEach(Listado::add);

        for (ClaseK n:Listado
                ) {
            Listadoid.add(n.getId_clase());
        }

        return PermisosK.Companion.maximoSecuencial(Listadoid)+1;
    }
}
