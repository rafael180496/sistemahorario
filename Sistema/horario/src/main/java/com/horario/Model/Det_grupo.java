package com.horario.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
@Entity
@Table(name="det_grupo")
public class Det_grupo {

    @Column(name="carnet")
    private String carnet;

    @Column(name="id_grupo")
    private int id_grupo;

    @Column(name="f_creacion")
    private Date f_creacion;

    public Det_grupo() {

    }

    public Det_grupo(String carnet, int id_grupo, Date f_creacion) {

        this.carnet = carnet;
        this.id_grupo = id_grupo;
        this.f_creacion = f_creacion;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public Date getF_creacion() {
        return f_creacion;
    }

    public void setF_creacion(Date f_creacion) {
        this.f_creacion = f_creacion;
    }
}
