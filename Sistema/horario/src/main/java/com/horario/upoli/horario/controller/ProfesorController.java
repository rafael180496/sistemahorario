package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.constante.MensajeIcoK;
import com.horario.upoli.horario.model.Profesor;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.service.ProfesorService;
import com.horario.upoli.horario.service.ValidacionService;
import com.horario.upoli.horario.view.profesor.Admi_Profesor;
import com.horario.upoli.horario.view.profesor.EditProfesor;
import com.horario.upoli.horario.view.login.Login;
import com.horario.upoli.horario.view.componentes.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

@RestController
public class ProfesorController {

    @Autowired
    private ProfesorService  profesorService;
    @Autowired
    private ValidacionService validacionService;


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
        Respuesta.setTipo(MensajeIcoK.Advertencia.getMostrar());
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
        if(validacionService.ValidarProfesor(muestra))
        {
            Mensaje Respuesta= new Mensaje();
            Respuesta.setCuerpo("No se puede eliminar el Profesor por que está vinculada con un grupo por favor desvincule la Profesor.");
            Respuesta.setBtn_cancelar(false);
            Respuesta.setBtn_verde(new Permiso("/Profesor","Regresar"));
            Respuesta.setTipo(MensajeIcoK.Bien.getMostrar());
            return  Respuesta.Generar_Mensaje(recupera);
        }
        profesorService.EliminarProfesor(muestra.getId_profesor());
        Mensaje Respuesta= new Mensaje();
        Respuesta.setCuerpo("Eliminacion  de profesor exitosa");
        Respuesta.setBtn_cancelar(false);
        Respuesta.setBtn_verde(new Permiso("/Profesor","Regresar"));
        Respuesta.setTipo(MensajeIcoK.Bien.getMostrar());
        return  Respuesta.Generar_Mensaje(recupera);
    }



    @RequestMapping(value = "/Profesor/Editar/{id}")
    public  String Editar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        EditProfesor  nuevo = new EditProfesor();
        if (id==0){
            nuevo.setUsuario(recupera);
            nuevo.setNuevo(true);
            return nuevo.GenerarEditar();

        }


        Profesor muestra= profesorService.BuscarUno(id);
        nuevo.setUsuario(recupera);
        nuevo.setNuevo(false);
        nuevo.setProfesor(muestra);
        return nuevo.GenerarEditar();
    }



    @RequestMapping(value = "/Profesor/Guardar/{id}")
    public  String Guardar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        Profesor muestra= new Profesor();
        if(id==0){
            java.util.Date  fecha = new java.util.Date();
            muestra.setF_creacion(new Date(fecha.getTime()));
            muestra.setId_profesor(profesorService.Secuencia());
        }
        else {
            muestra= profesorService.BuscarUno(id);
        }
        muestra.setNombre((String) req.getParameter("txt_nombre").replace(" ","").toUpperCase());
        muestra.setApellido((String) req.getParameter("txt_apellido").replace(" ","").toUpperCase());
        profesorService.GuardarProfesor(muestra);


        Mensaje Respuesta= new Mensaje();
        Respuesta.setCuerpo("Se guardaron los cambios exitosamente.");
        Respuesta.setBtn_cancelar(false);
        Respuesta.setBtn_verde(new Permiso("/Profesor","Regresar"));
        Respuesta.setTipo(MensajeIcoK.Bien.getMostrar());
        return  Respuesta.Generar_Mensaje(recupera);
    }

}
