package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.service.*;
import com.horario.upoli.horario.view.Grupo.Admi_Grupo;
import com.horario.upoli.horario.view.Grupo.EditGrupo;
import com.horario.upoli.horario.view.login.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class GrupoController {

    @Autowired
    private ValidacionService validacionService;

    @Autowired
    private ClaseService claseService;
    @Autowired
    private ProfesorService profesorService;
    @Autowired
    private GrupoService grupoService;
    @Autowired
    private AlumnoService alumnoService;


    @RequestMapping(value = "/Grupo",method = RequestMethod.GET)
    public  String IndexGrupo(HttpServletRequest req, HttpServletResponse res)
    {
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);

        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }


        return  new Admi_Grupo(recupera,grupoService.listaGrupo()).Generar_Admi_Grupo();
    }


    @RequestMapping(value = "/Grupo/filtrar")
    public  String Filtrar(HttpServletRequest req, HttpServletResponse res)
    {
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        String filtro=req.getParameter("txt_buscar").toLowerCase();

        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
          return  new Admi_Grupo(recupera,grupoService.filtrarGrupo(filtro)).Generar_Admi_Grupo();
    }



    @RequestMapping(value = "/Grupo/Editar/{id}")
    public  String Editar(@PathVariable("id") Long id, HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        EditGrupo nuevo = new EditGrupo();
      //  if (id==0){
            nuevo.setUsuario(recupera);
            nuevo.setNuevo(true);
            nuevo.setCarreras(validacionService.CarrerasConAlumnos());
            nuevo.setAlumnos(alumnoService.listaAlumno());
            nuevo.setClases(claseService.listaClase());
            nuevo.setProfesors(profesorService.listaProfesores());
            return nuevo.GenerarEditar();
      //  }
/*
        Alumno muestra= alumnoService.BuscarUno(id);
        nuevo.setUsuario(recupera);
        nuevo.setNuevo(false);
        nuevo.setCarreras(carreraService.listaCarrera());
        nuevo.setAlumno(muestra);
        return nuevo.GenerarEditar();*/
    }


}
