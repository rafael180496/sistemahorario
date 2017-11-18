package com.horario.upoli.horario.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
@Table(name = "Det_grupo")
public class Det_grupo {

    @Id
    @Column(name = "id_det_grupo")
   private Long id_det_grupo;


    @OneToOne
    @JoinColumn(name="id_alumno")
    private Alumno alumno;


    @OneToOne
    @JoinColumn(name="id_grupo")
    private Grupo grupo;

    @NotNull
    @Column(name = "f_creacion")
    private Date f_creacion  ;

    public Det_grupo(Alumno alumno, Grupo grupo, Date f_creacion) {
        this.alumno = alumno;
        this.grupo = grupo;
        this.f_creacion = f_creacion;
    }

    public Det_grupo() {
    }

    public Long getId_det_grupo() {
        return id_det_grupo;
    }

    public void setId_det_grupo(Long id_det_grupo) {
        this.id_det_grupo = id_det_grupo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Date getF_creacion() {
        return f_creacion;
    }

    public void setF_creacion(Date f_creacion) {
        this.f_creacion = f_creacion;
    }
}
