package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.constante.MensajeIcoK;
import com.horario.upoli.horario.model.AulaK;
import com.horario.upoli.horario.model.UsuarioK;
import com.horario.upoli.horario.recursos.PermisoK;
import com.horario.upoli.horario.service.AulaService;
import com.horario.upoli.horario.view.componentes.MensajeK;
import com.horario.upoli.horario.view.login.Login;
import com.horario.upoli.horario.view.aula.Admin_aula;
import com.horario.upoli.horario.view.aula.EditAula;
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
public class AulaController {
    @Autowired
    private AulaService aulaService;



    @RequestMapping(value = "/Aula",method = RequestMethod.GET)
    public  String IndexClase(HttpServletRequest req, HttpServletResponse res)
    {
        HttpSession session = req.getSession(true);
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);

        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }


        return  new Admin_aula(recupera,aulaService.listaAula()).Generar_Admi_Aula();
    }

    @RequestMapping(value = "/Aula/filtrar")
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

        return  new Admin_aula(recupera,aulaService.filtrarAula(filtro)).Generar_Admi_Aula();
    }

    @RequestMapping(value = "/Aula/PreEliminar/{id}")
    public  String PreEliminar(@PathVariable("id") Long id, HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        AulaK muestra= aulaService.BuscarUno(id);
        MensajeK Respuesta= new MensajeK();
        Respuesta.setCuerpo("¿Desea Eliminar esta Aula?");
        Respuesta.setBtn_cancelar(true);
        Respuesta.setBtn_rojo(new PermisoK("/Aula","Cancelar"));
        Respuesta.setBtn_verde(new PermisoK("/Aula/Eliminar/"+muestra.getId_aula(),"Eliminar"));
        Respuesta.setTipo(MensajeIcoK.Advertencia.getMostrar());
        return  Respuesta.Generar_Mensaje(recupera);

    }
    @RequestMapping(value = "/Aula/Eliminar/{id}")
    public  String Eliminar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        AulaK muestra= aulaService.BuscarUno(id);
        aulaService.EliminarAula(muestra.getId_aula());
        MensajeK Respuesta= new MensajeK();
        Respuesta.setCuerpo("Eliminacion  de aula exitosa");
        Respuesta.setBtn_cancelar(false);
        Respuesta.setBtn_verde(new PermisoK("/Aula","Regresar"));
        Respuesta.setTipo(MensajeIcoK.Bien.getMostrar());
        return  Respuesta.Generar_Mensaje(recupera);
    }



    @RequestMapping(value = "/Aula/Editar/{id}")
    public  String Editar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        EditAula nuevo = new EditAula();
        if (id==0){
            nuevo.setUsuario(recupera);
            nuevo.setNuevo(true);
            return nuevo.GenerarEditar();

        }

        AulaK muestra= aulaService.BuscarUno(id);
        nuevo.setUsuario(recupera);
        nuevo.setNuevo(false);
        nuevo.setAula(muestra);
        return nuevo.GenerarEditar();
    }

    @RequestMapping(value = "/Aula/Guardar/{id}")
    public  String Guardar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        AulaK muestra= new AulaK();
        if(id==0){
            java.util.Date  fecha = new java.util.Date();
            muestra.setF_creacion(new Date(fecha.getTime()));
            muestra.setId_aula(aulaService.Secuencia());
        }
        else {
            muestra= aulaService.BuscarUno(id);
        }
        muestra.setDesc_aula((String) req.getParameter("txt_nombre").replace(" ","").toUpperCase());
        String mant=(String) req.getParameter("check_mant");
        if (mant==null)
        {
            muestra.setInd_mant(false);
        }
        else {
            muestra.setInd_mant(true);
        }
/*==============================================================*/

        if (muestra.getDesc_aula().equals("")){
            MensajeK Respuesta= new MensajeK();
            Respuesta.setCuerpo("No puede registrar solo espacios en el campo descripcion.");
            Respuesta.setBtn_cancelar(true);
            Respuesta.setBtn_rojo(new PermisoK("/Aula","Cancelar"));
            Respuesta.setBtn_verde(new PermisoK("/Aula/Editar/"+id,"Reintentar"));
            Respuesta.setTipo(MensajeIcoK.Advertencia.getMostrar());
            return  Respuesta.Generar_Mensaje(recupera);
        }



        aulaService.GuardarAula(muestra);
        MensajeK Respuesta= new MensajeK();
        Respuesta.setCuerpo("Se guardaron los cambios exitosamente.");
        Respuesta.setBtn_cancelar(false);
        Respuesta.setBtn_verde(new PermisoK("/Aula","Regresar"));
        Respuesta.setTipo(MensajeIcoK.Bien.getMostrar());
        return  Respuesta.Generar_Mensaje(recupera);
    }
}
