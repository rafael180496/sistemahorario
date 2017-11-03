package com.horario.upoli.horario.view.componentes;

import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.view.constante.Estilos;
import com.horario.upoli.horario.view.constante.Scrips;
import com.horario.upoli.horario.view.seguridad.Permisos;

import java.util.ArrayList;

public abstract class Editor {
    protected Html html = new Html();
    private Usuario usuario = new Usuario();
    private boolean nuevo=false;


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
        cuerpo.add(Footer.getFooter());
        html.setCuerpo(cuerpo);
        return html.Generar_Html();
    }

    public Editor(Usuario usuario) {
        this.usuario = usuario;
    }

    protected ArrayList<String> Enviar_scrip(){
        ArrayList <String> escr= new ArrayList<>();
        escr.add(Scrips.jquery.mostrar());
        escr.add(Scrips.materialize.mostrar());

        return escr;
    }

    protected ArrayList <String> Enviar_Estilo(){
        ArrayList <String> est= new ArrayList<>();
        est.add(Estilos.Material_Icons.mostrar());
        est.add(Estilos.materialize.mostrar());

        return  est;
    }

    protected  String Generar_navBar()
    {
        Navbar navbar= new Navbar("SDH");
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

    public Editor(Usuario usuario, boolean nuevo) {
        this.usuario = usuario;
        this.nuevo = nuevo;
    }

    public Editor(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public Editor() {
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public boolean isNuevo() {
        return nuevo;
    }
    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }
}
