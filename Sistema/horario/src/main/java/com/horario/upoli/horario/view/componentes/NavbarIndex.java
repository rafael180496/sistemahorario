package com.horario.upoli.horario.view.componentes;

public class NavbarIndex {
    private  String titulo="";
    private  String navegacion="";
    private  String ul_nombre="";


    public  String Generar_navbar(){
        String resultado="<nav class=\"white\" role=\"navigation\">\n" +
                "        <div class=\"nav-wrapper container\">\n" +
                "            <a id=\"logo-container\" href=\"#\" class=\"brand-logo\">"+titulo+"</a>\n" +
                "            <ul class=\"right hide-on-med-and-down\">\n" +
                "                <li>\n" +
                "                    <a href=\""+navegacion+"\">"+ul_nombre+"</a>\n" +
                "                </li>\n" +
                "            </ul>\n" +
                "            \n" +
                "            <ul id=\"nav-mobile\" class=\"side-nav\">\n" +
                "                <li>\n" +
                "                    <a href=\""+navegacion+"\">"+ul_nombre+"</a>\n" +
                "                </li>\n" +
                "            </ul>\n" +
                "            <a href=\"#\" data-activates=\"nav-mobile\" class=\"button-collapse\">\n" +
                "                <i class=\"material-icons\">menu</i>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "    </nav> ";

        return resultado;
    }

    public NavbarIndex(String titulo, String navegacion, String ul_nombre) {
        this.titulo = titulo;
        this.navegacion = navegacion;
        this.ul_nombre = ul_nombre;
    }

    public NavbarIndex() {

        this.titulo = "#";
        this.navegacion = "#";
        this.ul_nombre = "#";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNavegacion() {
        return navegacion;
    }

    public void setNavegacion(String navegacion) {
        this.navegacion = navegacion;
    }

    public String getUl_nombre() {
        return ul_nombre;
    }

    public void setUl_nombre(String ul_nombre) {
        this.ul_nombre = ul_nombre;
    }
}
