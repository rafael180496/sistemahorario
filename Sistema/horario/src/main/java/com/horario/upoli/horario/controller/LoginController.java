package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.service.UsuarioService;
import com.horario.upoli.horario.view.Home;
import com.horario.upoli.horario.view.login.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    String Inicio(HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",null);
        Login nuevo = new Login();
        return nuevo.Generar_login(false);
    }

    @RequestMapping(value = "/inicio",method = RequestMethod.GET)
    String Index(HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario recupera =(Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",recupera);

        if(recupera==null)
        {
            return  new Login().Generar_login(false);
        }

            return  new Home(recupera).Generar_Home();



    }

    @RequestMapping(value = "/login/ingresar",method = RequestMethod.POST)
    String  Ingresar(HttpServletRequest req, HttpServletResponse res)
    {
        String usuario=req.getParameter("txt_usuario");
        String clave=req.getParameter("txt_clave");
        Usuario recupera=usuarioService.Ingresar(usuario,clave);

        if(recupera==null)
        {

            return  new Login().Generar_login(true);
        }

            HttpSession session = req.getSession(true);
            session.setAttribute("usuario",recupera);

            return  new Home(recupera).Generar_Home();


    }




}
