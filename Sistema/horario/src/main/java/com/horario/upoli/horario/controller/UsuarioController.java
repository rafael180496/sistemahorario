package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.service.UsuarioService;
import com.horario.upoli.horario.service.ValidacionService;
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


@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ValidacionService validacionService;

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

}
