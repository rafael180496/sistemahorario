package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.view.Login;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    String Mostrar(){
        Login nuevo = new Login();
        return nuevo.Generar_login();
    }

}
