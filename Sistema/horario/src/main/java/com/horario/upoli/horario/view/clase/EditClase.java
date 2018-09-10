package com.horario.upoli.horario.view.clase;

import com.horario.upoli.horario.constante.MetodosK;
import com.horario.upoli.horario.model.ClaseK;
import com.horario.upoli.horario.model.UsuarioK;
import com.horario.upoli.horario.recursos.PermisoK;
import com.horario.upoli.horario.view.componentes.*;

import java.sql.Date;
import java.util.ArrayList;

public class EditClase  extends Editor{

    private ClaseK clase= new ClaseK();

    public EditClase(UsuarioK usuario, boolean nuevo) {
        super(usuario, nuevo);
    }

    public EditClase() {
        super();
    }

    public EditClase(boolean nuevo) {
        super(nuevo);
    }


    public ClaseK getClase() {
        return clase;
    }

    public void setClase(ClaseK clase) {
        this.clase = clase;
    }

    @Override
    public String Enviar_Formulario(){
        PermisoK btm_verde= new PermisoK("","");
        PermisoK btm_rojo= new PermisoK("/Clase","Cancelar");
        Formulario formulario= new Formulario();
        ArrayList<String> cuerpo= new ArrayList();
        String titulo= "";


        if(super.isNuevo()){
            clase.setNombre("");
            java.util.Date  fecha = new java.util.Date();
            clase.setF_creacion(new Date(fecha.getTime()));
            btm_verde= new PermisoK("/Clase/Guardar/0","Guardar");
            titulo= "Agregar Clase";

        }
        else {
            btm_verde= new PermisoK("/Clase/Guardar/"+clase.getId_clase(),"Actualizar");
            titulo= "Editar Clase";
        }
        //////////////////////////
        formulario.setAccion(btm_verde.getAccion());
        formulario.setMetodo(MetodosK.POST.getMostrar());
        cuerpo.add("<div class=\"card-content \">\n" +
                "                            <p class=\"card-title\">"+titulo+"</p>\n" +
                "                           \n" +
                "                            <div class=\"input-field \">\n" +
                "                                <input id=\"txt_nombre\" type=\"text\"  data-length=\"50\" required=\"\" aria-required=\"true\"  value=\""+clase.getNombre()+"\" name=\"txt_nombre\" class=\"validate\">\n" +
                "                                <label for=\"txt_nombre\">Nombre:</label>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"card-action \">\n" +
                "                                <input type=\"submit\" class=\"waves-effect waves-light btn grabar \" value=\"  "+btm_verde.getNombre()+"\" >\n" +
                "                                <a class=\"waves-effect waves-light btn red\" href=\""+btm_rojo.getAccion()+"\">"+btm_rojo.getNombre()+"</a>\n" +
                "                        </div>");
        formulario.setCuerpo_formulario(cuerpo);
        return formulario.Generar_formulario();
    }

}
