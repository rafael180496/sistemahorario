package com.horario.upoli.horario.view;

import com.horario.upoli.horario.constante.EstilosK;
import com.horario.upoli.horario.constante.MetodosK;
import com.horario.upoli.horario.constante.ScripsK;
import com.horario.upoli.horario.view.componentes.*;

import java.util.ArrayList;

public class Index  {
    private NavbarIndexK navbarIndex = new NavbarIndexK();
    private Formulario formulario = new Formulario();


    public String Generar_Index(){

        Html html= new Html();
        ArrayList <String> estilo= new ArrayList<>();
        html.setScrip_manual("<script>\n" +
                "        $(document).ready(function() {\n" +
                "            $('.parallax').parallax();\n" +
                "        });\n" +
                "    </script>");

        estilo.add(EstilosK.Material_Icons.getMostrar());
        estilo.add(EstilosK.materialize.getMostrar());
        estilo.add(EstilosK.index.getMostrar());
        estilo.add(EstilosK.general.getMostrar());

        ArrayList <String> scrip = new ArrayList<>();
        scrip.add(ScripsK.jquery.getMostrar());
        scrip.add(ScripsK.materialize.getMostrar());
        scrip.add(ScripsK.app.getMostrar());
        ArrayList <String> cuerpoFormulario= new ArrayList<>();
        cuerpoFormulario.add("<h1 class=\"header  teal-text \">Sistema de Horario</h1>\n" +
                "                            <div class=\"input-field\">\n" +
                "                                <input value=\"\" id=\"busq_horario\" required=\"\" aria-required=\"true\" class=\"validate\" type=\"text\" name=\"txt_horario\">\n" +
                "                                <label class=\"active\" for=\"busq_horario\">Ingrese su carnet de estudiante para recibir su horario.</label>\n" +
                "\n" +
                "                            </div>\n" +
                "                            <input type=\"submit\" value=\"Buscar\" class=\"btn-large waves-effect waves-light teal lighten-1 \">");
        formulario.setAccion("");
        formulario.setMetodo(MetodosK.dialog.getMostrar());
        formulario.setCuerpo_formulario(cuerpoFormulario);
        //////////////////
        html.setEstilos(estilo);
        html.setTitulo("SDH");
        html.setScrip(scrip);
        ArrayList<String> cuerpo_index = new ArrayList<>();

        ///////////////////
        navbarIndex.setNavegacion("/login");
        navbarIndex.setUl_nombre("Ingrese");
        navbarIndex.setTitulo("SDH");



        cuerpo_index.add(navbarIndex.Generar_navbar());
        cuerpo_index.add("<div class=\"parallax-container\">\n" +
                "            <div class=\"parallax \">\n" +
                "                <img src=\"https://firebasestorage.googleapis.com/v0/b/horario-8c987.appspot.com/o/Img%2Ffondo.png?alt=media&token=a05a752a-c28b-4af5-b069-733866eb67ca\">\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"container\">\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col s12\">\n" +
                "                        <center>");
        cuerpo_index.add(formulario.Generar_formulario());
        cuerpo_index.add(" </center>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>");

        cuerpo_index.add(FooterK.Companion.getFooter());

        html.setCuerpo(cuerpo_index);

        return html.Generar_Html();
    }


}
