package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.constante.MensajeIco;
import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.recursos.Permiso;
import com.horario.upoli.horario.service.UsuarioService;
import com.horario.upoli.horario.view.Home;
import com.horario.upoli.horario.view.componentes.MensajeLogin;
import com.horario.upoli.horario.view.login.Login;
import com.horario.upoli.horario.view.login.LoginRecuperar;
import com.horario.upoli.horario.view.login.LoginResta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
   private UsuarioService usuarioService;

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
        if (recupera.getInd_rest())
        {
            HttpSession session = req.getSession(true);
            session.setAttribute("usuario",recupera);
            return  new  LoginResta().Generar_login_c();
        }

            HttpSession session = req.getSession(true);
            session.setAttribute("usuario",recupera);

            return  new Home(recupera).Generar_Home();


    }

    @RequestMapping(value = "/login/recuperar",method = RequestMethod.GET)
    String  Recuperar(HttpServletRequest req, HttpServletResponse res)
    {

        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",null);
        LoginRecuperar nuevo = new LoginRecuperar();
        return nuevo.Generar_login_r();


    }

    @RequestMapping(value = "/login/cambiar",method = RequestMethod.GET)
    String  Cambiar(HttpServletRequest req, HttpServletResponse res)
    {

        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        if(recupera==null)
        {

            return  new Login().Generar_login(true);
        }
        return new  LoginResta().Generar_login_c();

    }



    @RequestMapping(value = "/login/recuperar/enviar")
    String  Recuperar_env(HttpServletRequest req, HttpServletResponse res)
    {

        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        session.setAttribute("usuario",null);

        String correo="";
        MensajeLogin mensaje= new MensajeLogin();
        correo= (String)req.getParameter("txt_correo").replace(" ","");
        correo= correo.replace(" ","");
        if (usuarioService.Recuperacion(correo)){
            mensaje.setBtn_cancelar(false);
            mensaje.setBtn_verde(new Permiso("/login","Regresar"));
            mensaje.setTipo(MensajeIco.Bien.mostrar());
            mensaje.setTit("Enviado");
            mensaje.setCuerpo("Se envió una clave de recuperación al correo por favor revise el correo.");

        }
        else {
            mensaje.setBtn_cancelar(true);
            mensaje.setBtn_rojo(new Permiso("/login","Regresar"));
            mensaje.setBtn_verde(new Permiso("/login/recuperar","Intentar"));
            mensaje.setTipo(MensajeIco.Error.mostrar());
            mensaje.setTit("Error");
            mensaje.setCuerpo("Este correo que introdujo no está asociado a ningún usuario del sistema.");

        }


        return mensaje.Generar_Mensaje();

    }
    @RequestMapping(value = "/login/cambiar/guardar")
    String  Cambiar_Clave(HttpServletRequest req, HttpServletResponse res)
    {

        HttpSession session = req.getSession(true);
        Usuario recupera = (Usuario) session.getAttribute("usuario");
        if(recupera==null)
        {

            return  new Login().Generar_login(true);
        }

        String clave_n="",clave_c="";
        MensajeLogin mensaje= new MensajeLogin();
        clave_c=(String)req.getParameter("txt_clave_c").replace(" ","");
        clave_n=(String)req.getParameter("txt_clave_n").replace(" ","");
        if (clave_c.equals(clave_n)){

            usuarioService.Cambiar_clave(recupera.getId_usuario(),clave_n);
            session = req.getSession(true);
            session.setAttribute("usuario",recupera);
            return  new Home(recupera).Generar_Home();
        }
        else {
            mensaje.setBtn_cancelar(true);
            mensaje.setBtn_rojo(new Permiso("/login","Regresar"));
            mensaje.setBtn_verde(new Permiso("/login/cambiar","Intentar"));
            mensaje.setTipo(MensajeIco.Error.mostrar());
            mensaje.setTit("Error");
            mensaje.setCuerpo("Las claves no son iguales por favor ingresar correctamente las claves.");
            return mensaje.Generar_Mensaje();
        }

    }




}
