package com.horario.upoli.horario.controller;


import com.horario.upoli.horario.constante.MensajeIco;
import com.horario.upoli.horario.model.Alumno;
import com.horario.upoli.horario.model.Carrera;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.service.AlumnoService;
import com.horario.upoli.horario.service.CarreraService;
import com.horario.upoli.horario.service.ValidacionService;
import com.horario.upoli.horario.view.Alumno.Admi_Alumno;
import com.horario.upoli.horario.view.Alumno.EditAlumno;
import com.horario.upoli.horario.view.componentes.Mensaje;
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

@RestController
public class AlumnoController {
    @Autowired
    private ValidacionService validacionService;

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private  CarreraService carreraService;


    @RequestMapping(value = "/Alumno",method = RequestMethod.GET)
    public  String IndexAlumno(HttpServletRequest req, HttpServletResponse res)
    {
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);

        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }


        return  new Admi_Alumno(recupera,alumnoService.listaAlumno()).Generar_Admi_Alumno();
    }
    @RequestMapping(value = "/Alumno/filtrar")
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
        return  new Admi_Alumno(recupera,alumnoService.filtrarAlumno(filtro)).Generar_Admi_Alumno();
    }

    @RequestMapping(value = "/Alumno/Editar/{id}")
    public  String Editar(@PathVariable("id") Long id, HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        EditAlumno nuevo = new EditAlumno();
        if (id==0){
            nuevo.setUsuario(recupera);
            nuevo.setNuevo(true);
            nuevo.setCarreras(carreraService.listaCarrera());
            return nuevo.GenerarEditar();
        }

        Alumno muestra= alumnoService.BuscarUno(id);
        nuevo.setUsuario(recupera);
        nuevo.setNuevo(false);
        nuevo.setCarreras(carreraService.listaCarrera());
        nuevo.setAlumno(muestra);
        return nuevo.GenerarEditar();
    }


    @RequestMapping(value = "/Alumno/PreEliminar/{id}")
    public  String PreEliminar(@PathVariable("id") Long id, HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        Alumno muestra= alumnoService.BuscarUno(id);
        Mensaje Respuesta= new Mensaje();
        Respuesta.setCuerpo("¿Desea Eliminar esta Alumno?");
        Respuesta.setBtn_cancelar(true);
        Respuesta.setBtn_rojo(new Permiso("/Alumno","Cancelar"));
        Respuesta.setBtn_verde(new Permiso("/Alumno/Eliminar/"+muestra.getId_alumno(),"Eliminar"));
        Respuesta.setTipo(MensajeIco.Advertencia.mostrar());
        return  Respuesta.Generar_Mensaje(recupera);

    }

    @RequestMapping(value = "/Alumno/Eliminar/{id}")
    public  String Eliminar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        Alumno muestra= alumnoService.BuscarUno(id);
        alumnoService.EliminarAlumno(muestra.getId_alumno());
        Mensaje Respuesta= new Mensaje();
        Respuesta.setCuerpo("Eliminacion  de Alumno exitosa");
        Respuesta.setBtn_cancelar(false);
        Respuesta.setBtn_verde(new Permiso("/Alumno","Regresar"));
        Respuesta.setTipo(MensajeIco.Bien.mostrar());
        return  Respuesta.Generar_Mensaje(recupera);
    }

    @RequestMapping(value = "/Alumno/Guardar/{id}")
    public  String Guardar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        Alumno muestra= new Alumno();
        if(id==0){
            muestra.setCarnet((String) req.getParameter("txt_carnet").replace(" ","").toUpperCase());
            muestra.setNombre((String) req.getParameter("txt_nombre").replace(" ","").toUpperCase());
            muestra.setApellido((String) req.getParameter("txt_apellido").replace(" ","").toUpperCase());
            muestra.setId_alumno(alumnoService.Secuencia());
            java.util.Date  fecha = new java.util.Date();
            muestra.setF_creacion(new Date(fecha.getTime()));
            Long idc=Long.parseLong((String)req.getParameter("dp_carrera"));

            Carrera carrera =carreraService.BuscarUno(idc);
            muestra.setCarrera(carrera);

        }
        else {
            muestra=alumnoService.BuscarUno(id);
            muestra.setCarnet((String) req.getParameter("txt_carnet").replace(" ","").toUpperCase());
            muestra.setNombre((String) req.getParameter("txt_nombre").replace(" ","").toUpperCase());
            muestra.setApellido((String) req.getParameter("txt_apellido").replace(" ","").toUpperCase());

            String rest=(String) req.getParameter("check_rest");

            Long idc=Long.parseLong((String)req.getParameter("dp_carrera"));
            Carrera carrera =carreraService.BuscarUno(idc);
            muestra.setCarrera(carrera);

        }

        if((validacionService.CarnetRepetido(muestra.getCarnet(),id) ))
        {
            Mensaje Respuesta= new Mensaje();
            Respuesta.setCuerpo("El numero de carnet no puede ser repetido.");
            Respuesta.setBtn_cancelar(true);
            Respuesta.setBtn_rojo(new Permiso("/Alumno","Regresar"));
            Respuesta.setBtn_verde(new Permiso("/Alumno/Editar/"+id,"Reintentar"));
            Respuesta.setTipo(MensajeIco.Error.mostrar());
            return  Respuesta.Generar_Mensaje(recupera);
        }else
        {
            alumnoService.GuardarAlumno(muestra);
            Mensaje Respuesta= new Mensaje();
            Respuesta.setCuerpo("Se guardaron los cambios exitosamente.");
            Respuesta.setBtn_cancelar(false);
            Respuesta.setBtn_verde(new Permiso("/Alumno","Regresar"));
            Respuesta.setTipo(MensajeIco.Bien.mostrar());
            return  Respuesta.Generar_Mensaje(recupera);
        }


    }


}
