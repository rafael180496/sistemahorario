package com.horario.upoli.horario.view.componentes;

public class Usuario_Env {
    private  String usuarios ;
    private  String claves;

    public Usuario_Env() {
    }

    public Usuario_Env(String usuarios, String claves) {
        this.usuarios = usuarios;
        this.claves = claves;
    }

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public String getClaves() {
        return claves;
    }

    public void setClaves(String claves) {
        this.claves = claves;
    }
}

