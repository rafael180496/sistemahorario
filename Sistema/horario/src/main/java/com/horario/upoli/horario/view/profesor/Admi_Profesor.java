package com.horario.upoli.horario.view.profesor;

import com.horario.upoli.horario.constante.MetodosK;
import com.horario.upoli.horario.model.ProfesorK;
import com.horario.upoli.horario.model.UsuarioK;
import com.horario.upoli.horario.view.componentes.*;
import java.util.ArrayList;

public class Admi_Profesor extends Editor {

    private String Filtrar= "";
    private ArrayList<ProfesorK> Aux= new ArrayList<>();


   public  Admi_Profesor(UsuarioK usuario, ArrayList<ProfesorK> Aux)
   {
       super(usuario);
       this.Aux=Aux;
   }




    private String  Generar_table(){
        String Resultado ="";
        String Add="/Profesor/Editar/0";
        String Inicio=" <table class=\"highlight responsive-table  bordered centered\">\n" +
                "                            <thead>\n" +
                "                                <tr>\n" +
                "                                    <th>Cod.Reg</th>\n" +
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
        for (ProfesorK n:Aux
             ) {
            Resultado.add("<tr>\n" +
                    "                                <td>"+n.getId_profesor()+"</td>\n" +
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

    @Override
    public String Enviar_Formulario()
    {
        FormularioK formulario = new FormularioK();
        formulario.setAccion("/Profesor/filtrar");
        formulario.setMetodo(MetodosK.POST.getMostrar());
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


        Cuerpo.add(NavbarK.Companion.Generar_navBar(super.getUsuario(),"SDH"));
        Cuerpo.add("<div class=\"container\">\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"col s12  \">\n" +
                "\n" +
                "\n" +
                "                <div class=\"card-panel hoverable  grey lighten-4\">\n" +
                "                    <h4>Administracion de Profesores:</h4>");
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
