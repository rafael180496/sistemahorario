package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.*;
import com.horario.upoli.horario.repo.*;
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
    @Autowired
    private Det_grupoRepo det_grupoRepo;


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
    public ArrayList<Det_grupo> DetalleFiltrado(Grupo grupo) {
        Iterable<Det_grupo> source=det_grupoRepo.findAll();
        ArrayList<Det_grupo> ListadoA= new ArrayList<>();
        ArrayList<Det_grupo> ListadoB= new ArrayList<>();
        source.forEach(ListadoA::add);
        for (Det_grupo n:ListadoA
             ) {
            if (n.getGrupo().getId_grupo()==grupo.getId_grupo())
            {
                ListadoB.add(n);
            }
        }



        return ListadoB;
    }

    @Override
    public ArrayList<Carrera> CarrerasConAlumnos() {
        Iterable<Carrera> sourceC=carreraRepo.findAll();
        Iterable<Alumno> sourceA=alumnoRepo.findAll();

        ArrayList<Carrera> ListC= new ArrayList<>();
        ArrayList<Carrera> ListCO= new ArrayList<>();
        ArrayList<Alumno> ListAl= new ArrayList<>();

        sourceC.forEach(ListC::add);
        sourceA.forEach(ListAl::add);

        for (Carrera carrera:ListC
             ) {

            for (Alumno alumno:ListAl
                 ) {
                if(alumno.getCarrera().getId_carrera()==carrera.getId_carrera())
                {
                    ListCO.add(carrera);
                    break;
                }
            }

        }
        return ListCO;
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

                if (carnetA.equals(carnet.replace(" ",""))) {

                    return true;

                }

            }
        }
        else
        {
            for (Alumno n:ListadoA
                    ) {
                String carnetA=n.getCarnet().replace(" ","");

                if ((carnetA.equals(carnet.replace(" ","")) )&&(n.getId_alumno()!=id)) {

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
