package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.constante.MensajeIcoK;
import com.horario.upoli.horario.model.ProfesorK;
import com.horario.upoli.horario.model.UsuarioK;
import com.horario.upoli.horario.recursos.ClaveK;
import com.horario.upoli.horario.recursos.CorreoK;
import com.horario.upoli.horario.recursos.PermisoK;
import com.horario.upoli.horario.service.ProfesorService;
import com.horario.upoli.horario.service.UsuarioService;
import com.horario.upoli.horario.service.ValidacionService;
import com.horario.upoli.horario.view.componentes.MensajeK;
import com.horario.upoli.horario.view.login.Login;
import com.horario.upoli.horario.view.usuario.Admi_Usuario;
import com.horario.upoli.horario.view.usuario.EditUsuario;
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
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ValidacionService validacionService;
    @Autowired
    ProfesorService profesorService;

    @RequestMapping(value = "/Usuario",method = RequestMethod.GET)
    public  String IndexClase(HttpServletRequest req, HttpServletResponse res)
    {
        HttpSession session = req.getSession(true);
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);

        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }


        return  new Admi_Usuario(recupera,usuarioService.listaUsuarios()).Generar_Admi_Profesor();
    }


    @RequestMapping(value = "/Usuario/filtrar")
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

        return  new Admi_Usuario(recupera,usuarioService.filtrarUsuario(filtro)).Generar_Admi_Profesor();
    }


    @RequestMapping(value = "/Usuario/Editar/{id}")
    public  String Editar(@PathVariable("id") Long id, HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        EditUsuario nuevo = new EditUsuario();
        if (id==0){
            nuevo.setUsuario(recupera);
            nuevo.setNuevo(true);
            nuevo.setProfesores(validacionService.ProfesoresSinUsuario());
            return nuevo.GenerarEditar();
        }

        UsuarioK muestra= usuarioService.getUsuarioById(id);
        nuevo.setUsuario(recupera);
        nuevo.setNuevo(false);
        nuevo.setProfesores(validacionService.ProfesoresSinUsuario());
        nuevo.setUsuario2(muestra);
        return nuevo.GenerarEditar();
    }



    @RequestMapping(value = "/Usuario/Guardar/{id}")
    public  String Guardar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        UsuarioK muestra= new UsuarioK();
        if(id==0){
            muestra.setNom_usr((String) req.getParameter("txt_nombre").replace(" ",""));
            muestra.setCorreo((String) req.getParameter("txt_correo").replace(" ",""));
            String admin=(String) req.getParameter("check_admin");
            if (admin==null)
            {
                muestra.setInd_adm(false);
            }
            else {
                muestra.setInd_adm(true);
            }
            muestra.setInd_rest(true);
            muestra.setId_usuario(usuarioService.Secuencia());
            java.util.Date  fecha = new java.util.Date();
            muestra.setF_creacion(new Date(fecha.getTime()));
            Long idp=Long.parseLong((String)req.getParameter("dp_profesor"));
            ProfesorK profesor =profesorService.BuscarUno(idp);
            muestra.setProfesor(profesor);
            String rec= ClaveK.Companion.getClave(ClaveK.Companion.getMINUSCULAS()+
                    ClaveK.Companion.getMAYUSCULAS()+
                    ClaveK.Companion.getESPECIALES(),10);
            rec=rec.replace(" ","");
            muestra.setClave(rec);
            CorreoK Enviar= new CorreoK();
            Enviar.setAsunto("Recuperación de contraseña ");
            Enviar.setPara(muestra.getCorreo());
            Enviar.setMensage("Esta clave es de recuperación cuando la introduzca debe de cambiar la contraseña:"+muestra.getClave());
            Enviar.SendMail();
        }
        else {
            muestra=usuarioService.getUsuarioById(id);
            muestra.setNom_usr((String) req.getParameter("txt_nombre").replace(" ",""));
            muestra.setCorreo((String) req.getParameter("txt_correo").replace(" ",""));
            String admin=(String) req.getParameter("check_admin");
            if (admin==null)
            {
                muestra.setInd_adm(false);
            }
            else {
                muestra.setInd_adm(true);
            }
            String rest=(String) req.getParameter("check_rest");
            if (rest==null)
            {
                if (!muestra.getInd_rest()){
                    muestra.setInd_rest(false);
                }

            }
            else {
                muestra.setInd_rest(true);
                String rec= ClaveK.Companion.getClave(ClaveK.Companion.getMINUSCULAS()+
                        ClaveK.Companion.getMAYUSCULAS()+
                        ClaveK.Companion.getESPECIALES(),10);
                rec=rec.replace(" ","");
                muestra.setClave(rec);
                CorreoK Enviar= new CorreoK();
                Enviar.setAsunto("Recuperación de contraseña ");
                Enviar.setPara(muestra.getCorreo());
                Enviar.setMensage("Esta clave es de recuperación cuando la introduzca debe de cambiar la contraseña:"+muestra.getClave());
                Enviar.SendMail();
            }
            Long idp=Long.parseLong((String)req.getParameter("dp_profesor"));
            ProfesorK profesor =profesorService.BuscarUno(idp);
            muestra.setProfesor(profesor);

        }

        usuarioService.GuardarUsuario(muestra);


        MensajeK Respuesta= new MensajeK();
        Respuesta.setCuerpo("Se guardaron los cambios exitosamente.");
        Respuesta.setBtn_cancelar(false);
        Respuesta.setBtn_verde(new PermisoK("/Usuario","Regresar"));
        Respuesta.setTipo(MensajeIcoK.Bien.getMostrar());
        return  Respuesta.Generar_Mensaje(recupera);
    }
    @RequestMapping(value = "/Usuario/PreEliminar/{id}")
    public  String PreEliminar(@PathVariable("id") Long id, HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        UsuarioK muestra= usuarioService.getUsuarioById(id);
        MensajeK Respuesta= new MensajeK();
        Respuesta.setCuerpo("¿Desea Eliminar esta Usuario?");
        Respuesta.setBtn_cancelar(true);
        Respuesta.setBtn_rojo(new PermisoK("/Usuario","Cancelar"));
        Respuesta.setBtn_verde(new PermisoK("/Usuario/Eliminar/"+muestra.getId_usuario(),"Eliminar"));
        Respuesta.setTipo(MensajeIcoK.Advertencia.getMostrar());
        return  Respuesta.Generar_Mensaje(recupera);

    }

    @RequestMapping(value = "/Usuario/Eliminar/{id}")
    public  String Eliminar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        UsuarioK recupera = (UsuarioK) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        UsuarioK muestra= usuarioService.getUsuarioById(id);
        if(recupera.getId_usuario()==muestra.getId_usuario())
        {
            MensajeK Respuesta= new MensajeK();
            Respuesta.setCuerpo("No puedes eliminar el mismo usuario que estas iniciado.");
            Respuesta.setBtn_cancelar(false);
            Respuesta.setBtn_verde(new PermisoK("/Usuario","Regresar"));
            Respuesta.setTipo(MensajeIcoK.Error.getMostrar());
            return  Respuesta.Generar_Mensaje(recupera);
        }


        usuarioService.EliminarUsuario(muestra.getId_usuario());
        MensajeK Respuesta= new MensajeK();
        Respuesta.setCuerpo("Eliminacion  de Usuario exitosa");
        Respuesta.setBtn_cancelar(false);
        Respuesta.setBtn_verde(new PermisoK("/Usuario","Regresar"));
        Respuesta.setTipo(MensajeIcoK.Bien.getMostrar());
        return  Respuesta.Generar_Mensaje(recupera);
    }
}
