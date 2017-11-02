package com.horario.upoli.horario.view;

import com.horario.upoli.horario.model.Profesor;
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
import java.util.ArrayList;

public class Admi_Profesor  {
    private Html html = new Html();
    private Navbar navbar= new Navbar("SDH");
    private Usuario usuario= new Usuario();
    private Formulario  formulario= new Formulario();
    private String Filtrar= "";
    ArrayList<Profesor> Aux= new ArrayList<>();




    public Admi_Profesor(Usuario usuario,ArrayList<Profesor> Aux) {
        this.Aux=Aux;
        this.usuario = usuario;
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


    private String  Generar_table(){
        String Resultado ="";
        String Add="/Profesor/Editar/0";
        String Inicio=" <table class=\"highlight responsive-table  bordered centered\">\n" +
                "                            <thead>\n" +
                "                                <tr>\n" +
                "                                    <th>Nombre</th>\n" +
                "                                    <th>Apellido</th>\n" +
                "                                    <th>Fecha</th>\n" +
                "                                    <th><a class=\"btn-floating waves-effect waves-light\" href=\""+Add+"\">\n" +
                "                                        <i class=\"material-icons\">add</i>\n" +
                "                                    </a></th>\n" +
                "                                </tr>\n" +
                "                            </thead>";

        Resultado+=Inicio;

        for (String n:Generar_cuerpo()
             ) {
            Resultado+=n;
        }
        
        
        Resultado+="</table>";



        return Resultado;
    }


    private ArrayList<String> Generar_cuerpo()
    {



        ArrayList<String> Resultado= new ArrayList<>();
        Filtrar=Filtrar.replace(" ","");
        String Edit="/Profesor/Editar",Delete="/Profesor/PreEliminar";

        //inicio
        Resultado.add("  <tbody>");
        //cuerpo
        for (Profesor n:Aux
             ) {
            Resultado.add("<tr>\n" +
                    "                                <td>"+n.getNombre()+"</td>\n" +
                    "                                <td>"+n.getApellido()+"</td>\n" +
                    "                                <td>"+n.getF_creacion()+"</td>\n" +
                    "                                <td>\n" +
                    "                                    <a class=\"btn-floating  waves-effect waves-light \" href=\""+Edit+"/"+n.getId_profesor()+"\">\n" +
                    "                                        <i class=\"material-icons\">mode_edit</i>\n" +
                    "                                    </a>\n" +
                    "                                    <a class=\"btn-floating  waves-effect waves-light red\" href=\""+Delete+"/"+n.getId_profesor()+"\">\n" +
                    "                                        <i class=\"material-icons\">delete</i>\n" +
                    "                                    </a>\n" +
                    "                                </td>\n" +
                    "                            </tr>");

        }
        //fin
        Resultado.add("</tbody>");

        return  Resultado;
    }

    private String Generar_formulario()
    {
        formulario.setAccion("/Profesor/filtrar");
        formulario.setMetodo(Metodos.POST.mostrar());
        ArrayList<String> cuerpo_f= new ArrayList<>();
        cuerpo_f.add(" <div class=\"input-field col s6\">\n" +
                "                            <input id=\"buscar\" type=\"text\" class=\"validate\" name=\"txt_buscar\">\n" +
                "                            <label for=\"buscar\">Filtrar Nombre</label>\n" +
                "                        </div>\n" +
                "                        <div class=\"input-field col s6\">\n" +
                "                            <input type=\"submit\" value=\"Buscar\" class=\"waves-effect waves-light btn\">\n" +
                "                        </div>");

        formulario.setCuerpo_formulario(cuerpo_f);
        return  formulario.Generar_formulario();
    }
    
    public  String Generar_Admi_Profesor(){
        html.setTitulo("SDH");
        html.setScrip(Enviar_scrip());
        html.setEstilos(Enviar_Estilo());
        ArrayList<String > Cuerpo= new ArrayList<>();


        Cuerpo.add(Generar_navBar());
        Cuerpo.add("<div class=\"container\">\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"col s12 \">\n" +
                "\n" +
                "\n" +
                "                <div class=\"card-panel  \">\n" +
                "                    <h4>Administracion de Profesores</h4>");
        Cuerpo.add(Generar_formulario());
        Cuerpo.add(Generar_table());
        Cuerpo.add("</table>\n" +
                "\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>");
        Cuerpo.add(Footer.getFooter());
        html.setCuerpo(Cuerpo);
        
        return html.Generar_Html();
    }
        
        
        
    


}
