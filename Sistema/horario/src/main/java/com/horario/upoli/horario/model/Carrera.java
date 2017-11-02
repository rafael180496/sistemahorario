package com.horario.upoli.horario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
@Table(name = "Carrera")
public class Carrera {

    @Id
    @Column(name = "id_carrera")
    private  Long id_carrera ;

    @NotNull
    @Column(name = "nombre")
    private String nombre;


    @NotNull
    @Column(name = "f_creacion")
    private Date f_creacion ;

    public Carrera(String nombre, Date f_creacion) {
        this.nombre = nombre;
        this.f_creacion = f_creacion;
    }

    public Carrera() {
    }

    public Long getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(Long id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getF_creacion() {
        return f_creacion;
    }

    public void setF_creacion(Date f_creacion) {
        this.f_creacion = f_creacion;
    }
}
