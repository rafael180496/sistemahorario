package com.horario.upoli.horario.view.seguridad;

public enum CorreoUser {
    Usuario("sistemahorarioSDH@gmail.com"),
    Clave("upoli123");


    private String mostrar;


    CorreoUser(String mostrar){
        this.mostrar=mostrar;
    }
    public String mostrar() {
        return mostrar;
    }
}
