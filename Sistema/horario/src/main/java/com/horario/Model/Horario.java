package com.horario.Model;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name="horario")
public class Horario {

    @Id
    @Column(name="id_horario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_horario;

    @Column(name="id_clase")
    private int id_clase;

    @Column(name="id_grupo")
    private int id_grupo;

    @Column(name="id_aula")
    private int id_aula;

    @Column(name="dia")
    private String dia;

    @Column(name="hora_inicio")
    private int hora_inicio;

    @Column(name="min_inicio")
    private int min_inicio;

    @Column(name="hora_fin")
    private int hora_fin;

    @Column(name="min_fin")
    private int min_fin;

    @Column(name="f_creacion")
    private Date f_creacion;

    public Horario() {

    }

    public Horario(int id_clase, int id_grupo, int id_aula, String dia, int hora_inicio, int min_inicio, int hora_fin, int min_fin, Date f_creacion) {

        this.id_clase = id_clase;
        this.id_grupo = id_grupo;
        this.id_aula = id_aula;
        this.dia = dia;
        this.hora_inicio = hora_inicio;
        this.min_inicio = min_inicio;
        this.hora_fin = hora_fin;
        this.min_fin = min_fin;
        this.f_creacion = f_creacion;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public int getId_aula() {
        return id_aula;
    }

    public void setId_aula(int id_aula) {
        this.id_aula = id_aula;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(int hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getMin_inicio() {
        return min_inicio;
    }

    public void setMin_inicio(int min_inicio) {
        this.min_inicio = min_inicio;
    }

    public int getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(int hora_fin) {
        this.hora_fin = hora_fin;
    }

    public int getMin_fin() {
        return min_fin;
    }

    public void setMin_fin(int min_fin) {
        this.min_fin = min_fin;
    }

    public Date getF_creacion() {
        return f_creacion;
    }

    public void setF_creacion(Date f_creacion) {
        this.f_creacion = f_creacion;
    }
}
