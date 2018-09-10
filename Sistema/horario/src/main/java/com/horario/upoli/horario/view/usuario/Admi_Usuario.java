package com.horario.upoli.horario.view.usuario;

import com.horario.upoli.horario.constante.MetodosK;
import com.horario.upoli.horario.model.UsuarioK;
import com.horario.upoli.horario.view.componentes.Editor;
import com.horario.upoli.horario.view.componentes.FooterK;
import com.horario.upoli.horario.view.componentes.Formulario;


import java.util.ArrayList;

public class Admi_Usuario extends Editor {
    private String Filtrar= "";
    private ArrayList<UsuarioK> Aux= new ArrayList<>();


    public  Admi_Usuario(UsuarioK usuario,ArrayList<UsuarioK> Aux)
    {
        super(usuario);
        this.Aux=Aux;
    }




    private String  Generar_table(){
        String Resultado ="";
        String Add="/Usuario/Editar/0";
        String Inicio=" <table class=\"highlight responsive-table  bordered centered\">\n" +
                "                            <thead>\n" +
                "                                <tr>\n" +
                "                                    <th>Cod.Reg</th>\n" +
                "                                    <th>Usuario</th>\n" +
                "                                    <th>Profesor</th>\n" +
                "                                    <th>Correo</th>\n" +
                "                                    <th>Estado</th>\n" +
                "                                    <th>Tipo</th>\n" +
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
        String Edit="/Usuario/Editar",Delete="/Usuario/PreEliminar";

        //inicio
        Resultado.add("  <tbody>");
        //cuerpo
        for (UsuarioK n:Aux
                ) {
            String target="";
            if(n.getInd_rest())
            {
                target="<div class=\"chip red\">\n" +
                        "                                        <span class=\"white-text\">Recuperacion</span>\n" +
                        "                                    </div>";
            }
            else {
                target=" <div class=\"chip green\">\n" +
                        "                                        <span class=\"white-text\">Normal</span>\n" +
                        "                                    </div>";
            }
            String target2="";
            if(n.getInd_adm())
            {
                target2="<div class=\"chip green darken-3\">\n" +
                        "                                        <span class=\"white-text\">Administrador</span>\n" +
                        "                                    </div>";
            }
            else {
                target2=" <div class=\"chip green\">\n" +
                        "                                        <span class=\"white-text\">Normal</span>\n" +
                        "                                    </div>";
            }


            Resultado.add("<tr>\n" +
                    "                                <td>"+n.getId_usuario()+"</td>\n" +
                    "                                <td>"+n.getNom_usr()+"</td>\n" +
                    "                                <td>"+n.getProfesor().getNombre()+" "+n.getProfesor().getApellido()+"</td>\n" +
                    "                                <td>"+n.getCorreo()+"</td>\n" +
                    "                                <td>"+target+"</td>\n" +
                    "                                <td>"+target2+"</td>\n" +
                    "                                <td>"+n.getF_creacion()+"</td>\n" +
                    "                                <td>\n" +
                    "                                    <a class=\"btn-floating  waves-effect waves-light \" href=\""+Edit+"/"+n.getId_usuario()+"\">\n" +
                    "                                        <i class=\"material-icons\">mode_edit</i>\n" +
                    "                                    </a>\n" +
                    "                                    <a class=\"btn-floating  waves-effect waves-light red\" href=\""+Delete+"/"+n.getId_usuario()+"\">\n" +
                    "                                        <i class=\"material-icons\">delete</i>\n" +
                    "                                    </a>\n" +
                    "                                </td>\n" +
                    "                            </tr>");

        }
        //fin
        Resultado.add("</tbody>");

        return  Resultado;
    }

    @Override
    public String Enviar_Formulario()
    {
        Formulario formulario = new Formulario();
        formulario.setAccion("/Usuario/filtrar");
        formulario.setMetodo(MetodosK.POST.getMostrar());
        ArrayList<String> cuerpo_f= new ArrayList<>();
        cuerpo_f.add(" <div class=\"input-field col s6\">\n" +
                "                            <input id=\"buscar\" type=\"text\" class=\"validate\" name=\"txt_buscar\">\n" +
                "                            <label for=\"buscar\">Filtrar Usuario</label>\n" +
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
                "            <div class=\"col s12  \">\n" +
                "\n" +
                "\n" +
                "                <div class=\"card-panel hoverable  grey lighten-4\">\n" +
                "                    <h4>Administracion de Usuarios:</h4>");
        Cuerpo.add(Enviar_Formulario());
        Cuerpo.add(Generar_table());
        Cuerpo.add("</table>\n" +
                "\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>");
        Cuerpo.add(FooterK.Companion.getFooter());
        html.setCuerpo(Cuerpo);

        return html.Generar_Html();
    }


}
