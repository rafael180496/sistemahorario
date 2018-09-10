package com.horario.upoli.horario.view.carrera;

import com.horario.upoli.horario.constante.MetodosK;
import com.horario.upoli.horario.model.CarreraK;
import com.horario.upoli.horario.model.UsuarioK;
import com.horario.upoli.horario.recursos.PermisoK;
import com.horario.upoli.horario.view.componentes.*;

import java.sql.Date;
import java.util.ArrayList;

public class EditCarrera  extends Editor{
private CarreraK carrera = new CarreraK();

    @Override
    public String Enviar_Formulario() {
        PermisoK btm_verde= new PermisoK("","");
        PermisoK btm_rojo= new PermisoK("/Carrera","Cancelar");
        FormularioK formulario= new FormularioK();
        ArrayList<String> cuerpo= new ArrayList();
        String titulo= "";


        if(super.isNuevo()){
            carrera.setNombre("");
            java.util.Date  fecha = new java.util.Date();
            carrera.setF_creacion(new Date(fecha.getTime()));
            btm_verde= new PermisoK("/Carrera/Guardar/0","Guardar");
            titulo= "Agregar Carrera";

        }
        else {
            btm_verde= new PermisoK("/Carrera/Guardar/"+carrera.getId_carrera(),"Actualizar");
            titulo= "Editar Carrera";
        }
        //////////////////////////
        formulario.setAccion(btm_verde.getAccion());
        formulario.setMetodo(MetodosK.POST.getMostrar());
        cuerpo.add("<div class=\"card-content \">\n" +
                "                            <p class=\"card-title\">"+titulo+"</p>\n" +
                "                           \n" +
                "                            <div class=\"input-field \">\n" +
                "                                <input id=\"txt_nombre\" type=\"text\"  data-length=\"50\" required=\"\" aria-required=\"true\"  value=\""+carrera.getNombre()+"\" name=\"txt_nombre\" class=\"validate\">\n" +
                "                                <label for=\"txt_nombre\">Nombre:</label>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"card-action \">\n" +
                "                                <input type=\"submit\" class=\"waves-effect waves-light btn  grabar\" value=\""+btm_verde.getNombre()+"\" >\n" +
                "                                <a class=\"waves-effect waves-light btn red\" href=\""+btm_rojo.getAccion()+"\">"+btm_rojo.getNombre()+"</a>\n" +
                "                        </div>");
        formulario.setCuerpo_formulario(cuerpo);
        return formulario.Generar_formulario();
    }

    public EditCarrera(UsuarioK usuario, boolean nuevo) {
        super(usuario, nuevo);
    }

    public EditCarrera(boolean nuevo) {
        super(nuevo);
    }

    public EditCarrera() {
    }

    public CarreraK getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraK carrera) {
        this.carrera = carrera;
    }
}
