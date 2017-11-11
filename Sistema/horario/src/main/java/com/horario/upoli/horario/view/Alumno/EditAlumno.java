package com.horario.upoli.horario.view.Alumno;

import com.horario.upoli.horario.model.Alumno;
import com.horario.upoli.horario.model.Carrera;
import com.horario.upoli.horario.view.componentes.Editor;

import java.util.ArrayList;

public class EditAlumno extends Editor {
    private Alumno alumno= new Alumno();
    private ArrayList<Carrera> carreras= new ArrayList<>();


    @Override
    public String Enviar_Formulario() {
        return null;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }
}
