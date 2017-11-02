package com.horario.upoli.horario.view.clase;

import com.horario.upoli.horario.model.Clase;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.view.componentes.Footer;
import com.horario.upoli.horario.view.componentes.Formulario;
import com.horario.upoli.horario.view.componentes.Html;
import com.horario.upoli.horario.view.componentes.Navbar;
import com.horario.upoli.horario.view.constante.Estilos;
import com.horario.upoli.horario.view.constante.Metodos;
import com.horario.upoli.horario.view.constante.Scrips;
import com.horario.upoli.horario.view.seguridad.Permisos;

import java.sql.Date;
import java.util.ArrayList;

public class EditClase {

    private Html html = new Html();
    private Usuario usuario = new Usuario();
    private Clase clase= new Clase();
    private boolean nuevo=false;

    public EditClase(Usuario usuario, boolean nuevo) {
        this.usuario = usuario;
        this.nuevo = nuevo;
    }

    public EditClase() {
    }

    public EditClase(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    private  String Generar_navBar()
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


    private String Enviar_Formulario(){
        Permiso btm_verde= new Permiso("","");
        Permiso btm_rojo= new Permiso("/Clase","Cancelar");
        Formulario formulario= new Formulario();
        ArrayList<String> cuerpo= new ArrayList();
        String titulo= "";


        if(nuevo){
            clase.setNombre("");
            java.util.Date  fecha = new java.util.Date();
            clase.setF_creacion(new Date(fecha.getTime()));
            btm_verde= new Permiso("/Clase/Guardar/0","Guardar");
            titulo= "Agregar Clase";

        }
        else {
            btm_verde= new Permiso("/Clase/Guardar/"+clase.getId_clase(),"Actualizar");
            titulo= "Editar Clase";
        }
        //////////////////////////
        formulario.setAccion(btm_verde.getAccion());
        formulario.setMetodo(Metodos.POST.mostrar());
        cuerpo.add("<div class=\"card-content \">\n" +
                "                            <p class=\"card-title\">"+titulo+"</p>\n" +
                "                           \n" +
                "                            <div class=\"input-field \">\n" +
                "                                <input id=\"txt_nombre\" type=\"text\"  data-length=\"50\"  value=\""+clase.getNombre()+"\" name=\"txt_nombre\" class=\"validate\">\n" +
                "                                <label for=\"txt_nombre\">Nombre:</label>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"card-action \">\n" +
                "                                <input type=\"submit\" class=\"waves-effect waves-light btn\" value=\""+btm_verde.getNombre()+"\" >\n" +
                "                                <a class=\"waves-effect waves-light btn red\" href=\""+btm_rojo.getAccion()+"\">"+btm_rojo.getNombre()+"</a>\n" +
                "                        </div>");
        formulario.setCuerpo_formulario(cuerpo);
        return formulario.Generar_formulario();
    }


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
}
