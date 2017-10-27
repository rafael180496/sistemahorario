package com.horario.upoli.horario.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import view.Html;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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

        return  nuevo.headComienzo()+nuevo.bodyComienzo()+formulario+nuevo.Scrip()+nuevo.bodyFin()+nuevo.headFin();
    }

    @RequestMapping(value = "/nuevo")
    String  index2(HttpServletRequest req, HttpServletResponse res)
    {
        System.out.println(req);
        return  req.getParameter("edad");
    }

}
