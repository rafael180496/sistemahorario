package com.horario.upoli.horario.seguridad;

import com.horario.upoli.horario.recursos.Permiso;

import java.util.ArrayList;

public  class  Permisos {


    public static  ArrayList<Permiso> PermisosAdmin()
    {
         ArrayList<Permiso> permisos = new ArrayList<>();
        permisos.add(new Permiso("/Profesor","Profesores"));
        permisos.add(new Permiso("/Usuario","Usuarios"));
        permisos.add(new Permiso("/Aula","Aulas"));
        permisos.add(new Permiso("/Carrera","Carreras"));
        permisos.add(new Permiso("/Clase","Clases"));
        permisos.add(new Permiso("/Alumno","Alumnos"));
        permisos.add(new Permiso("/login","<i class=\"material-icons\">exit_to_app</i>"));




         return permisos;
    }
    public static  ArrayList<Permiso> PermisosProfesor()
    {
        ArrayList<Permiso> permisos = new ArrayList<>();

        permisos.add(new Permiso("#","Alumnos"));
        permisos.add(new Permiso("#","Grupos"));
        permisos.add(new Permiso("#","Horarios"));
        permisos.add(new Permiso("/login","<i class=\"material-icons\">exit_to_app</i>"));

        return permisos;
    }

}
