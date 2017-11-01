package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.model.Profesor;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.service.ProfesorService;
import com.horario.upoli.horario.view.Admi_Profesor;
import com.horario.upoli.horario.view.Login;
import com.horario.upoli.horario.view.componentes.Mensaje;
import com.horario.upoli.horario.view.constante.MensajeIco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RestController
public class ProfesorController {

    @Autowired
    private ProfesorService  profesorService;



    @RequestMapping(value = "/Profesor",method = RequestMethod.GET)
    public  String Index(HttpServletRequest req, HttpServletResponse res)
    {
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);

        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }


        return  new Admi_Profesor(recupera,profesorService.listaProfesores()).Generar_Admi_Profesor();
    }

    @RequestMapping(value = "/Profesor/filtrar")
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

        return  new Admi_Profesor(recupera,profesorService.filtrarProfesores(filtro)).Generar_Admi_Profesor();
    }
    @RequestMapping(value = "/Profesor/PreEliminar/{id}")
    public  String PreEliminar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        Profesor muestra= profesorService.BuscarUno(id);
        Mensaje Respuesta= new Mensaje();
        Respuesta.setCuerpo("¿Desea Eliminar el profesor?");
        Respuesta.setBtn_cancelar(true);
        Respuesta.setBtn_rojo(new Permiso("/Profesor","Cancelar"));
        Respuesta.setBtn_verde(new Permiso("/Profesor/Eliminar/"+muestra.getId_profesor(),"Eliminar"));
        Respuesta.setTipo(MensajeIco.Advertencia.mostrar());
        return  Respuesta.Generar_Mensaje(recupera);

    }
    @RequestMapping(value = "/Profesor/Eliminar/{id}")
    public  String Eliminar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        Profesor muestra= profesorService.BuscarUno(id);
        profesorService.EliminarProfesor(muestra.getId_profesor());
        Mensaje Respuesta= new Mensaje();
        Respuesta.setCuerpo("Eliminacion  de profesor exitosa");
        Respuesta.setBtn_cancelar(false);
        Respuesta.setBtn_verde(new Permiso("/Profesor","Regresar"));
        Respuesta.setTipo(MensajeIco.Bien.mostrar());
        return  Respuesta.Generar_Mensaje(recupera);
    }


}
