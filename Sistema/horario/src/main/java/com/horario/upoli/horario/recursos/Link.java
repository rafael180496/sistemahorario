package com.horario.upoli.horario.recursos;

public class Link {
    private String titulo ="";
    private String navegacion="";

    public Link() {
    }

    public Link(String titulo, String navegacion) {
        this.titulo = titulo;
        this.navegacion = navegacion;
    }

    public  String Generar_a(){
        return "<a href=\""+navegacion+"\">"+titulo+"</a>";
    }
}
