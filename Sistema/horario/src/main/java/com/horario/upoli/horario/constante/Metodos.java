package com.horario.upoli.horario.constante;

public enum Metodos {
    dialog("dialog"),
    GETE("GET"),
    POST("POST");

    private String mostrar;

    Metodos(String mostrar){
        this.mostrar=mostrar;
    }
    public String mostrar() {
        return mostrar;
    }
}
