package com.horario.upoli.horario.view;

import com.horario.upoli.horario.recursos.Link;
import com.horario.upoli.horario.view.componentes.Formulario;
import com.horario.upoli.horario.view.componentes.Html;
import com.horario.upoli.horario.view.constante.Estilos;
import com.horario.upoli.horario.view.constante.Metodos;
import com.horario.upoli.horario.view.constante.Scrips;

import java.util.ArrayList;

public class Login {
    private Html html = new Html();


    public String Generar_login(){
        html.setTitulo("SDH");
        html.setEstilos(Enviar_Estilo());
        html.setScrip(Enviar_scrip());
        ArrayList <String> cuerpo_l = new ArrayList<>();
//------------------------------------------------------------------------------------
        cuerpo_l.add("<div class=\"section\"></div>\n" +
                "    <main>\n" +
                "        <center>\n" +
                "            <div class=\"section\"></div>\n" +
                "            <div class=\"section\"></div>\n" +
                "            <div class=\"section\"></div>\n" +
                "            <div class=\"container\">\n" +
                "                <div class=\"z-depth-1 grey lighten-4 row\" style=\"display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;\">\n" +
                "                    <div  class=\"col s12\">");

        //------------------------------------------------------------------------------------
        cuerpo_l.add(Enviar_Formulario());
        //------------------------------------------------------------------------------------
        cuerpo_l.add("</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </center>\n" +
                "    \n" +
                "        <div class=\"section\"></div>\n" +
                "        <div class=\"section\"></div>\n" +
                "    </main>");
        //------------------------------------------------------------------------------------
        html.setCuerpo(cuerpo_l);
        //------------------------------------------------------------------------------------
        return html.Generar_Html();
    }

    private ArrayList <String> Enviar_scrip(){
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

    private String Enviar_Formulario(){
        Link regresar=new Link("Regresar","/");
        Formulario formulario= new Formulario();
        formulario.setMetodo(Metodos.dialog.mostrar());
        formulario.setAccion("");
        ArrayList <String> cuerpo_f= new ArrayList<>();
//--------------------------------------------------------------------
        cuerpo_f.add("<div class='row'>\n" +
                "                                <div class='col s12'>\n" +
                "                                    <img src=\"https://firebasestorage.googleapis.com/v0/b/horario-8c987.appspot.com/o/Img%2Fstudent.png?alt=media&token=66c0b9b7-1369-4d8d-bb75-96497fdb37ca\"\n" +
                "                                        alt=\"\" class=\"circle responsive-img valign profile-image-login\">\n" +
                "                                    \n" +
                "                                </div>\n" +
                "                            </div>");
//--------------------------------------------------------------------
        cuerpo_f.add("<div class='row'>\n" +
                "                                <div class='input-field col s12'>\n" +
                "                                    <input class='validate' type=\"text\" name='txt_usuario' id='usuario' />\n" +
                "                                    <label for='usuario'>Usuario</label>\n" +
                "                                </div>\n" +
                "                            </div>");
        //--------------------------------------------------------------------
        cuerpo_f.add(" <div class='row'>\n" +
                "                                <div class='input-field col s12'>\n" +
                "                                    <input class='validate' type='password' name='txt_clave' id='clave' />\n" +
                "                                    <label for='clave'>Clave</label>\n" +
                "                                </div>\n" +
                "                            \n" +
                "                            </div>");
        //--------------------------------------------------------------------
        cuerpo_f.add("<br />\n" +
                "                            <center>\n" +
                "                                <div class='row'>");
        //--------------------------------------------------------------------
        cuerpo_f.add(regresar.Generar_a());
        //--------------------------------------------------------------------
        cuerpo_f.add("<br>\n" +
                "                                    <input type=\"submit\" value=\"Ingresar\" class='col s12 btn btn-large waves-effect '>\n" +
                "                                </div>\n" +
                "                            </center>");

        formulario.setCuerpo_formulario(cuerpo_f);

        return formulario.Generar_formulario();

    }
}