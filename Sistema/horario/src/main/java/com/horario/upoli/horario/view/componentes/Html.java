package com.horario.upoli.horario.view.componentes;

import java.util.ArrayList;

public class Html  {
   private static final String head_ini="<!DOCTYPE html>\n" +
            "<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
            "<head>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />";

    private static final String head_fin="</head>";
    private String titulo="";
    private ArrayList<String > estilos= new ArrayList<>();
    private ArrayList<String > scrip= new ArrayList<>();
    private ArrayList<String > cuerpo= new ArrayList<>();
    private String scrip_manual="";
    private String estilo_manual="";
    private static final String body_ini="<body>";
    private static final String body_fin="</body>\n" +
            "</html>";

    public Html(String titulo, ArrayList<String> estilos, ArrayList<String> scrip, ArrayList<String> cuerpo, String scrip_manual, String estilo_manual) {
        this.titulo = "<title>"+titulo+"</title>";
        this.estilos = estilos;
        this.scrip = scrip;
        this.cuerpo = cuerpo;
        this.scrip_manual = scrip_manual;
        this.estilo_manual = estilo_manual;
    }

    public Html(String titulo) {
        this.titulo = "<title>"+titulo+"</title>";
        this.estilos.add(" ");
        this.scrip.add(" ");
        this.cuerpo.add(" ");
        this.scrip_manual = " ";
        this.estilo_manual = " ";
    }

    public Html() {
        this.titulo = "<title>Prueba</title>";
        this.estilos.add(" ");
        this.scrip.add(" ");
        this.cuerpo.add(" ");
        this.scrip_manual = " ";
        this.estilo_manual = " ";
    }

    public static String getHead_ini() {
        return head_ini;
    }

    public static String getHead_fin() {
        return head_fin;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = "<title>"+titulo+"</title>";;
    }

    public ArrayList<String> getEstilos() {
        return estilos;
    }

    public void setEstilos(ArrayList<String> estilos) {
        this.estilos = estilos;
    }

    public ArrayList<String> getScrip() {
        return scrip;
    }

    public void setScrip(ArrayList<String> scrip) {
        this.scrip = scrip;
    }

    public ArrayList<String> getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(ArrayList<String> cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getScrip_manual() {
        return scrip_manual;
    }

    public void setScrip_manual(String scrip_manual) {
        this.scrip_manual = scrip_manual;
    }

    public String getEstilo_manual() {
        return estilo_manual;
    }

    public void setEstilo_manual(String estilo_manual) {
        this.estilo_manual = estilo_manual;
    }

    public static String getBody_ini() {
        return body_ini;
    }

    public static String getBody_fin() {
        return body_fin;
    }

    public String Generar_Html() {
        String Resultado="";
        Resultado+=head_ini;
        Resultado+=titulo;
        for (String n:estilos
             ) {
            Resultado+=n;
        }

        Resultado+=estilo_manual;
        Resultado+=head_fin;
        Resultado+=body_ini;
        for (String n:cuerpo
                ) {
            Resultado+=n;
        }
        for (String n:scrip
                ) {
            Resultado+=n;
        }
        Resultado+=scrip_manual;
        Resultado+=body_fin;
        return  Resultado;
    }
}
