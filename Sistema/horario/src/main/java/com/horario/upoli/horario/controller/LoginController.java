package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.service.UsuarioService;
import com.horario.upoli.horario.view.Home;
import com.horario.upoli.horario.view.Login;
import com.horario.upoli.horario.view.componentes.Usuario_Env;
import com.sun.org.apache.regexp.internal.RE;
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
    String Mostrar(HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession(true);
        Usuario prueba = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",null);
        Login nuevo = new Login();
        return nuevo.Generar_login(false);
    }


    @RequestMapping(value = "/login/ingresar",method = RequestMethod.POST)
    String  Ingresar(HttpServletRequest req, HttpServletResponse res)
    {
        String usuario=req.getParameter("txt_usuario");
        String clave=req.getParameter("txt_clave");
        Usuario nuevo=usuarioService.Ingresar(usuario,clave);

        if(nuevo==null)
        {

            return  new Login().Generar_login(true);
        }
        else
        {
            HttpSession session = req.getSession(true);
            session.setAttribute("usuario",nuevo);

            return  new Home(nuevo).Generar_Home();
        }

    }




}
