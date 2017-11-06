package com.horario.upoli.horario.view.componentes;

import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.view.constante.Estilos;
import com.horario.upoli.horario.view.constante.MensajeIco;
import com.horario.upoli.horario.view.constante.Scrips;

import java.util.ArrayList;

public class MensajeLogin {
    private String Cuerpo="";
    private boolean btn_cancelar=false;
    private Permiso btn_verde= new Permiso();
    private Permiso btn_rojo= new Permiso();
    private String tipo= MensajeIco.Advertencia.mostrar();
    private Html html = new Html();
    private  String tit= "";

    public MensajeLogin() {
    }

    public MensajeLogin(String cuerpo, Permiso btn_verde, String tipo) {
        Cuerpo = cuerpo;
        this.btn_verde = btn_verde;
        this.tipo = tipo;
    }

    public MensajeLogin(String cuerpo, boolean btn_cancelar, Permiso btn_verde, Permiso btn_rojo, String tipo) {
        Cuerpo = cuerpo;
        this.btn_cancelar = btn_cancelar;
        this.btn_verde = btn_verde;
        this.btn_rojo = btn_rojo;
        this.tipo = tipo;
    }

    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public String getCuerpo() {
        return Cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        Cuerpo = cuerpo;
    }

    public boolean isBtn_cancelar() {
        return btn_cancelar;
    }

    public void setBtn_cancelar(boolean btn_cancelar) {
        this.btn_cancelar = btn_cancelar;
    }

    public Permiso getBtn_verde() {
        return btn_verde;
    }

    public void setBtn_verde(Permiso btn_verde) {
        this.btn_verde = btn_verde;
    }

    public Permiso getBtn_rojo() {
        return btn_rojo;
    }

    public void setBtn_rojo(Permiso btn_rojo) {
        this.btn_rojo = btn_rojo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




    public  String Generar_Mensaje(){

        html.setTitulo("SDH");
        html.setEstilos(Enviar_Estilo());
        html.setScrip(Enviar_scrip());
        ArrayList<String > cuerpo= new ArrayList<>();
        cuerpo.add("<div class=\"section\"></div>\n" +
                "    <main>\n" +
                "        <center>\n" +
                "            <div class=\"section\"></div>\n" +
                "            <div class=\"section\"></div>\n" +
                "            <div class=\"section\"></div>\n" +
                "            <div class=\"container\">\n" +
                "                <div class=\"z-depth-1 grey lighten-4 row\" style=\"display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;\">\n" +
                "                    <div class=\"col s12\">\n" +
                "\n" +
                "                        <div class='row'>\n" +
                "                            <div class='col s12'>\n" +
                "                                <img src=\""+tipo+"\" alt=\"\" class=\"circle responsive-img valign profile-image-login\">\n" +
                "                                <h5>"+tit+"</h5>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <div class='row'>\n" +
                "                            <div class='col s12'>\n" +
                "                                <p>"+Cuerpo+"</p>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <div class='row'>\n" +
                "                            <div class='col s12'>\n" +
                "                                <a class=\"waves-effect waves-light btn\" href=\""+btn_verde.getAccion()+"\">"+btn_verde.getNombre()+"</a>");

        if(btn_cancelar)
        {
            cuerpo.add("<a class=\"waves-effect waves-light btn red\" href=\""+btn_rojo.getAccion()+"\">"+btn_rojo.getNombre()+"</a>");
        }
        cuerpo.add("</div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "        </center>\n" +
                "\n" +
                "        <div class=\"section\"></div>\n" +
                "        <div class=\"section\"></div>\n" +
                "    </main>");




        html.setCuerpo(cuerpo);

        return html.Generar_Html();
    }




    private ArrayList<String> Enviar_scrip(){
        ArrayList <String> escr= new ArrayList<>();
        escr.add(Scrips.jquery.mostrar());
        escr.add(Scrips.materialize.mostrar());
        escr.add(Scrips.init.mostrar());
        return escr;
    }

    private ArrayList <String> Enviar_Estilo(){
        ArrayList <String> est= new ArrayList<>();
        est.add(Estilos.Material_Icons.mostrar());
        est.add(Estilos.materialize.mostrar());
        est.add(Estilos.logincss.mostrar());
        return  est;
    }

}

