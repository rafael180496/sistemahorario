package com.horario.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="profesor")
public class Profesor  {
    @Id
    @Column(name="id_profesor")
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int id_profesor;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="f_creacion")
    private Date f_creacion;

    public Profesor() {

    }

    public Profesor(String nombre, String apellido, Date f_creacion) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.f_creacion = f_creacion;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
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

    public Date getF_creacion() {
        return f_creacion;
    }

    public void setF_creacion(Date f_creacion) {
        this.f_creacion = f_creacion;
    }
}
