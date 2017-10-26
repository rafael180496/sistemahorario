package com.horario.Model;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name="grupo")
public class Grupo  {
    @Id
    @Column(name="id_grupo")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id_grupo;

    @Column(name="id_profesor")
    private int id_profesor;

    @Column(name="id_clase")
    private int id_clase;

    @Column(name="nombre")
    private String nombre;

    @Column(name="f_creacion")
    private Date f_creacion;

    public Grupo() {

    }

    public Grupo(int id_profesor, int id_clase, String nombre, Date f_creacion) {

        this.id_profesor = id_profesor;
        this.id_clase = id_clase;
        this.nombre = nombre;
        this.f_creacion = f_creacion;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
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
