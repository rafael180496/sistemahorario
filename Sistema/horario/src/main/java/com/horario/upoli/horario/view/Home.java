package com.horario.upoli.horario.view;

import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.view.componentes.Footer;
import com.horario.upoli.horario.view.componentes.Html;
import com.horario.upoli.horario.view.componentes.Navbar;
import com.horario.upoli.horario.view.constante.Estilos;
import com.horario.upoli.horario.view.constante.Scrips;
import com.horario.upoli.horario.view.seguridad.Permisos;

import java.util.ArrayList;

public class Home {
    private Html html = new Html();
    private Navbar navbar = new Navbar("SDH");
    private Usuario usuario= new Usuario();

    public Home(Usuario usuario) {
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
        cuerpo.add(Footer.getFooter());
        html.setCuerpo(cuerpo);

        return html.Generar_Html();
    }


    private ArrayList<String> Enviar_scrip(){
        ArrayList <String> escr= new ArrayList<>();
        escr.add(Scrips.jquery.mostrar());
        escr.add(Scrips.materialize.mostrar());

        return escr;
    }

    private ArrayList <String> Enviar_Estilo(){
        ArrayList <String> est= new ArrayList<>();
        est.add(Estilos.Material_Icons.mostrar());
        est.add(Estilos.materialize.mostrar());

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

}
