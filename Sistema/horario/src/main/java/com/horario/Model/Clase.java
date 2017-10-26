package com.horario.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="clase")
public class Clase {

    @Id
    @Column(name="id_clase")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_clase ;

    @Column(name="nombre")
    private String nombre  ;

    @Column(name="f_creacion")
    private Date f_creacion;

    public Clase() {

    }

    public Clase(String nombre, Date f_creacion) {
        this.nombre = nombre;
        this.f_creacion = f_creacion;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
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
