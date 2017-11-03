package com.horario.upoli.horario.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "Aula")
public class Aula {
    @Id
    @Column(name = "id_aula")
    private Long id_aula;

    @NotNull
    @Column(name = "desc_aula")
    private  String desc_aula;

    @NotNull
    @Column(name = "ind_mant")
    private boolean ind_mant;

    @NotNull
    @Column(name = "f_creacion")
    private Date f_creacion;

    public Aula(String desc_aula, boolean ind_mant, Date f_creacion) {
        this.desc_aula = desc_aula;
        this.ind_mant = ind_mant;
        this.f_creacion = f_creacion;
    }

    public Aula() {
    }

    public Long getId_aula() {
        return id_aula;
    }

    public void setId_aula(Long id_aula) {
        this.id_aula = id_aula;
    }

    public String getDesc_aula() {
        return desc_aula;
    }

    public void setDesc_aula(String desc_aula) {
        this.desc_aula = desc_aula;
    }

    public boolean isInd_mant() {
        return ind_mant;
    }

    public void setInd_mant(boolean ind_mant) {
        this.ind_mant = ind_mant;
    }

    public Date getF_creacion() {
        return f_creacion;
    }

    public void setF_creacion(Date f_creacion) {
        this.f_creacion = f_creacion;
    }
}
