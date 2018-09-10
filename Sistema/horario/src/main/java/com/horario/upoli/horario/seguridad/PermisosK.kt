@file:JvmName("seguridad")
package com.horario.upoli.horario.seguridad

import com.horario.upoli.horario.recursos.PermisoK

class PermisosK{
    companion object {
        fun PermisosAdmin():ArrayList<PermisoK>{
            return arrayListOf(
                    PermisoK("/Grupo","Grupos"),
                    PermisoK("/Profesor","Profesores"),
                    PermisoK("/Usuario","Usuarios"),
                    PermisoK("/Aula","Aulas"),
                    PermisoK("/Carrera","Carreras"),
                    PermisoK("/Clase","Clases"),
                    PermisoK("/Alumno","Alumnos"),
                    PermisoK("/login","""
                        <i class="material-icons">exit_to_app</i>
                    """)
            )
        }
        fun PermisosProfesor():ArrayList<PermisoK>{
            return arrayListOf(
                    PermisoK("/Grupo","Grupos"),
                    PermisoK("/Alumno","Alumnos"),
                    PermisoK("#","Horarios"),
                    PermisoK("/login","""
                        <i class="material-icons">exit_to_app</i>
                    """)
            )
        }
        fun maximoSecuencial(ids:ArrayList<Long>):Long{
            var maximo:Long=0

            for (n in ids) maximo= if(maximo<n) n else maximo

            return maximo
        }
    }
}