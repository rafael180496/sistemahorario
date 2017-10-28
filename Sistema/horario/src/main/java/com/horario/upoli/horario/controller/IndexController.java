package com.horario.upoli.horario.controller;

import com.horario.upoli.horario.view.Html;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


@RestController
public class IndexController {
private Html nuevo= new Html();


    @RequestMapping(value = "",method = RequestMethod.GET)
    String  index()
    {

        String formulario="<form action=\"/nuevo\" method=\"post\">\n" +
                "        <input type=\"password\" name=\"edad\" value=\"\">\n" +
                "        <input type=\"submit\" value=\"guardar\">\n" +
                "    </form>";

        ArrayList<String> n= new ArrayList<>();
        n.add("<h1>prueba1</h1>\n");
        n.add("<h1>prueba2</h1>\n");
        nuevo.setCuerpo(n);
        return nuevo.Generar_Html();
       // return  nuevo.headComienzo()+nuevo.bodyComienzo()+formulario+nuevo.Scrip()+nuevo.bodyFin()+nuevo.headFin();
    }

    @RequestMapping(value = "/nuevo")
    String  index2(HttpServletRequest req, HttpServletResponse res)
    {
        System.out.println(req);
        return  req.getParameter("edad");
    }

}
