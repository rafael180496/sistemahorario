package com.horario.upoli.horario.view.aula;

import com.horario.upoli.horario.constante.Metodos;
import com.horario.upoli.horario.model.Aula;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.view.componentes.Editor;
import com.horario.upoli.horario.view.componentes.Footer;
import com.horario.upoli.horario.view.componentes.Formulario;


import java.util.ArrayList;

public class Admin_aula extends Editor {
    private String Filtrar= "";
    private ArrayList<Aula> Aux= new ArrayList<>();

    public  Admin_aula(Usuario usuario, ArrayList<Aula> Aux)
    {
        super(usuario);
        this.Aux=Aux;
    }


    private String  Generar_table(){
        String Resultado ="";
        String Add="/Aula/Editar/0";
        String Inicio=" <table class=\"highlight responsive-table  bordered centered\">\n" +
                "                            <thead>\n" +
                "                                <tr>\n" +
                "                                    <th>Cod.Reg</th>\n" +
                "                                    <th>Nombre</th>\n" +
                "                                    <th>Estado</th>\n" +
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
        String Edit="/Aula/Editar",Delete="/Aula/PreEliminar";

        //inicio
        Resultado.add("  <tbody>");
        //cuerpo
        for (Aula n:Aux
                ) {
            String target="";
            if(n.isInd_mant())
            {
                target="<div class=\"chip red\">\n" +
                        "                                        <span class=\"white-text\">Matenimiento</span>\n" +
                        "                                    </div>";
            }
            else {
                target=" <div class=\"chip green\">\n" +
                        "                                        <span class=\"white-text\">Normal</span>\n" +
                        "                                    </div>";
            }

            Resultado.add("<tr>\n" +
                    "                                <td>"+n.getId_aula()+"</td>\n" +
                    "                                <td>"+n.getDesc_aula()+"</td>\n" +
                    "                                <td>"+target+"</td>\n" +
                    "                                <td>"+n.getF_creacion()+"</td>\n" +
                    "                                <td>\n" +
                    "                                    <a class=\"btn-floating  waves-effect waves-light "+"edit"+n.getId_aula()+" \" href=\""+Edit+"/"+n.getId_aula()+"\">\n" +
                    "                                        <i class=\"material-icons\">mode_edit</i>\n" +
                    "                                    </a>\n" +
                    "                                    <a class=\"btn-floating  waves-effect waves-light red "+"delete"+n.getId_aula()+" \" href=\""+Delete+"/"+n.getId_aula()+"\">\n" +
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
        formulario.setAccion("/Aula/filtrar");
        formulario.setMetodo(Metodos.POST.mostrar());
        ArrayList<String> cuerpo_f= new ArrayList<>();
        cuerpo_f.add(" <div class=\"input-field col s6\">\n" +
                "                            <input id=\"buscar\" type=\"text\" class=\"validate\" name=\"txt_buscar\">\n" +
                "                            <label for=\"buscar\">Filtrar Aula</label>\n" +
                "                        </div>\n" +
                "                        <div class=\"input-field col s6\">\n" +
                "                            <input type=\"submit\" value=\"Buscar\" class=\"waves-effect waves-light btn\">\n" +
                "                        </div>");

        formulario.setCuerpo_formulario(cuerpo_f);
        return  formulario.Generar_formulario();
    }

    public  String Generar_Admi_Aula(){
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
                "                <div class=\"card-panel  hoverable  grey lighten-4\">\n" +
                "                    <h4>Administracion de Aulas:</h4>");
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



}
