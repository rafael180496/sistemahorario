package com.horario.upoli.horario.view.profesor;

import com.horario.upoli.horario.constante.MetodosK;
import com.horario.upoli.horario.model.ProfesorK;
import com.horario.upoli.horario.model.UsuarioK;
import com.horario.upoli.horario.recursos.PermisoK;
import com.horario.upoli.horario.view.componentes.*;

import java.sql.Date;
import java.util.ArrayList;

public class EditProfesor extends Editor {

    private ProfesorK profesor= new ProfesorK();




    public EditProfesor(UsuarioK usuario, boolean nuevo) {
        super(usuario, nuevo);
    }

    public EditProfesor() {
        super();
    }

    public EditProfesor(boolean nuevo) {
        super(nuevo);
    }

    public ProfesorK getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorK profesor) {
        this.profesor = profesor;
    }




    @Override
    public String Enviar_Formulario(){
        PermisoK btm_verde= new PermisoK("","");
        PermisoK btm_rojo= new PermisoK("/Profesor","Cancelar");
        FormularioK formulario= new FormularioK();
        ArrayList<String> cuerpo= new ArrayList();
        String titulo= "";


        if(super.isNuevo()){
            profesor.setApellido("");
            profesor.setNombre("");
            java.util.Date  fecha = new java.util.Date();
            profesor.setF_creacion(new Date(fecha.getTime()));
           btm_verde= new PermisoK("/Profesor/Guardar/0","Guardar");
           titulo= "Agregar Profesor";

        }
        else {
            btm_verde= new PermisoK("/Profesor/Guardar/"+profesor.getId_profesor(),"Actualizar");
            titulo= "Editar Profesor";
        }
        //////////////////////////
         formulario.setAccion(btm_verde.getAccion());
         formulario.setMetodo(MetodosK.POST.getMostrar());
         cuerpo.add("<div class=\"card-content \">\n" +
                 "                            <p class=\"card-title\">"+titulo+"</p>\n" +
                 "                           \n" +
                 "                            <div class=\"input-field \">\n" +
                 "                                <input id=\"txt_nombre\" type=\"text\"  data-length=\"50\" required=\"\" aria-required=\"true\"  value=\""+profesor.getNombre()+"\" name=\"txt_nombre\" class=\"validate\">\n" +
                 "                                <label for=\"txt_nombre\">Nombre:</label>\n" +
                 "                            </div>\n" +
                 "                            <div class=\"input-field \">\n" +
                 "                                <input id=\"txt_apellido\" type=\"text\" data-length=\"50\" required=\"\" aria-required=\"true\" value=\""+profesor.getApellido()+"\" name=\"txt_apellido\" class=\"validate\">\n" +
                 "                                <label for=\"txt_apellido\">Apellido:</label>\n" +
                 "                            </div>\n" +
                 "                        </div>\n" +
                 "                        <div class=\"card-action \">\n" +
                 "                                <input type=\"submit\" class=\"waves-effect waves-light btn\" value=\""+btm_verde.getNombre()+"\" >\n" +
                 "                                <a class=\"waves-effect waves-light btn red\" href=\""+btm_rojo.getAccion()+"\">"+btm_rojo.getNombre()+"</a>\n" +
                 "                        </div>");
            formulario.setCuerpo_formulario(cuerpo);
            return formulario.Generar_formulario();
     }


}
