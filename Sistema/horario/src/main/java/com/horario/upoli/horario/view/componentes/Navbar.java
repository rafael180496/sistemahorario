package com.horario.upoli.horario.view.componentes;

import com.horario.upoli.horario.recursos.Nav;
import com.sun.org.apache.regexp.internal.RE;
import sun.java2d.loops.GeneralRenderer;

import java.util.ArrayList;

public class    Navbar {
   private String proyecto = "";
   private ArrayList<Nav> ul= new ArrayList<>();


    public void Agregar_propiedad(String titulo,String navegacion){
        Nav nuevo =new Nav(titulo,navegacion);
        ul.add(nuevo);
    }

    public Navbar(String proyecto) {
        this.proyecto = proyecto;
    }

    public String Generar_Navbar(){
        String Resultado= "";
        String inicio="<div class=\"navbar-fixed\"><nav class=\"teal accent-4\">\n" +
                "        <div class=\"nav-wrapper \">\n" +
                "            <a href=\"/inicio\" class=\"brand-logo\">"+proyecto+"</a>\n" +
                "            <a href=\"#\" data-activates=\"mobile-demo\" class=\"button-collapse\">\n" +
                "                <i class=\"material-icons\">menu</i>\n" +
                "            </a>\n" +
                "            <ul class=\"right hide-on-med-and-down\">";

        Resultado+=inicio;
        Resultado+=Generar_lista();
        Resultado+="</ul>\n" +
                "            <ul class=\"side-nav\" id=\"mobile-demo\">";
        Resultado+=Generar_lista();
        Resultado+="</ul>\n" +
                "        </div>\n" +
                "    </nav></div>";
        return Resultado;

    }

    private String Generar_lista(){
        String Resultado ="";
        for (Nav n:ul
             ) {

            Resultado+=n.Generar_ul();
        }
        return Resultado;
    }
}
