package com.horario.upoli.horario.view.componentes;

import com.horario.upoli.horario.constante.MensajeIcoK;
import com.horario.upoli.horario.constante.EstilosK;
import com.horario.upoli.horario.constante.ScripsK;
import com.horario.upoli.horario.recursos.PermisoK;

import java.util.ArrayList;

public class MensajeLogin {
    private String Cuerpo="";
    private boolean btn_cancelar=false;
    private PermisoK btn_verde= new PermisoK();
    private PermisoK btn_rojo= new PermisoK();
    private String tipo= MensajeIcoK.Advertencia.getMostrar();
    private HtmlK html = new HtmlK();
    private  String tit= "";

    public MensajeLogin() {
    }

    public MensajeLogin(String cuerpo, PermisoK btn_verde, String tipo) {
        Cuerpo = cuerpo;
        this.btn_verde = btn_verde;
        this.tipo = tipo;
    }

    public MensajeLogin(String cuerpo, boolean btn_cancelar, PermisoK btn_verde, PermisoK btn_rojo, String tipo) {
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

    public PermisoK getBtn_verde() {
        return btn_verde;
    }

    public void setBtn_verde(PermisoK btn_verde) {
        this.btn_verde = btn_verde;
    }

    public PermisoK getBtn_rojo() {
        return btn_rojo;
    }

    public void setBtn_rojo(PermisoK btn_rojo) {
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
        escr.add(ScripsK.jquery.getMostrar());
        escr.add(ScripsK.materialize.getMostrar());
        escr.add(ScripsK.initK.getMostrar());
        return escr;
    }

    private ArrayList <String> Enviar_Estilo(){
        ArrayList <String> est= new ArrayList<>();
        est.add(EstilosK.Material_Icons.getMostrar());
        est.add(EstilosK.materialize.getMostrar());
        est.add(EstilosK.logincss.getMostrar());
        return  est;
    }

}

