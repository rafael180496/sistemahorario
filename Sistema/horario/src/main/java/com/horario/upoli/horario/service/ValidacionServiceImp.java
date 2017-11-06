package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Profesor;
import com.horario.upoli.horario.model.Usuario;
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
            boolean esta= false;

            for (Usuario u:ListadoU
                 ) {
                if (u.getProfesor().getId_profesor()==p.getId_profesor())
                {
                    esta=true;
                    break;

                }

            }
            if(!esta)
            {
                Resultado.add(p);
            }

        }

        return  Resultado;
    }
}
