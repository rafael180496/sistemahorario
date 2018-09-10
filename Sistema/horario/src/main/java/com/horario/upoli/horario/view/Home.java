package com.horario.upoli.horario.view;


import com.horario.upoli.horario.constante.EstilosK;
import com.horario.upoli.horario.constante.ScripsK;
import com.horario.upoli.horario.model.UsuarioK;
import com.horario.upoli.horario.recursos.PermisoK;
import com.horario.upoli.horario.seguridad.PermisosK;
import com.horario.upoli.horario.view.componentes.FooterK;
import com.horario.upoli.horario.view.componentes.Html;
import com.horario.upoli.horario.view.componentes.NavbarK;

import java.util.ArrayList;

public class Home {
    private Html html = new Html();
    private NavbarK navbar = new NavbarK();
    private UsuarioK usuario= new UsuarioK();

    public Home(UsuarioK usuario) {
        this.usuario = usuario;
    }

    public String Generar_Home()
    {
        html.setTitulo("SDH");
        html.setScrip(Enviar_scrip());
        html.setEstilos(Enviar_Estilo());
        html.setScrip_manual(Enviar_scrip_manual());



        ArrayList<String >cuerpo = new ArrayList<>();

        /*=================================================*/
        cuerpo.add(Generar_navBar());
         /*=================================================*/
        cuerpo.add("<div class=\"container\">\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"col s12\">\n" +
                "                <br>\n" +
                "                <div class=\"carousel carousel-slider center \" data-indicators=\"true\">\n" +
                "\n" +
                "                    <div class=\"carousel-item red white-text\" href=\"#one!\">\n" +
                "\n" +
                "                        <h2>Prueba1</h2>\n" +
                "                        <p class=\"white-text\">Prueba1</p>\n" +
                "                    </div>\n" +
                "                    <div class=\"carousel-item amber white-text\" href=\"#two!\">\n" +
                "                        <h2>Prueba2</h2>\n" +
                "                        <p class=\"white-text\">Prueba2</p>\n" +
                "                    </div>\n" +
                "                    <div class=\"carousel-item green white-text\" href=\"#three!\">\n" +
                "                        <h2>Prueba3</h2>\n" +
                "                        <p class=\"white-text\">Prueba3</p>\n" +
                "                    </div>\n" +
                "                    <div class=\"carousel-item blue white-text\" href=\"#four!\">\n" +
                "                        <h2>Prueba4</h2>\n" +
                "                        <p class=\"white-text\">Prueba4</p>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>");
        /*=================================================*/
        cuerpo.add(FooterK.Companion.getFooter());
        html.setCuerpo(cuerpo);

        return html.Generar_Html();
    }


    private ArrayList<String> Enviar_scrip(){
        ArrayList <String> escr= new ArrayList<>();
        escr.add(ScripsK.jquery.getMostrar());
        escr.add(ScripsK.materialize.getMostrar());

        return escr;
    }

    private ArrayList <String> Enviar_Estilo(){
        ArrayList <String> est= new ArrayList<>();
        est.add(EstilosK.Material_Icons.getMostrar());
        est.add(EstilosK.materialize.getMostrar());
        est.add(EstilosK.fonts.getMostrar());
        est.add(EstilosK.general.getMostrar());
        return  est;
    }



    private String Enviar_scrip_manual(){

        return "<script>\n" +
                "        $('.carousel.carousel-slider').carousel({\n" +
                "            fullWidth: true\n" +
                "        });\n" +
                "        $(\".button-collapse\").sideNav();\n" +
                "    </script>";
    }


    private  String Generar_navBar()
    {
        navbar.setProyecto("SDH");

        if (usuario.getInd_adm())
        {
            for (PermisoK n: PermisosK.Companion.PermisosAdmin()
                 ) {
                navbar.Agregar_propiedad(n.getNombre(),n.getAccion());
            }
        }
        else
        {
            for (PermisoK n: PermisosK.Companion.PermisosProfesor()
                    ) {
                navbar.Agregar_propiedad(n.getNombre(),n.getAccion());
            }
        }


        return navbar.Generar_Navbar();
    }

}
