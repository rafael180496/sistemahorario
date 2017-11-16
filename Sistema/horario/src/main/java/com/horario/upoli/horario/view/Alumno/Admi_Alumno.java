package com.horario.upoli.horario.view.Alumno;

import com.horario.upoli.horario.constante.Metodos;
import com.horario.upoli.horario.model.Alumno;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.view.componentes.Editor;
import com.horario.upoli.horario.view.componentes.Footer;
import com.horario.upoli.horario.view.componentes.Formulario;

import java.util.ArrayList;

public class Admi_Alumno extends Editor{
    private String Filtrar= "";
    private ArrayList<Alumno> Aux= new ArrayList<>();


    public Admi_Alumno(Usuario usuario, ArrayList<Alumno> Aux)
    {
        super(usuario);
        this.Aux=Aux;
    }



    private String  Generar_table(){
        String Resultado ="";
        String Add="/Alumno/Editar/0";
        String Inicio=" <table class=\"highlight responsive-table  bordered centered\">\n" +
                "                            <thead>\n" +
                "                                <tr>\n" +
                "                                    <th>Carnet</th>\n" +
                "                                    <th>Nombre</th>\n" +
                "                                    <th>Apellido</th>\n" +
                "                                    <th>Carrera</th>\n" +
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
        String Edit="/Alumno/Editar",Delete="/Alumno/PreEliminar";

        //inicio
        Resultado.add("  <tbody>");
        //cuerpo
        for (Alumno n:Aux
                ) {
            String target="";
            target="<div class=\"chip green \">\n" +
                    "                                        <span class=\"white-text\">"+n.getCarrera().getNombre()+"</span>\n" +
                    "                                    </div>";


            Resultado.add("<tr>\n" +
                    "                                <td>"+n.getCarnet()+"</td>\n" +
                    "                                <td>"+n.getNombre()+"</td>\n" +
                    "                                <td>"+n.getApellido()+"</td>\n" +
                    "                                <td>"+target+"</td>\n" +
                    "                                <td>"+n.getF_creacion()+"</td>\n" +
                    "                                <td>\n" +
                    "                                    <a class=\"btn-floating  waves-effect waves-light \" href=\""+Edit+"/"+n.getId_alumno()+"\">\n" +
                    "                                        <i class=\"material-icons\">mode_edit</i>\n" +
                    "                                    </a>\n" +
                    "                                    <a class=\"btn-floating  waves-effect waves-light red\" href=\""+Delete+"/"+n.getId_alumno()+"\">\n" +
                    "                                        <i class=\"material-icons\">delete</i>\n" +
                    "                                    </a>\n" +
                    "                                </td>\n" +
                    "                            </tr>");

        }
        //fin
        Resultado.add("</tbody>");

        return  Resultado;
    }

    public  String Generar_Admi_Alumno(){
        html.setTitulo("SDH");
        html.setScrip(Enviar_scrip());
        html.setEstilos(Enviar_Estilo());
        ArrayList<String > Cuerpo= new ArrayList<>();


        Cuerpo.add(Generar_navBar());
        Cuerpo.add("<div class=\"container\">\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"col s12  \">\n" +
                "\n" +
                "\n" +
                "                <div class=\"card-panel hoverable  grey lighten-4\">\n" +
                "                    <h4>Administracion de Alumnos:</h4>");
        Cuerpo.add(Enviar_Formulario());
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


    @Override
    public String Enviar_Formulario() {
        Formulario formulario = new Formulario();
        formulario.setAccion("/Usuario/filtrar");
        formulario.setMetodo(Metodos.POST.mostrar());
        ArrayList<String> cuerpo_f= new ArrayList<>();
        cuerpo_f.add(" <div class=\"input-field col s6\">\n" +
                "                            <input id=\"buscar\" type=\"text\" class=\"validate\" name=\"txt_buscar\">\n" +
                "                            <label for=\"buscar\">Filtrar Alumno</label>\n" +
                "                        </div>\n" +
                "                        <div class=\"input-field col s6\">\n" +
                "                            <input type=\"submit\" value=\"Buscar\" class=\"waves-effect waves-light btn\">\n" +
                "                        </div>");

        formulario.setCuerpo_formulario(cuerpo_f);
        return  formulario.Generar_formulario();

    }
}