package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Alumno;
import com.horario.upoli.horario.model.Carrera;
import com.horario.upoli.horario.model.Profesor;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.repo.AlumnoRepo;
import com.horario.upoli.horario.repo.CarreraRepo;
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

    @Autowired
    private CarreraRepo carreraRepo;


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
    public boolean CarnetRepetido(String carnet,Long id) {

        Iterable<Alumno> source=alumnoRepo.findAll();
        ArrayList<Alumno> ListadoA= new ArrayList<>();
        source.forEach(ListadoA::add);

        if(id==0)
        {
            for (Alumno n:ListadoA
                    ) {
                String carnetA=n.getCarnet().replace(" ","");

                if (carnet.equals(carnet.replace(" ",""))) {

                    return true;

                }

            }
        }
        else
        {
            for (Alumno n:ListadoA
                    ) {
                String carnetA=n.getCarnet().replace(" ","");

                if ((carnet.equals(carnet.replace(" ","")) )&&(n.getId_alumno()!=id)) {

                    return true;

                }

            }
        }



        return false;
    }

    @Override
    public boolean ValidarUsuario(Usuario usuario) {

        Iterable<Usuario> source=usuarioRepo.findAll();
        ArrayList<Usuario> ListadoU= new ArrayList<>();
        source.forEach(ListadoU::add);

        for (Usuario n:ListadoU
             ) {
            if(n.equals(usuario))
            {
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean ValidarCarrera(Carrera carrera) {
        Iterable<Alumno> source=alumnoRepo.findAll();
        ArrayList<Alumno> ListadoA= new ArrayList<>();
        source.forEach(ListadoA::add);

        for (Alumno n:ListadoA
                ) {
            if(n.getCarrera().getId_carrera()==carrera.getId_carrera())
            {
                return true;
            }
        }
        return false;



    }


}
