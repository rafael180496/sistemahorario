package com.horario.upoli.horario.recursos;

public class Permiso {
    private String accion ="";
    private String nombre="";

    public Permiso(String accion, String nombre) {
        this.accion = accion;
        this.nombre = nombre;
    }

    public Permiso() {
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
