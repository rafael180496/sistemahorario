package com.horario.upoli.horario.view;

import com.horario.upoli.horario.view.componentes.Footer;
import com.horario.upoli.horario.view.componentes.Formulario;
import com.horario.upoli.horario.view.componentes.Html;
import com.horario.upoli.horario.view.componentes.NavbarIndex;
import com.horario.upoli.horario.view.constante.Estilos;
import com.horario.upoli.horario.view.constante.Metodos;
import com.horario.upoli.horario.view.constante.Scrips;

import java.util.ArrayList;

public class Index  {
    private NavbarIndex  navbarIndex = new NavbarIndex();
    private Formulario formulario = new Formulario();


    public String Generar_Index(){

        Html html= new Html();
        ArrayList <String> estilo= new ArrayList<>();
        estilo.add(Estilos.Material_Icons.mostrar());
        estilo.add(Estilos.materialize.mostrar());
        estilo.add(Estilos.style.mostrar());
        ArrayList <String> scrip = new ArrayList<>();
        scrip.add(Scrips.jquery.mostrar());
        scrip.add(Scrips.materialize.mostrar());
        scrip.add(Scrips.init.mostrar());
        ArrayList <String> cuerpoFormulario= new ArrayList<>();
        cuerpoFormulario.add("<div class=\"input-field\">\n" +
                "                            <input value=\"\" id=\"busq_horario\" type=\"text\" name=\"txt_horario\">\n" +
                "                            <label class=\"active\" for=\"busq_horario\">Ingrese su carnet de estudiante para recibir su horario.</label>\n" +
                "                        </div>\n" +
                "                        <input type=\"submit\" value=\"Buscar\" class=\"btn-large waves-effect waves-light teal lighten-1\">");
        formulario.setAccion("");
        formulario.setMetodo(Metodos.dialog.mostrar());
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
        cuerpo_index.add("<div id=\"index-banner\" class=\"parallax-container\">\n" +
                "        <div class=\"section no-pad-bot\">\n" +
                "            <div class=\"container\">\n" +
                "                <br>\n" +
                "                <br>\n" +
                "                <h1 class=\"header center teal-text text-lighten-2\">Sistema  de Horario</h1>\n" +
                "                \n" +
                "                <div class=\"row center\">");
        cuerpo_index.add(formulario.Generar_formulario());
        cuerpo_index.add(" </div>\n" +
                "                <br>\n" +
                "                <br>\n" +
                "\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"parallax\">\n" +
                "            <img src=\"http://gdj.graphicdesignjunction.com/wp-content/uploads/2012/10/background+pattern+design+37.jpg\" alt=\"Unsplashed background img 1\">\n" +
                "        </div>\n" +
                "    </div>");
        cuerpo_index.add(Footer.getFooter());

        html.setCuerpo(cuerpo_index);

        return html.Generar_Html();
    }


}
