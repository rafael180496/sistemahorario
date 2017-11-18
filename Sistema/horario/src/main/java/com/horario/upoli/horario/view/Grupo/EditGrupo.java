package com.horario.upoli.horario.view.Grupo;

import com.horario.upoli.horario.constante.Metodos;
import com.horario.upoli.horario.model.*;
import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.view.componentes.Editor;
import com.horario.upoli.horario.view.componentes.Formulario;

import java.sql.Date;
import java.util.ArrayList;

public class EditGrupo extends Editor {
    private Grupo grupo= new Grupo();
    private ArrayList<Clase> clases= new ArrayList<>();
    private ArrayList<Profesor> profesors= new ArrayList<>();
    private ArrayList<Alumno> alumnos= new ArrayList<>();
    private ArrayList<Carrera> carreras= new ArrayList<>();
    private ArrayList<Det_grupo> det_grupos= new ArrayList<>();

    @Override
    public String Enviar_Formulario() {
        /*  super.setScrip_m("<script>\n" +
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
                "    </script>");*/


        super.setScrip_m("<script>\n" +
                "        \n" +
                "                            $(document).ready(function() {\n" +
                "                                $('select').material_select();\n" +
                "                \n" +
                "                                // for HTML5 required attribute\n" +
                "                                $(select[required]).css({\n" +
                "                                    display: inline,\n" +
                "                                    position: absolute,\n" +
                "                                    height: 0,\n" +
                "                                    padding: 0,\n" +
                "                                    width: 0\n" +
                "                                });\n" +
                "        \n" +
                "                            $(\"#f_grupos\").submit(function() {\n" +
                "        \n" +
                "                                $(\"#dp_grupos option\").each(function(){\n" +
                "                                    if ($(this).val() == \"\" ){        \n" +
                "                                        return false;\n" +
                "                                    }\n" +
                "                                });\n" +
                "                            \n" +
                "                            });\n" +
                "                            });\n" +
                "        </script>");
        /*----------------------------------------------*/
        Permiso btm_verde= new Permiso("","");
        Permiso btm_rojo= new Permiso("#","Cancelar");
        Formulario formulario= new Formulario();
        formulario.setId_f("f_grupos");
        ArrayList<String> cuerpo= new ArrayList();

        String titulo= "";
        String check="";
        String check2="";
        String Disable="";
        if(super.isNuevo()){
            grupo.setNombre("");
            java.util.Date  fecha = new java.util.Date();
            grupo.setF_creacion(new Date(fecha.getTime()));
            btm_verde= new Permiso("#/0","Guardar");
            titulo= "Agregar Grupo";

        }
        else {
            btm_verde= new Permiso("#/"+grupo.getId_grupo(),"Actualizar");
            titulo= "Editar Grupo";



        }
        //////////////////////////
        formulario.setAccion(btm_verde.getAccion());
        formulario.setMetodo(Metodos.POST.mostrar());
        cuerpo.add("<div class=\"card-content \">\n" +
                "                                <p class=\"card-title\">"+titulo+"</p>");
        cuerpo.add("<div class=\"input-field \">\n" +
                "                                <input id=\"txt_nombre\" type=\"text\" required=\"\" aria-required=\"true\" data-length=\"8\" value=\""+grupo.getNombre()+"\" name=\"txt_nombre\" class=\"validate\" required=\"\" aria-required=\"true\">\n" +
                "                                <label for=\"txt_nombre\">Nombre del grupo:</label>\n" +
                "                            </div>");

        cuerpo.add(GenerarListaProfesor());
        cuerpo.add(GenerarListaClase());
        cuerpo.add(GenerarListaAgrupada());

        cuerpo.add("</div>\n" +
                "                        <div class=\"card-action \">\n" +
                "                            <input type=\"submit\" class=\"waves-effect waves-light btn  btn_guardar\" value=\""+btm_verde.getNombre()+"\">\n" +
                "                            <a class=\"waves-effect waves-light btn red\" href=\""+btm_rojo.getAccion()+"\">"+btm_rojo.getNombre()+"</a>\n" +
                "                        </div>");




        formulario.setCuerpo_formulario(cuerpo);
        return formulario.Generar_formulario();
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public ArrayList<Clase> getClases() {
        return clases;
    }

    public void setClases(ArrayList<Clase> clases) {
        this.clases = clases;
    }

    public ArrayList<Profesor> getProfesors() {
        return profesors;
    }

    public void setProfesors(ArrayList<Profesor> profesors) {
        this.profesors = profesors;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }

    public ArrayList<Det_grupo> getDet_grupos() {
        return det_grupos;
    }

    public void setDet_grupos(ArrayList<Det_grupo> det_grupos) {
        this.det_grupos = det_grupos;
    }

    private String GenerarListaClase()
    {
        String resulatado="<div class=\"input-field  \">\n" +
                "                                <select required=\"\" aria-required=\"true\"  name=\"dp_clase\">";

        if(isNuevo())
        {
            resulatado+="<option value=\"\" disabled selected >Seleccione</option>";
            for (Clase n:clases
                    ) {
                resulatado+="<option value=\""+n.getId_clase()+"\" >"+n.getNombre()+"</option>";
            }
            resulatado+="</select>\n" +
                    "                                <label>Clase por vincular:</label>\n" +
                    "                            </div>";
        }else {
            resulatado+="<option value=\"\" disabled  >Seleccione</option>";
            for (Clase n:clases
                    ) {
                if(n.getId_clase().equals(grupo.getClase().getId_clase()))
                {
                    resulatado+="<option value=\""+n.getId_clase()+"\" selected>"+n.getNombre()+"</option>";
                }
                else
                {
                    resulatado+="<option value=\""+n.getId_clase()+"\" >"+n.getNombre()+"</option>";
                }


            }
            resulatado+="</select>\n" +
                    "                                <label>Clase por vincular:</label>\n" +
                    "                            </div>";
        }

        return resulatado;
    }



    private String GenerarListaProfesor()
    {
        String resulatado="<div class=\"input-field  \">\n" +
                "                                <select required=\"\" aria-required=\"true\" name=\"dp_profesor\">";

        if(isNuevo())
        {
            resulatado+="<option value=\"\" disabled selected >Seleccione</option>";
            for (Profesor n:profesors
                    ) {
                resulatado+="<option value=\""+n.getId_profesor()+"\" >"+n.getNombre()+"</option>";
            }
            resulatado+="</select>\n" +
                    "                                <label>Profesor por vincular:</label>\n" +
                    "                            </div>";
        }else {
            resulatado+="<option value=\"\" disabled  >Seleccione</option>";
            for (Profesor n:profesors
                    ) {
                if(n.getId_profesor().equals(grupo.getProfesor().getId_profesor()))
                {
                    resulatado+="<option value=\""+n.getId_profesor()+"\" selected>"+n.getNombre()+"</option>";
                }
                else
                {
                    resulatado+="<option value=\""+n.getId_profesor()+"\" >"+n.getNombre()+"</option>";
                }


            }
            resulatado+="</select>\n" +
                    "                                <label>Profesor por vincular:</label>\n" +
                    "                            </div>";
        }

        return resulatado;
    }


    private String GenerarListaAgrupada()
    {
        String resulatado="<div class=\"input-field  \">\n" +
                "                                <select  required=\"\" aria-required=\"true\" name=\"dp_grupos\" id=\"dp_grupos\" multiple>";

        if(isNuevo())
        {

            resulatado+="<optgroup label=\"Defecto\">\n" +
                    "                                        <option value=\"\"  selected disabled>Seleccionar</option>\n" +
                    "                                  </optgroup>";


            for (Carrera n:carreras
                 ) {
                resulatado+="<optgroup label=\""+n.getNombre()+"\">";
                for (Alumno j:alumnos
                     ) {
                    if(n.getId_carrera()==j.getCarrera().getId_carrera())
                    {
                        resulatado+=" <option value=\""+j.getId_alumno()+"\">"+j.getNombre()+" "+j.getApellido()+"</option>";
                    }
                }
                resulatado+=" </optgroup>";

            }
            resulatado+="</select>\n" +
                    "                                <label>Alumnos del grupo:</label>\n" +
                    "                            </div>";
        }else {

            resulatado+="<optgroup label=\"Defecto\">\n" +
                    "                                        <option value=\"\" disabled >Seleccionar</option>\n" +
                    "                                  </optgroup>";


            for (Carrera n:carreras
                    ) {
                resulatado+="<optgroup label=\""+n.getNombre()+"\">";
                for (Alumno j:alumnos
                        ) {
                    if(n.getId_carrera()==j.getCarrera().getId_carrera())
                    {
                        boolean seleccion = false;
                        for (Det_grupo g:det_grupos
                             ) {
                            if(g.getAlumno().getId_alumno()==j.getId_alumno())
                            {
                                seleccion=true;
                            }
                        }

                        if (seleccion)
                        {
                            resulatado+=" <option value=\""+j.getId_alumno()+"\" selected>"+j.getNombre()+" "+j.getApellido()+"</option>";
                        }
                        else
                        {

                            resulatado+=" <option value=\""+j.getId_alumno()+"\" >"+j.getNombre()+" "+j.getApellido()+"</option>";
                        }

                    }
                }
                resulatado+=" </optgroup>";

            }
            resulatado+="</select>\n" +
                    "                                <label>Alumnos del grupo:</label>\n" +
                    "                            </div>";
        }

        return resulatado;
    }
}