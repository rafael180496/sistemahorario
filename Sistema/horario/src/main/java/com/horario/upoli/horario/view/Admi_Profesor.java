package com.horario.upoli.horario.view;

import com.horario.upoli.horario.model.Profesor;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.service.ProfesorService;
import com.horario.upoli.horario.view.componentes.Formulario;
import com.horario.upoli.horario.view.componentes.Html;
import com.horario.upoli.horario.view.componentes.Navbar;
import com.horario.upoli.horario.view.constante.Estilos;
import com.horario.upoli.horario.view.constante.Scrips;
import com.horario.upoli.horario.view.seguridad.Permisos;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class Admi_Profesor  {
    private Html html = new Html();
    private Navbar navbar= new Navbar("SDH");
    private Usuario usuario= new Usuario();
    private Formulario  formulario= new Formulario();
    private String Filtrar= "";

    @Autowired
    private ProfesorService profesorService;


    public Admi_Profesor(Usuario usuario) {
        this.usuario = usuario;
    }

    private ArrayList<String> Enviar_scrip(){
        ArrayList <String> escr= new ArrayList<>();
        escr.add(Scrips.jquery.mostrar());
        escr.add(Scrips.materialize.mostrar());

        return escr;
    }

    private ArrayList <String> Enviar_Estilo(){
        ArrayList <String> est= new ArrayList<>();
        est.add(Estilos.Material_Icons.mostrar());
        est.add(Estilos.materialize.mostrar());

        return  est;
    }


    private  String Generar_navBar()
    {

        if (usuario.getInd_adm())
        {
            for (Permiso n: Permisos.PermisosAdmin()
                    ) {
                navbar.Agregar_propiedad(n.getNombre(),n.getAccion());
            }
        }
        else
        {
            for (Permiso n: Permisos.PermisosProfesor()
                    ) {
                navbar.Agregar_propiedad(n.getNombre(),n.getAccion());
            }
        }


        return navbar.Generar_Navbar();
    }


    private String  Generar_table(){
        String Resultado ="";
        String Inicio=" <table class=\"highlight responsive-table  bordered centered\">\n" +
                "                            <thead>\n" +
                "                                <tr>\n" +
                "                                    <th>Nombre</th>\n" +
                "                                    <th>Apellido</th>\n" +
                "                                    <th>Fecha</th>\n" +
                "                                    <th><a class=\"btn-floating waves-effect waves-light\" href=\"#\">\n" +
                "                                        <i class=\"material-icons\">add</i>\n" +
                "                                    </a></th>\n" +
                "                                </tr>\n" +
                "                            </thead>";




        return "";
    }






}
