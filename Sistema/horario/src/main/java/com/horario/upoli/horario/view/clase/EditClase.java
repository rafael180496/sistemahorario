package com.horario.upoli.horario.view.clase;

import com.horario.upoli.horario.constante.Metodos;
import com.horario.upoli.horario.model.Clase;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.view.componentes.*;

import java.sql.Date;
import java.util.ArrayList;

public class EditClase  extends Editor{

    private Clase clase= new Clase();

    public EditClase(Usuario usuario, boolean nuevo) {
        super(usuario, nuevo);
    }

    public EditClase() {
        super();
    }

    public EditClase(boolean nuevo) {
        super(nuevo);
    }


    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    @Override
    public String Enviar_Formulario(){
        Permiso btm_verde= new Permiso("","");
        Permiso btm_rojo= new Permiso("/Clase","Cancelar");
        Formulario formulario= new Formulario();
        ArrayList<String> cuerpo= new ArrayList();
        String titulo= "";


        if(super.isNuevo()){
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
