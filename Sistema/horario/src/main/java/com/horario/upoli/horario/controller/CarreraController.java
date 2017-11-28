package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.constante.MensajeIco;
import com.horario.upoli.horario.model.Carrera;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.service.CarreraService;
import com.horario.upoli.horario.service.ValidacionService;
import com.horario.upoli.horario.view.login.Login;
import com.horario.upoli.horario.view.carrera.Admin_carrera;
import com.horario.upoli.horario.view.carrera.EditCarrera;
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
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @Autowired
    private ValidacionService validacionService;


    @RequestMapping(value = "/Carrera",method = RequestMethod.GET)
    public  String IndexClase(HttpServletRequest req, HttpServletResponse res)
    {
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);

        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }


        return  new Admin_carrera(recupera,carreraService.listaCarrera()).Generar_Admi_Carrera();
    }

    @RequestMapping(value = "/Carrera/filtrar")
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

        return  new Admin_carrera(recupera,carreraService.filtrarCarrera(filtro)).Generar_Admi_Carrera();
    }

    @RequestMapping(value = "/Carrera/PreEliminar/{id}")
    public  String PreEliminar(@PathVariable("id") Long id, HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        Carrera muestra= carreraService.BuscarUno(id);
        Mensaje Respuesta= new Mensaje();
        Respuesta.setCuerpo("¿Desea Eliminar esta Carrera?");
        Respuesta.setBtn_cancelar(true);
        Respuesta.setBtn_rojo(new Permiso("/Carrera","Cancelar"));
        Respuesta.setBtn_verde(new Permiso("/Carrera/Eliminar/"+muestra.getId_carrera(),"Eliminar"));
        Respuesta.setTipo(MensajeIco.Advertencia.mostrar());
        return  Respuesta.Generar_Mensaje(recupera);

    }
    @RequestMapping(value = "/Carrera/Eliminar/{id}")
    public  String Eliminar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        Carrera muestra= carreraService.BuscarUno(id);

        if(validacionService.ValidarCarrera(muestra))
        {
            Mensaje Respuesta= new Mensaje();
            Respuesta.setCuerpo("No se puede eliminar la carrera por que está vinculada con un alumno por favor desvincule la carrera.");
            Respuesta.setBtn_cancelar(false);
            Respuesta.setBtn_verde(new Permiso("/Carrera","Regresar"));
            Respuesta.setTipo(MensajeIco.Advertencia.mostrar());
            return  Respuesta.Generar_Mensaje(recupera);
        }

        carreraService.EliminarCarrera(muestra.getId_carrera());
        Mensaje Respuesta= new Mensaje();
        Respuesta.setCuerpo("Eliminacion  de carrera exitosa");
        Respuesta.setBtn_cancelar(false);
        Respuesta.setBtn_verde(new Permiso("/Carrera","Regresar"));
        Respuesta.setTipo(MensajeIco.Bien.mostrar());
        return  Respuesta.Generar_Mensaje(recupera);
    }



    @RequestMapping(value = "/Carrera/Editar/{id}")
    public  String Editar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        EditCarrera nuevo = new EditCarrera();
        if (id==0){
            nuevo.setUsuario(recupera);
            nuevo.setNuevo(true);
            return nuevo.GenerarEditar();

        }


        Carrera muestra= carreraService.BuscarUno(id);
        nuevo.setUsuario(recupera);
        nuevo.setNuevo(false);
        nuevo.setCarrera(muestra);
        return nuevo.GenerarEditar();
    }

    @RequestMapping(value = "/Carrera/Guardar/{id}")
    public  String Guardar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        Carrera muestra= new Carrera();
        if(id==0){
            java.util.Date  fecha = new java.util.Date();
            muestra.setF_creacion(new Date(fecha.getTime()));
            muestra.setId_carrera(carreraService.Secuencia());
        }
        else {
            muestra= carreraService.BuscarUno(id);
        }
        muestra.setNombre((String) req.getParameter("txt_nombre").replace(" ","").toUpperCase());
        if (muestra.getNombre().equals("")){
            Mensaje Respuesta= new Mensaje();
            Respuesta.setCuerpo("No puede registrar solo espacios en el campo nombre.");
            Respuesta.setBtn_cancelar(true);
            Respuesta.setBtn_rojo(new Permiso("/Carrera","Cancelar"));
            Respuesta.setBtn_verde(new Permiso("/Carrera/Editar/"+id,"Reintentar"));
            Respuesta.setTipo(MensajeIco.Advertencia.mostrar());
            return  Respuesta.Generar_Mensaje(recupera);
        }

        carreraService.GuardarCarrera(muestra);


        Mensaje Respuesta= new Mensaje();
        Respuesta.setCuerpo("Se guardaron los cambios exitosamente.");
        Respuesta.setBtn_cancelar(false);
        Respuesta.setBtn_verde(new Permiso("/Carrera","Regresar"));
        Respuesta.setTipo(MensajeIco.Bien.mostrar());
        return  Respuesta.Generar_Mensaje(recupera);
    }
}
