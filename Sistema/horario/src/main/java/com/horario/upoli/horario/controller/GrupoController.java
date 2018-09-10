package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.constante.MensajeIcoK;
import com.horario.upoli.horario.model.Det_grupoK;
import com.horario.upoli.horario.model.GrupoK;
import com.horario.upoli.horario.model.UsuarioK;
import com.horario.upoli.horario.recursos.PermisoK;
import com.horario.upoli.horario.service.*;
import com.horario.upoli.horario.view.Grupo.Admi_Grupo;
import com.horario.upoli.horario.view.Grupo.EditGrupo;
import com.horario.upoli.horario.view.componentes.MensajeK;
import com.horario.upoli.horario.view.login.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;

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
    @Autowired
    private Det_grupoService det_grupoService;

    @RequestMapping(value = "/Grupo",method = RequestMethod.GET)
    public  String IndexGrupo(HttpServletRequest req, HttpServletResponse res)
    {
        HttpSession session = req.getSession(true);
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
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
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
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
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        EditGrupo nuevo = new EditGrupo();
        if (id==0){
            nuevo.setNuevo(true);
        }else
        {
            nuevo.setGrupo(grupoService.BuscarUno(id));
            nuevo.setNuevo(false);
            nuevo.setDet_grupos(validacionService.DetalleFiltrado(grupoService.BuscarUno(id)));
        }

        nuevo.setUsuario(recupera);
        nuevo.setCarreras(validacionService.CarrerasConAlumnos());
        nuevo.setAlumnos(alumnoService.listaAlumno());
        nuevo.setClases(claseService.listaClase());
        nuevo.setProfesors(profesorService.listaProfesores());
        return nuevo.GenerarEditar();
    }




    @RequestMapping(value = "/Grupo/Guardar/{id}")
    public  String Guardar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        GrupoK nuevo = new GrupoK();
        ArrayList<Det_grupoK> nuevo2= new ArrayList<>();
        if(id==0){
            nuevo.setId_grupo(grupoService.Secuencia());
            java.util.Date  fecha = new java.util.Date();
            nuevo.setF_creacion(new Date(fecha.getTime()));
        }else {
            nuevo= grupoService.BuscarUno(id);
            nuevo2=validacionService.DetalleFiltrado(nuevo);
        }
        nuevo.setNombre(req.getParameter("txt_nombre").replace(" ","").toUpperCase());
        nuevo.setClase(claseService.BuscarUno(Long.parseLong(req.getParameter("dp_clase"))));
        nuevo.setProfesor(profesorService.BuscarUno(Long.parseLong(req.getParameter("dp_profesor"))));

        try {
            grupoService.GuardarGrupo(nuevo);
            if(id!=0){
                for (Det_grupoK n:validacionService.DetalleFiltrado(nuevo)
                     ) {
                        det_grupoService.EliminarDet_grupo(n.getId_det_grupo());
                    }
            }

            for (String n:req.getParameterValues("dp_grupos")
                    ) {
                Det_grupoK aux= new Det_grupoK();
                java.util.Date  fecha = new java.util.Date();
                aux.setF_creacion(new Date(fecha.getTime()));
                aux.setGrupo(nuevo);
                aux.setId_det_grupo(det_grupoService.Secuencia());
                aux.setAlumno(alumnoService.BuscarUno(Long.parseLong(n)));
                det_grupoService.GuardarDet_grupo(aux);
            }


        }
        catch (Exception m){

        }



        MensajeK Respuesta= new MensajeK();
        Respuesta.setCuerpo("Se guardaron los cambios exitosamente.");
        Respuesta.setBtn_cancelar(false);
        Respuesta.setBtn_verde(new PermisoK("/Grupo","Regresar"));
        Respuesta.setTipo(MensajeIcoK.Bien.getMostrar());
        return  Respuesta.Generar_Mensaje(recupera);
    }


    @RequestMapping(value = "/Grupo/PreEliminar/{id}")
    public  String PreEliminar(@PathVariable("id") Long id, HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        GrupoK muestra= grupoService.BuscarUno(id);
        MensajeK Respuesta= new MensajeK();
        Respuesta.setCuerpo("¿Desea Eliminar este Grupo?");
        Respuesta.setBtn_cancelar(true);
        Respuesta.setBtn_rojo(new PermisoK("/Grupo","Cancelar"));
        Respuesta.setBtn_verde(new PermisoK("/Grupo/Eliminar/"+muestra.getId_grupo(),"Eliminar"));
        Respuesta.setTipo(MensajeIcoK.Advertencia.getMostrar());
        return  Respuesta.Generar_Mensaje(recupera);

    }

    @RequestMapping(value = "/Grupo/Eliminar/{id}")
    public  String Eliminar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        GrupoK muestra= grupoService.BuscarUno(id);



        for (Det_grupoK n:validacionService.DetalleFiltrado(muestra)
                ) {
            det_grupoService.EliminarDet_grupo(n.getId_det_grupo());
        }

        grupoService.EliminarGrupo(muestra.getId_grupo());

        MensajeK Respuesta= new MensajeK();
        Respuesta.setCuerpo("Eliminacion  de Grupo exitosa");
        Respuesta.setBtn_cancelar(false);
        Respuesta.setBtn_verde(new PermisoK("/Grupo","Regresar"));
        Respuesta.setTipo(MensajeIcoK.Bien.getMostrar());
        return  Respuesta.Generar_Mensaje(recupera);
    }



}
