package com.horario.upoli.horario.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "Alumno")
public class Alumno {
    @Id
    @Column(name = "id_alumno")
private  Long   id_alumno;

    @NotNull
    @Column(name = "carnet")
 private  String carnet ;

    @NotNull
    @Column(name = "nombre")
 private  String   nombre ;

    @NotNull
    @Column(name = "apellido")
 private  String   apellido;

    @OneToOne
    @JoinColumn(name="carrera")
 private  Carrera  carrera ;

    @NotNull
    @Column(name = "f_creacion")
 private  Date f_creacion  ;

    public Alumno(String carnet, String nombre, String apellido, Carrera carrera, Date f_creacion) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.f_creacion = f_creacion;
    }

    public Alumno() {
    }

    public Long getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Long id_alumno) {
        this.id_alumno = id_alumno;
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

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Date getF_creacion() {
        return f_creacion;
    }

    public void setF_creacion(Date f_creacion) {
        this.f_creacion = f_creacion;
    }
}
