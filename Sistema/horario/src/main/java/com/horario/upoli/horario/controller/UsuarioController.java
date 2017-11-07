package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.model.Profesor;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.recursos.Clave;
import com.horario.upoli.horario.recursos.Correo;
import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.service.ProfesorService;
import com.horario.upoli.horario.service.UsuarioService;
import com.horario.upoli.horario.service.ValidacionService;
import com.horario.upoli.horario.view.componentes.Mensaje;
import com.horario.upoli.horario.view.constante.MensajeIco;
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
    UsuarioService usuarioService;
    @Autowired
    ValidacionService validacionService;
    @Autowired
    ProfesorService profesorService;

    @RequestMapping(value = "/Usuario",method = RequestMethod.GET)
    public  String IndexClase(HttpServletRequest req, HttpServletResponse res)
    {
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
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
        Usuario recupera = (Usuario) session.getAttribute("usuario");
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
        Usuario recupera = (Usuario) session.getAttribute("usuario");
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

        Usuario muestra= usuarioService.getUsuarioById(id);
        nuevo.setUsuario(recupera);
        nuevo.setNuevo(false);
        nuevo.setProfesores(validacionService.ProfesoresSinUsuario());
        nuevo.setUsuario2(muestra);
        return nuevo.GenerarEditar();
    }



    @RequestMapping(value = "/Usuario/Guardar/{id}")
    public  String Guardar(@PathVariable("id") Long id,HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);
        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }
        Usuario muestra= new Usuario();
        if(id==0){
            muestra.setNom_usr((String) req.getParameter("txt_nombre"));
            muestra.setCorreo((String) req.getParameter("txt_correo"));
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
            Profesor profesor =profesorService.BuscarUno(idp);
            muestra.setProfesor(profesor);
            String rec= Clave.getClave(Clave.MINUSCULAS+
                    Clave.MAYUSCULAS+
                    Clave.ESPECIALES,10);
            rec=rec.replace(" ","");
            muestra.setClave(rec);
            Correo Enviar= new Correo();
            Enviar.setAsunto("Recuperación de contraseña ");
            Enviar.setPara(muestra.getCorreo());
            Enviar.setMensage("Esta clave es de recuperación cuando la introduzca debe de cambiar la contraseña:"+muestra.getClave());
            Enviar.SendMail();
        }
        else {
            muestra=usuarioService.getUsuarioById(id);
            muestra.setNom_usr((String) req.getParameter("txt_nombre"));
            muestra.setCorreo((String) req.getParameter("txt_correo"));
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
                String rec= Clave.getClave(Clave.MINUSCULAS+
                        Clave.MAYUSCULAS+
                        Clave.ESPECIALES,10);
                rec=rec.replace(" ","");
                muestra.setClave(rec);
                Correo Enviar= new Correo();
                Enviar.setAsunto("Recuperación de contraseña ");
                Enviar.setPara(muestra.getCorreo());
                Enviar.setMensage("Esta clave es de recuperación cuando la introduzca debe de cambiar la contraseña:"+muestra.getClave());
                Enviar.SendMail();
            }
            Long idp=Long.parseLong((String)req.getParameter("dp_profesor"));
            Profesor profesor =profesorService.BuscarUno(idp);
            muestra.setProfesor(profesor);

        }

        usuarioService.GuardarUsuario(muestra);


        Mensaje Respuesta= new Mensaje();
        Respuesta.setCuerpo("Se guardaron los cambios exitosamente.");
        Respuesta.setBtn_cancelar(false);
        Respuesta.setBtn_verde(new Permiso("/Usuario","Regresar"));
        Respuesta.setTipo(MensajeIco.Bien.mostrar());
        return  Respuesta.Generar_Mensaje(recupera);
    }

}
