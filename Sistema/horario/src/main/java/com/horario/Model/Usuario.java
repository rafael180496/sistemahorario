package com.horario.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    @Id
    @Column(name="id_usuario")
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int id_usuario;

    @Column(name="nom_usr")
   private String nom_usr;

    @Column(name="clave")
   private String clave;

    @Column(name="id_profesor")
   private int id_profesor;

    @Column(name="ind_adm")
   private boolean ind_adm;

    @Column(name="f_creacion")
   private Date f_creacion;

    public Usuario() {
        super();
    }

    public Usuario(String nom_usr, String clave, int id_profesor, boolean ind_adm, Date f_creacion) {
        super();
        this.nom_usr = nom_usr;
        this.clave = clave;
        this.id_profesor = id_profesor;
        this.ind_adm = ind_adm;
        this.f_creacion = f_creacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public boolean isInd_adm() {
        return ind_adm;
    }

    public void setInd_adm(boolean ind_adm) {
        this.ind_adm = ind_adm;
    }

    public Date getF_creacion() {
        return f_creacion;
    }

    public void setF_creacion(Date f_creacion) {
        this.f_creacion = f_creacion;
    }
}
