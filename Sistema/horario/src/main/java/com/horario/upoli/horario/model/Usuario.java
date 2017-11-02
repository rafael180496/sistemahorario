package com.horario.upoli.horario.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    private Long id_usuario;

    @NotNull
    @Column(name = "id_profesor")
    private  Long id_profesor;

    @NotNull
    @Column(name = "nom_usr")
    private String nom_usr;

    @NotNull
    @Column(name = "clave")
    private String clave;

    @NotNull
    @Column(name = "ind_rest")
    private Boolean ind_rest;

    @NotNull
    @Column(name = "ind_adm")
    private Boolean ind_adm;

    @NotNull
    @Column(name = "f_creacion")
    private Date f_creacion;

    public Usuario(Long id_profesor, String nom_usr, String clave, Boolean ind_rest, Boolean ind_adm, Date f_creacion) {
        this.id_profesor = id_profesor;
        this.nom_usr = nom_usr;
        this.clave = clave;
        this.ind_rest = ind_rest;
        this.ind_adm = ind_adm;
        this.f_creacion = f_creacion;
    }

    public Usuario() {
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Long id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNom_usr() {
        return nom_usr;
    }

    public void setNom_usr(String nom_usr) {
        this.nom_usr = nom_usr;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getInd_rest() {
        return ind_rest;
    }

    public void setInd_rest(Boolean ind_rest) {
        this.ind_rest = ind_rest;
    }

    public Boolean getInd_adm() {
        return ind_adm;
    }

    public void setInd_adm(Boolean ind_adm) {
        this.ind_adm = ind_adm;
    }

    public Date getF_creacion() {
        return f_creacion;
    }

    public void setF_creacion(Date f_creacion) {
        this.f_creacion = f_creacion;
    }
}
