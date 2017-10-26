package com.horario.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="carrera")
public class Carrera implements Serializable {
    @Id
    @Column(name="id_carrera")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_carrera ;

    @Column(name="nombre")
    private String  nombre;

    @Column(name="f_creacion")
    private Date f_creacion;

    public Carrera() {
        super();
    }

    public Carrera(String nombre, Date f_creacion) {
        super();
        this.nombre = nombre;
        this.f_creacion = f_creacion;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
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
