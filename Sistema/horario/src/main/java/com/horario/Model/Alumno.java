package com.horario.Model;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name="alumno")
public class Alumno  {
    @Id
    @Column(name="carnet")
    private String carnet ;

    @Column(name="nombre")
    private String nombre  ;

    @Column(name="apellido")
    private String apellido ;

    @Column(name="id_carrera")
    private int id_carrera;

    @Column(name="f_creacion")
    private Date f_creacion ;

    public Alumno() {

    }

    public Alumno(String carnet, String nombre, String apellido, int id_carrera, Date f_creacion) {

        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_carrera = id_carrera;
        this.f_creacion = f_creacion;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public Date getF_creacion() {
        return f_creacion;
    }

    public void setF_creacion(Date f_creacion) {
        this.f_creacion = f_creacion;
    }
}
