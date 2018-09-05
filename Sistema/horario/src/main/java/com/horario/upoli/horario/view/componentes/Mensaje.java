package com.horario.upoli.horario.view.componentes;

import com.horario.upoli.horario.constante.MensajeIcoK;
import com.horario.upoli.horario.constante.EstilosK;
import com.horario.upoli.horario.constante.Scrips;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.seguridad.Permisos;

import java.util.ArrayList;

public class Mensaje {
    private String Cuerpo="";
    private boolean btn_cancelar=false;
    private Permiso btn_verde= new Permiso();
    private Permiso btn_rojo= new Permiso();
    private String tipo= MensajeIcoK.Advertencia.getMostrar();
    private Html html = new Html();


    public Mensaje() {
    }

    public Mensaje(String cuerpo, Permiso btn_verde, String tipo) {
        Cuerpo = cuerpo;
        this.btn_verde = btn_verde;
        this.tipo = tipo;
    }

    public Mensaje(String cuerpo, boolean btn_cancelar, Permiso btn_verde, Permiso btn_rojo, String tipo) {
        Cuerpo = cuerpo;
        this.btn_cancelar = btn_cancelar;
        this.btn_verde = btn_verde;
        this.btn_rojo = btn_rojo;
        this.tipo = tipo;
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

    public  String Generar_Mensaje(Usuario user){

        html.setTitulo("SDH");
        html.setEstilos(Enviar_Estilo());
        html.setScrip(Enviar_scrip());
        ArrayList<String > cuerpo= new ArrayList<>();
        cuerpo.add(Generar_navBar(user));
        cuerpo.add("<div class=\"container\">\n" +
                "        <div class=\"section\"></div>\n" +
                "        <div class=\"row\">\n" +
                "\n" +
                "            <div class=\"col s6 offset-s3\">\n" +
                "\n" +
                "                <div class=\"card hoverable horizontal grey lighten-3\">\n" +
                "                    <div class=\"card-image  \">\n" +
                "                        <img src=\""+tipo+"\" alt=\"\">\n" +
                "                    </div>\n" +
                "                    <div class=\"card-stacked\">\n" +
                "                        <div class=\"card-content \">\n" +
                "                            <p class=\"card-title\">"+Cuerpo+"</p>\n" +
                "\n" +
                "                        </div>\n" +
                "                        <div class=\"card-action \">\n" +
                "                            <a class=\"waves-effect waves-light btn verde\" href=\""+btn_verde.getAccion()+"\">"+btn_verde.getNombre()+"</a>");



            if(btn_cancelar)
            {
                cuerpo.add("<a class=\"waves-effect waves-light btn red rojo\" href=\""+btn_rojo.getAccion()+"\">"+btn_rojo.getNombre()+"</a>");
            }

            cuerpo.add("</div>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </div>"+
            "</div>\"");

            cuerpo.add(Footer.getFooter());
            html.setCuerpo(cuerpo);

        return html.Generar_Html();
    }






    private  String Generar_navBar(Usuario usuario)
    {

         Navbar navbar = new Navbar("SDH");
        if (usuario.getInd_adm())
        {
            for (Permiso n: Permisos.PermisosAdmin()
                    ) {
                navbar.Agregar_propiedad(n.getNombre(),n.getAccion());
            }
        }
        else
        {
            for (Permiso n: Permisos.PermisosProfesor()
                    ) {
                navbar.Agregar_propiedad(n.getNombre(),n.getAccion());
            }
        }


        return navbar.Generar_Navbar();
    }

    private ArrayList<String> Enviar_scrip(){
        ArrayList <String> escr= new ArrayList<>();
        escr.add(Scrips.jquery.mostrar());
        escr.add(Scrips.materialize.mostrar());

        return escr;
    }

    private ArrayList <String> Enviar_Estilo(){
        ArrayList <String> est= new ArrayList<>();
        est.add(EstilosK.Material_Icons.getMostrar());
        est.add(EstilosK.materialize.getMostrar());
        est.add(EstilosK.general.getMostrar());
        est.add(EstilosK.fonts.getMostrar());
        return  est;
    }



}
