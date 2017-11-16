package com.horario.upoli.horario.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "Alumno")
public class Grupo {

    @Id
    @Column(name = "id_grupo")
    private Long  id_grupo;

    @OneToOne
    @JoinColumn(name="id_profesor")
   private Profesor profesor;

    @OneToOne
    @JoinColumn(name="id_clase")
   private Clase clase;

    @NotNull
    @Column(name = "nombre")
   private String nombre;

    @NotNull
    @Column(name = "f_creacion")
   private Date f_creacion ;

    public Grupo(Profesor profesor, Clase clase, String nombre, Date f_creacion) {
        this.profesor = profesor;
        this.clase = clase;
        this.nombre = nombre;
        this.f_creacion = f_creacion;
    }

    public Grupo() {
    }

    public Long getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(Long id_grupo) {
        this.id_grupo = id_grupo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
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
