package com.horario.upoli.horario.recursos;

public class Nav {
    private String titulo ="";
    private String navegacion="";

    public Nav() {
    }

    public Nav(String titulo, String navegacion) {
        this.titulo = titulo;
        this.navegacion = navegacion;
    }

    public  String Generar_ul(){
        return "<li>\n" +
                "                    <a href=\""+navegacion+"\">"+titulo+"</a>\n" +
                "                </li>";
    }
}
