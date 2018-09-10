package com.horario.upoli.horario.view.componentes;

import com.horario.upoli.horario.constante.EstilosK;
import com.horario.upoli.horario.constante.ScripsK;
import com.horario.upoli.horario.model.UsuarioK;
import com.horario.upoli.horario.recursos.PermisoK;
import com.horario.upoli.horario.seguridad.PermisosK;

import java.util.ArrayList;

public abstract class Editor {
    protected Html html = new Html();
    private UsuarioK usuario = new UsuarioK();
    private boolean nuevo=false;
    private String scrip_m="";

    public abstract String Enviar_Formulario();
    public String GenerarEditar(){
        ArrayList<String> cuerpo= new ArrayList<>();
        html.setTitulo("SDH");
        html.setScrip(Enviar_scrip());

        html.setEstilos(Enviar_Estilo());



        cuerpo.add(Generar_navBar());
        cuerpo.add("<div class=\"container\">\n" +
                "        <div class=\"section\"></div>\n" +
                "        <div class=\"row\">\n" +
                "\n" +
                "            <div class=\"col s6 offset-s3\">\n" +
                "\n" +
                "                <div class=\"card hoverable  grey lighten-4\">");
        cuerpo.add(Enviar_Formulario());
        cuerpo.add("</div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>");

        cuerpo.add(FooterK.Companion.getFooter());
        html.setCuerpo(cuerpo);
        html.setScrip_manual(scrip_m);
        return html.Generar_Html();
    }

    public Editor(UsuarioK usuario) {
        this.usuario = usuario;
    }

    protected ArrayList<String> Enviar_scrip(){
        ArrayList <String> escr= new ArrayList<>();
        escr.add(ScripsK.jquery.getMostrar());
        escr.add(ScripsK.materialize.getMostrar());
        escr.add(ScripsK.app.getMostrar());
        return escr;
    }

    protected ArrayList <String> Enviar_Estilo(){
        ArrayList <String> est= new ArrayList<>();
        est.add(EstilosK.Material_Icons.getMostrar());
        est.add(EstilosK.materialize.getMostrar());
        est.add(EstilosK.general.getMostrar());
        est.add(EstilosK.fonts.getMostrar());

        return  est;
    }

    protected  String Generar_navBar()
    {
        NavbarK navbar= new NavbarK();
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

    public Editor(UsuarioK usuario, boolean nuevo) {
        this.usuario = usuario;
        this.nuevo = nuevo;
    }

    public Editor(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public Editor() {
    }

    public UsuarioK getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioK usuario) {
        this.usuario = usuario;
    }
    public boolean isNuevo() {
        return nuevo;
    }
    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public String getScrip_m() {
        return scrip_m;
    }

    public void setScrip_m(String scrip_m) {
        this.scrip_m = scrip_m;
    }
}
