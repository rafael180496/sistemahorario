package com.horario.upoli.horario.view.login;

import com.horario.upoli.horario.constante.EstilosK;
import com.horario.upoli.horario.constante.Metodos;
import com.horario.upoli.horario.constante.Scrips;
import com.horario.upoli.horario.recursos.Link;
import com.horario.upoli.horario.view.componentes.Formulario;
import com.horario.upoli.horario.view.componentes.Html;

import java.util.ArrayList;

public class LoginResta {

    private Html html = new Html();

    public LoginResta() {
    }

    public String Generar_login_c(){


        html.setTitulo("SDH");
        html.setEstilos(Enviar_Estilo());
        html.setScrip(Enviar_scrip());
        ArrayList<String> cuerpo_l = new ArrayList<>();
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
        est.add(EstilosK.Material_Icons.getMostrar());
        est.add(EstilosK.materialize.getMostrar());
        est.add(EstilosK.logincss.getMostrar());
        return  est;
    }

    private String Enviar_Formulario(){

        Link regresar=new Link("Regresar","/login");
        Formulario formulario= new Formulario();
        formulario.setMetodo(Metodos.POST.mostrar());
        formulario.setId_f("");
        formulario.setAccion("/login/cambiar/guardar");
        ArrayList <String> cuerpo_f= new ArrayList<>();
//--------------------------------------------------------------------
        cuerpo_f.add("<div class='row'>\n" +
                "                                <div class='col s12'>\n" +
                "                                    <img src=\"https://firebasestorage.googleapis.com/v0/b/horario-8c987.appspot.com/o/Img%2Fkey.png?alt=media&token=bc2c87fa-454e-4a35-91f8-240370ff474d\" alt=\"\" class=\" responsive-img valign profile-image-login\">\n" +
                "                                    ");
//--------------------------------------------------------------------

        cuerpo_f.add("<h5>Restablecer Clave</h5>");


        //--------------------------------------------------------------------
        cuerpo_f.add("</div>\n" +
                "                            </div>");
        //--------------------------------------------------------------------
        cuerpo_f.add("<div class='row'>\n" +
                "                                <div class='input-field col s12'>\n" +
                "                                    <input class='validate' type=\"password\" required=\"\" aria-required=\"true\" name='txt_clave_n' id='txt_clave_n' value='' />\n" +
                "                                    <label for='txt_clave_n'>Nueva Clave</label>\n" +
                "                                </div>\n" +
                "                            </div>");

        cuerpo_f.add("<div class='row'>\n" +
                "                                <div class='input-field col s12'>\n" +
                "                                    <input class='validate' type=\"password\" required=\"\" aria-required=\"true\" name='txt_clave_c' id='txt_clave_c' value='' />\n" +
                "                                    <label for='txt_clave_c'>Confirmar Clave</label>\n" +
                "                                </div>\n" +
                "                            </div>");

        //--------------------------------------------------------------------


        cuerpo_f.add("<br />\n" +
                "                            <center>\n" +
                "                                <div class='row'>");

        //--------------------------------------------------------------------
        cuerpo_f.add("<br>\n" +
                "                                    <input type=\"submit\" value=\"Recuperar\" class='col s12 btn btn-large waves-effect '>\n" );
        cuerpo_f.add(regresar.Generar_a());

        cuerpo_f.add("                                </div>" +
                "                                    </center>");
        formulario.setCuerpo_formulario(cuerpo_f);


        return formulario.Generar_formulario();

    }
}
