package com.horario.upoli.horario.view.seguridad;

public enum Correo {
    Usuario("sistemahorarioSDH@gmail.com"),
    Clave("upoli123");


    private String mostrar;


    Correo(String mostrar){
        this.mostrar=mostrar;
    }
    public String mostrar() {
        return mostrar;
    }
}
