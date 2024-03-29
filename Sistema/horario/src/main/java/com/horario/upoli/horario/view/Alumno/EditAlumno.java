package com.horario.upoli.horario.view.Alumno;

import com.horario.upoli.horario.constante.MetodosK;
import com.horario.upoli.horario.model.AlumnoK;
import com.horario.upoli.horario.model.CarreraK;
import com.horario.upoli.horario.recursos.PermisoK;
import com.horario.upoli.horario.view.componentes.Editor;
import com.horario.upoli.horario.view.componentes.FormularioK;

import java.sql.Date;
import java.util.ArrayList;

public class EditAlumno extends Editor {
    private AlumnoK alumno= new AlumnoK();
    private ArrayList<CarreraK> carreras= new ArrayList<>();


    @Override
    public String Enviar_Formulario() {
        super.setScrip_m("<script>\n" +
                "        $(document).ready(function() {\n" +
                "            $('select').material_select();\n" +
                "\n" +
                "            // for HTML5 \"required\" attribute\n" +
                "            $(\"select[required]\").css({\n" +
                "                display: \"inline\",\n" +
                "position: \"absolute\",\n"+
                "                height: 0,\n" +
                "                padding: 0,\n" +
                "                width: 0\n" +
                "            });\n" +
                "        });\n" +
                "    </script>");

        /*----------------------------------------------*/
        PermisoK btm_verde= new PermisoK("","");
        PermisoK btm_rojo= new PermisoK("/Alumno","Cancelar");
        FormularioK formulario= new FormularioK();
        ArrayList<String> cuerpo= new ArrayList();
        String titulo= "";
        String check="";
        String check2="";
        String Disable="";
        if(super.isNuevo()){
            alumno.setNombre("");
            alumno.setApellido("");
            alumno.setCarnet("");
            java.util.Date  fecha = new java.util.Date();
            alumno.setF_creacion(new Date(fecha.getTime()));
            btm_verde= new PermisoK("/Alumno/Guardar/0","Guardar");
            titulo= "Agregar Alumno";

        }
        else {
            btm_verde= new PermisoK("/Alumno/Guardar/"+alumno.getId_alumno(),"Actualizar");
            titulo= "Editar Alumno";



        }
        //////////////////////////
        formulario.setAccion(btm_verde.getAccion());
        formulario.setMetodo(MetodosK.POST.getMostrar());
        cuerpo.add("<div class=\"card-content \">\n" +
                "                                <p class=\"card-title\">"+titulo+"</p>");
        cuerpo.add("<div class=\"input-field \">\n" +
                "                                <input id=\"txt_carnet\" type=\"text\" required=\"\" aria-required=\"true\" data-length=\"8\" value=\""+alumno.getCarnet()+"\" name=\"txt_carnet\" class=\"validate\" required=\"\" aria-required=\"true\">\n" +
                "                                <label for=\"txt_carnet\">Carnet:</label>\n" +
                "                            </div>");


        cuerpo.add("<div class=\"input-field \">\n" +
                "                                <input id=\"txt_nombre\" type=\"text\" required=\"\" aria-required=\"true\" data-length=\"25\" value=\""+alumno.getNombre()+"\" name=\"txt_nombre\" class=\"validate\" required=\"\" aria-required=\"true\">\n" +
                "                                <label for=\"txt_nombre\">Nombre:</label>\n" +
                "                            </div>");

        cuerpo.add("<div class=\"input-field \">\n" +
                "                                <input id=\"txt_apellido\" type=\"text\" required=\"\" aria-required=\"true\" data-length=\"70\" value=\""+alumno.getApellido()+"\" name=\"txt_apellido\" class=\"validate\" required=\"\" aria-required=\"true\">\n" +
                "                                <label for=\"txt_apellido\">Apellido:</label>\n" +
                "                            </div>");


        cuerpo.add(GenerarLista());





        cuerpo.add("</div>\n" +
                "                        <div class=\"card-action \">\n" +
                "                            <input type=\"submit\" class=\"waves-effect waves-light btn\" value=\""+btm_verde.getNombre()+"\">\n" +
                "                            <a class=\"waves-effect waves-light btn red\" href=\""+btm_rojo.getAccion()+"\">"+btm_rojo.getNombre()+"</a>\n" +
                "                        </div>");




        formulario.setCuerpo_formulario(cuerpo);
        return formulario.Generar_formulario();


    }

    public AlumnoK getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoK alumno) {
        this.alumno = alumno;
    }

    public ArrayList<CarreraK> getCarreras() {
        return carreras;
    }

    public void setCarreras(ArrayList<CarreraK> carreras) {
        this.carreras = carreras;
    }


    private String GenerarLista()
    {
        String resulatado="<div class=\"input-field  \">\n" +
                "                                <select required=\"\" aria-required=\"true\" name=\"dp_carrera\">";

        if(isNuevo())
        {
            resulatado+="<option value=\"\" disabled selected >Seleccione</option>";
            for (CarreraK n:carreras
                    ) {
                resulatado+="<option value=\""+n.getId_carrera()+"\" >"+n.getNombre()+"</option>";
            }
            resulatado+="</select>\n" +
                    "                                <label>Profesor por vincular:</label>\n" +
                    "                            </div>";
        }else {
            resulatado+="<option value=\"\" disabled  >Seleccione</option>";
            for (CarreraK n:carreras
                    ) {
                //if(n.getId_carrera().equals(alumno.getCarrera().getId_carrera()))
                if(n.getId_carrera()==alumno.getCarrera().getId_carrera())
                {
                    resulatado+="<option value=\""+n.getId_carrera()+"\" selected>"+n.getNombre()+"</option>";
                }
                else
                {
                    resulatado+="<option value=\""+n.getId_carrera()+"\" >"+n.getNombre()+"</option>";
                }


            }
            resulatado+="</select>\n" +
                    "                                <label>Profesor por vincular:</label>\n" +
                    "                            </div>";
        }

        return resulatado;
    }

}
