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
    @Autowired
    private GrupoRepo grupoRepo;


    @Override
    public ArrayList<ProfesorK> ProfesoresSinUsuario() {
        Iterable<ProfesorK> source=profesorRepo.findAll();
        ArrayList<ProfesorK> ListadoP= new ArrayList<>();
        source.forEach(ListadoP::add);


        Iterable<UsuarioK> source2=usuarioRepo.findAll();
        ArrayList<UsuarioK> ListadoU= new ArrayList<>();
        source2.forEach(ListadoU::add);

        ArrayList<ProfesorK> Resultado= new ArrayList<>();


        for (ProfesorK p:ListadoP
             ) {

                Resultado.add(p);


        }

        return  Resultado;
    }

    @Override
    public ArrayList<Det_grupoK> DetalleFiltrado(GrupoK grupo) {
        Iterable<Det_grupoK> source=det_grupoRepo.findAll();
        ArrayList<Det_grupoK> ListadoA= new ArrayList<>();
        ArrayList<Det_grupoK> ListadoB= new ArrayList<>();
        source.forEach(ListadoA::add);
        for (Det_grupoK n:ListadoA
             ) {
            if (n.getGrupo().getId_grupo()==grupo.getId_grupo())
            {
                ListadoB.add(n);
            }
        }



        return ListadoB;
    }

    @Override
    public ArrayList<CarreraK> CarrerasConAlumnos() {
        Iterable<CarreraK> sourceC=carreraRepo.findAll();
        Iterable<AlumnoK> sourceA=alumnoRepo.findAll();

        ArrayList<CarreraK> ListC= new ArrayList<>();
        ArrayList<CarreraK> ListCO= new ArrayList<>();
        ArrayList<AlumnoK> ListAl= new ArrayList<>();

        sourceC.forEach(ListC::add);
        sourceA.forEach(ListAl::add);

        for (CarreraK carrera:ListC
             ) {

            for (AlumnoK alumno:ListAl
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

        Iterable<AlumnoK> source=alumnoRepo.findAll();
        ArrayList<AlumnoK> ListadoA= new ArrayList<>();
        source.forEach(ListadoA::add);

        if(id==0)
        {
            for (AlumnoK n:ListadoA
                    ) {
                String carnetA=n.getCarnet().replace(" ","");

                if (carnetA.equals(carnet.replace(" ",""))) {

                    return true;

                }

            }
        }
        else
        {
            for (AlumnoK n:ListadoA
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
    public boolean ValidarUsuario(UsuarioK usuario) {

        Iterable<UsuarioK> source=usuarioRepo.findAll();
        ArrayList<UsuarioK> ListadoU= new ArrayList<>();
        source.forEach(ListadoU::add);

        for (UsuarioK n:ListadoU
             ) {
            if(n.equals(usuario))
            {
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean ValidarCarrera(CarreraK carrera) {
        Iterable<AlumnoK> source=alumnoRepo.findAll();
        ArrayList<AlumnoK> ListadoA= new ArrayList<>();
        source.forEach(ListadoA::add);

        for (AlumnoK n:ListadoA
                ) {
            if(n.getCarrera().getId_carrera()==carrera.getId_carrera())
            {
                return true;
            }
        }
        return false;



    }

    @Override
    public boolean ValidarAlumno(AlumnoK alumno) {
        Iterable<Det_grupoK> source=det_grupoRepo.findAll();
        ArrayList<Det_grupoK> ListadoA= new ArrayList<>();
        source.forEach(ListadoA::add);

        for (Det_grupoK n:ListadoA
                ) {
            if(n.getAlumno().getId_alumno()==alumno.getId_alumno())
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean ValidarClase(ClaseK clase) {
        Iterable<GrupoK> source=grupoRepo.findAll();
        ArrayList<GrupoK> ListadoA= new ArrayList<>();
        source.forEach(ListadoA::add);

        for (GrupoK n:ListadoA
                ) {
            if(n.getClase().getId_clase()==clase.getId_clase())
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean ValidarProfesor(ProfesorK profesor) {
        Iterable<GrupoK> source=grupoRepo.findAll();
        ArrayList<GrupoK> ListadoA= new ArrayList<>();
        source.forEach(ListadoA::add);

        for (GrupoK n:ListadoA
                ) {
            if(n.getProfesor().getId_profesor()==profesor.getId_profesor())
            {
                return true;
            }
        }
        return false;
    }


}
