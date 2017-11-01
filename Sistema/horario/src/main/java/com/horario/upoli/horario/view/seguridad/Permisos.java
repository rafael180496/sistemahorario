package com.horario.upoli.horario.view.seguridad;

import com.horario.upoli.horario.recursos.Permiso;

import java.util.ArrayList;

public  class  Permisos {


    public static  ArrayList<Permiso> PermisosAdmin()
    {
         ArrayList<Permiso> permisos = new ArrayList<>();
        permisos.add(new Permiso("/Profesor","Profesores"));
         permisos.add(new Permiso("#","Usuarios"));
        permisos.add(new Permiso("#","Aulas"));
        permisos.add(new Permiso("#","Carreras"));
        permisos.add(new Permiso("#","Clases"));
        permisos.add(new Permiso("#","Alumnos"));
        permisos.add(new Permiso("/login","Salir"));




         return permisos;
    }
    public static  ArrayList<Permiso> PermisosProfesor()
    {
        ArrayList<Permiso> permisos = new ArrayList<>();

        permisos.add(new Permiso("/login","Salir"));




        return permisos;
    }

}
