package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.view.Index;
import com.horario.upoli.horario.view.componentes.Formulario;
import com.horario.upoli.horario.view.componentes.Html;
import com.horario.upoli.horario.view.componentes.NavbarIndex;
import com.horario.upoli.horario.view.constante.Metodos;
import javafx.scene.control.Alert;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


@RestController
public class IndexController {
private Html nuevo= new Html();


    @RequestMapping(value = "",method = RequestMethod.GET)
    String  index()
    {

        Index  index = new Index();
       return index.Generar_Index();
    }



    @RequestMapping(value = "/nuevo")
    String  index2(HttpServletRequest req, HttpServletResponse res)
    {
        System.out.println(req);
        return  req.getParameter("edad");
    }

}
