package com.horario.upoli.horario.view.componentes;

public class NavbarIndex {
    private  String titulo="";
    private  String navegacion="";
    private  String ul_nombre="";


    public  String Generar_navbar(){

        String resultado="<div class=\"navbar-fixed\">\n" +
                "            <nav>\n" +
                "                <div class=\"nav-wrapper white\">\n" +
                "                    <a href=\"#!\" class=\" color brand-logo \">\n" +
                "                        <img class=\"responsive-img\" id=\"logo\" src=\"https://firebasestorage.googleapis.com/v0/b/horario-8c987.appspot.com/o/Img%2Flogo.png?alt=media&token=8b556b15-bb58-4f1c-9043-4983d559fe45\" alt=\"\">\n" +
                "                    </a>\n" +
                "\n" +
                "                    <a href=\"#\" data-activates=\"mobile-demo\" class=\"button-collapse \">\n" +
                "                        <i class=\"material-icons tealicon\">menu</i>\n" +
                "                    </a>\n" +
                "                    <ul class=\"right hide-on-med-and-down \">\n" +
                "                        <li>\n" +
                "                    <a href=\""+navegacion+"\"><i class=\"material-icons left\">account_circle</i>"+ul_nombre+"</a>\n" +
                "                        </li>\n" +
                "\n" +
                "                    </ul>\n" +
                "                    <ul class=\"side-nav\" id=\"mobile-demo\" >\n" +
                "\n" +
                "                        <li>\n" +
                "                    <a href=\""+navegacion+"\" ><i class=\"material-icons left\">account_circle</i>"+ul_nombre+"</a>\n" +
                "                        </li>\n" +
                "                    </ul>\n" +
                "                </div>\n" +
                "            </nav>\n" +
                "        </div>";



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
