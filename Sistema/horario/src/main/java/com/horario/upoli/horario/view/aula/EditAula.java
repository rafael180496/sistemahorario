package com.horario.upoli.horario.view.aula;

import com.horario.upoli.horario.constante.MetodosK;
import com.horario.upoli.horario.model.AulaK;
import com.horario.upoli.horario.recursos.PermisoK;
import com.horario.upoli.horario.view.componentes.Editor;
import com.horario.upoli.horario.view.componentes.FormularioK;

import java.sql.Date;
import java.util.ArrayList;

public class EditAula extends Editor {
    private AulaK aula  = new AulaK();

    @Override
    public String Enviar_Formulario() {
        PermisoK btm_verde= new PermisoK("","");
        PermisoK btm_rojo= new PermisoK("/Aula","Cancelar");
        FormularioK formulario= new FormularioK();
        ArrayList<String> cuerpo= new ArrayList();
        String titulo= "";
        String check="";

        if(super.isNuevo()){
            aula.setDesc_aula("");
            java.util.Date  fecha = new java.util.Date();
            aula.setF_creacion(new Date(fecha.getTime()));
            btm_verde= new PermisoK("/Aula/Guardar/0","Guardar");
            titulo= "Agregar Aula";
            check="";
        }
        else {
            btm_verde= new PermisoK("/Aula/Guardar/"+aula.getId_aula(),"Actualizar");
            titulo= "Editar Aula";
            if (aula.getInd_mant())
            {
                check="checked=\"true\"";
            }
            else
            {
                check="";
            }

        }
        //////////////////////////
        formulario.setAccion(btm_verde.getAccion());
        formulario.setMetodo(MetodosK.POST.getMostrar());
        cuerpo.add("<div class=\"card-content \">\n" +
                "                            <p class=\"card-title\">"+titulo+"</p>\n" +
                "                           \n" +
                "                            <div class=\"input-field \">\n" +
                "                                <input id=\"txt_nombre\" type=\"text\"  data-length=\"50\" required=\"\" aria-required=\"true\"  value=\""+aula.getDesc_aula()+"\" name=\"txt_nombre\" class=\"validate\">\n" +
                "                                <label for=\"txt_nombre\">Nombre o Codigo:</label>\n" +
                "                            </div>\n" +
                "<p>\n" +
                "                                <input class=\"check_aula\" type=\"checkbox\" id=\"check_mant\" "+check+" name=\"check_mant\" />\n" +
                "                                <label for=\"check_mant\">Mantenimiento</label>\n" +
                "                            </p>"+
                "                        </div>\n" +
                "                        <div class=\"card-action \">\n" +
                "                                <input type=\"submit\" class=\"waves-effect waves-light btn   grabar\" value=\""+btm_verde.getNombre()+"\" >\n" +
                "                                <a class=\"waves-effect waves-light btn red\" href=\""+btm_rojo.getAccion()+"\">"+btm_rojo.getNombre()+"</a>\n" +
                "                        </div>");
        formulario.setCuerpo_formulario(cuerpo);
        return formulario.Generar_formulario();
    }

    public AulaK getAula() {
        return aula;
    }

    public void setAula(AulaK aula) {
        this.aula = aula;
    }
}
