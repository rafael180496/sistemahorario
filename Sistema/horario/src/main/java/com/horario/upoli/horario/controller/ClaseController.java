package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.constante.MensajeIcoK;
import com.horario.upoli.horario.model.Clase;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.service.ClaseService;
import com.horario.upoli.horario.service.ValidacionService;
import com.horario.upoli.horario.view.login.Login;
import com.horario.upoli.horario.view.clase.Admin_clase;
import com.horario.upoli.horario.view.clase.EditClase;
import com.horario.upoli.horario.view.componentes.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

@RestController
public class ClaseController {


    @Autowired
    private  ClaseService claseService;

    @Autowired
    private ValidacionService validacionService;

    @RequestMapping(value = "/Clase",method = RequestMethod.GET)
    public  String IndexClase(HttpServletRequest req, HttpServletResponse res)
    {
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);

        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }


        return  new Admin_clase(recupera,claseService.listaClase()).Generar_Admi_Clase();
    }

    @RequestMapping(value = "/Clase/filtrar")
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

        return  new Admin_clase(recupera,claseService.filtrarClase(filtro)).Generar_Admi_Clase();
    }

    @RequestMapping(value = "/Clase/PreEliminar/{id}")
    public  String PreEliminar(@PathVariable("id") Long id, HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        Clase muestra= claseService.BuscarUno(id);
        Mensaje Respuesta= new Mensaje();
        Respuesta.setCuerpo("¿Desea Eliminar esta Clase?");
        Respuesta.setBtn_cancelar(true);
        Respuesta.setBtn_rojo(new Permiso("/Clase","Cancelar"));
        Respuesta.setBtn_verde(new Permiso("/Clase/Eliminar/"+muestra.getId_clase(),"Eliminar"));
        Respuesta.setTipo(MensajeIcoK.Advertencia.getMostrar());
        return  Respuesta.Generar_Mensaje(recupera);

    }
    @RequestMapping(value = "/Clase/Eliminar/{id}")
    public  String Eliminar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        Clase muestra= claseService.BuscarUno(id);

        if(validacionService.ValidarClase(muestra))
        {
            Mensaje Respuesta= new Mensaje();
            Respuesta.setCuerpo("No se puede eliminar la Clase por que está vinculada con un grupo por favor desvincule la clase.");
            Respuesta.setBtn_cancelar(false);
            Respuesta.setBtn_verde(new Permiso("/Clase","Regresar"));
            Respuesta.setTipo(MensajeIcoK.Bien.getMostrar());
            return  Respuesta.Generar_Mensaje(recupera);
        }

        claseService.EliminarClase(muestra.getId_clase());
        Mensaje Respuesta= new Mensaje();
        Respuesta.setCuerpo("Eliminacion  de clase exitosa");
        Respuesta.setBtn_cancelar(false);
        Respuesta.setBtn_verde(new Permiso("/Clase","Regresar"));
        Respuesta.setTipo(MensajeIcoK.Bien.getMostrar());
        return  Respuesta.Generar_Mensaje(recupera);
    }



    @RequestMapping(value = "/Clase/Editar/{id}")
    public  String Editar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        EditClase nuevo = new EditClase();
        if (id==0){
            nuevo.setUsuario(recupera);
            nuevo.setNuevo(true);
            return nuevo.GenerarEditar();

        }


        Clase muestra= claseService.BuscarUno(id);
        nuevo.setUsuario(recupera);
        nuevo.setNuevo(false);
        nuevo.setClase(muestra);
        return nuevo.GenerarEditar();
    }

    @RequestMapping(value = "/Clase/Guardar/{id}")
    public  String Guardar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        Clase muestra= new Clase();
        if(id==0){
            java.util.Date  fecha = new java.util.Date();
            muestra.setF_creacion(new Date(fecha.getTime()));
            muestra.setId_clase(claseService.Secuencia());
        }
        else {
            muestra= claseService.BuscarUno(id);
        }

        muestra.setNombre((String) req.getParameter("txt_nombre").replace(" ","").toUpperCase());
        claseService.GuardarClase(muestra);

        Mensaje Respuesta= new Mensaje();
        Respuesta.setCuerpo("Se guardaron los cambios exitosamente.");
        Respuesta.setBtn_cancelar(false);
        Respuesta.setBtn_verde(new Permiso("/Clase","Regresar"));
        Respuesta.setTipo(MensajeIcoK.Bien.getMostrar());
        return  Respuesta.Generar_Mensaje(recupera);
    }
}
