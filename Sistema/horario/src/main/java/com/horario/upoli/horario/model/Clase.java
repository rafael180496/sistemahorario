package com.horario.upoli.horario.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "Clase")
public class Clase {
    @Id
    @Column(name = "id_clase")
    private Long id_clase ;

    @NotNull
    @Column(name = "nombre")
    private String nombre  ;

    @NotNull
    @Column(name = "f_creacion")
    private Date f_creacion ;

    public Clase(String nombre, Date f_creacion) {
        this.nombre = nombre;
        this.f_creacion = f_creacion;
    }

    public Long getId_clase() {
        return id_clase;
    }

    public void setId_clase(Long id_clase) {
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
