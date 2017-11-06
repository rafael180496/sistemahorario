package com.horario.upoli.horario.view.usuario;

import com.horario.upoli.horario.model.Profesor;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.view.componentes.Editor;
import com.horario.upoli.horario.view.componentes.Formulario;
import com.horario.upoli.horario.view.constante.Metodos;

import java.sql.Date;
import java.util.ArrayList;

public class EditUsuario extends Editor {
    private Usuario usuario2= new Usuario();
    private ArrayList<Profesor> profesores= new ArrayList<>();

    @Override
    public String Enviar_Formulario() {
        super.setScrip_m("<script>\n" +
                "        $(document).ready(function() {\n" +
                "            $('select').material_select();\n" +
                "\n" +
                "            // for HTML5 \"required\" attribute\n" +
                "            $(\"select[required]\").css({\n" +
                "                display: \"inline\",\n" +
                "                height: 0,\n" +
                "                padding: 0,\n" +
                "                width: 0\n" +
                "            });\n" +
                "        });\n" +
                "    </script>");

        /*----------------------------------------------*/
        Permiso btm_verde= new Permiso("","");
        Permiso btm_rojo= new Permiso("/Usuario","Cancelar");
        Formulario formulario= new Formulario();
        ArrayList<String> cuerpo= new ArrayList();
        String titulo= "";
        String check="";
        String check2="";
        if(super.isNuevo()){
            usuario2.setNom_usr("");
            usuario2.setCorreo("");
            java.util.Date  fecha = new java.util.Date();
            usuario2.setF_creacion(new Date(fecha.getTime()));
            btm_verde= new Permiso("/Usuario/Guardar/0","Guardar");
            titulo= "Agregar Usuario";
            check="";
            check2="";
        }
        else {
            btm_verde= new Permiso("/Usuario/Guardar/"+usuario2.getId_usuario(),"Actualizar");
            titulo= "Editar Usuario";
            if (usuario2.getInd_adm())
            {
                check="checked";
            }
            else
            {
                check="";
            }
            if (usuario2.getInd_rest())
            {
                check2="checked";
            }
            else {
                check2="";
            }

        }
        //////////////////////////
        formulario.setAccion(btm_verde.getAccion());
        formulario.setMetodo(Metodos.POST.mostrar());
        cuerpo.add("<div class=\"card-content \">\n" +
                "                                <p class=\"card-title\">"+titulo+"</p>");

        cuerpo.add("<div class=\"input-field \">\n" +
                "                                <input id=\"txt_nombre\" type=\"text\" required=\"\" aria-required=\"true\" data-length=\"25\" value=\""+usuario2.getNom_usr()+"\" name=\"txt_nombre\" class=\"validate\" required=\"\" aria-required=\"true\">\n" +
                "                                <label for=\"txt_nombre\">Nombre de usuario:</label>\n" +
                "                            </div>");

        cuerpo.add("<div class=\"input-field \">\n" +
                "                                <input id=\"txt_correo\" type=\"email\" required=\"\" aria-required=\"true\" data-length=\"70\" value=\""+usuario2.getCorreo()+"\" name=\"txt_correo\" class=\"validate\" required=\"\" aria-required=\"true\">\n" +
                "                                <label for=\"txt_correo\">Correo:</label>\n" +
                "                            </div>");


        cuerpo.add(GenerarLista());

        cuerpo.add("<br>\n" +
                "                            <p>\n" +
                "                                <input type=\"checkbox\" id=\"check_admin\" "+check+" name=\"check_admin\" />\n" +
                "                                <label for=\"check_admin\">Administrador</label>\n" +
                "                            </p>");

        if (!isNuevo())
        {
            cuerpo.add("<br>\n" +
                    "                            <p>\n" +
                    "                                <input type=\"checkbox\" id=\"check_rest\" "+check2+" name=\"check_rest\" />\n" +
                    "                                <label for=\"check_rest\">Restablecer</label>\n" +
                    "                            </p>");
        }



        cuerpo.add("</div>\n" +
                "                        <div class=\"card-action \">\n" +
                "                            <input type=\"submit\" class=\"waves-effect waves-light btn\" value=\""+btm_verde.getNombre()+"\">\n" +
                "                            <a class=\"waves-effect waves-light btn red\" href=\""+btm_rojo.getAccion()+"\">"+btm_rojo.getNombre()+"</a>\n" +
                "                        </div>");




        formulario.setCuerpo_formulario(cuerpo);
        return formulario.Generar_formulario();
    }


    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    private String GenerarLista()
    {
        String resulatado="<div class=\"input-field  \">\n" +
                "                                <select required=\"\" aria-required=\"true\" name=\"dp_profesor\">";

        if(isNuevo())
        {
            resulatado+="<option value=\"\" disabled selected >Seleccione</option>";
            for (Profesor n:profesores
                 ) {
                resulatado+="<option value=\""+n.getId_profesor()+"\" >"+n.getNombre()+" "+n.getApellido()+"</option>";
            }
            resulatado+="</select>\n" +
                    "                                <label>Profesor por vincular:</label>\n" +
                    "                            </div>";
        }else {
            resulatado+="<option value=\"\" disabled  >Seleccione</option>";
            for (Profesor n:profesores
                    ) {
                if(n.getId_profesor().equals(usuario2.getProfesor().getId_profesor()))
                {
                    resulatado+="<option value=\""+n.getId_profesor()+"\" selected>"+n.getNombre()+" "+n.getApellido()+"</option>";
                }
                else
                {
                    resulatado+="<option value=\""+n.getId_profesor()+"\" >"+n.getNombre()+" "+n.getApellido()+"</option>";
                }


            }
            resulatado+="</select>\n" +
                    "                                <label>Profesor por vincular:</label>\n" +
                    "                            </div>";
            }

            return resulatado;
    }


}
