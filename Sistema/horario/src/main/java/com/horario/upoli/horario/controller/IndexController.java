package com.horario.upoli.horario.controller;
import com.horario.upoli.horario.view.Index;
import com.horario.upoli.horario.view.componentes.Html;
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

    @RequestMapping(value = "/prueba",method = RequestMethod.GET)
    String  prueba()
    {
         Html html= new Html();
         ArrayList<String> n= new ArrayList<>();


         n.add("<form action=\"/prueba2\" method=\"POST\">\n" +
                 "\n" +
                 "    <input type=\"checkbox\"  name=\"numero\">\n" +
                 "    <input type=\"submit\" class=\"waves-effect waves-light btn\" value=\"Actualizar\">\n" +
                 "\n" +
                 "</form>");
         html.setCuerpo(n);
        return html.Generar_Html();
    }

    @RequestMapping(value = "/prueba2")
    String  prueba2(HttpServletRequest req, HttpServletResponse res)
    {
        String n= "off";
         n= (String) req.getParameter("numero");
         if (n==null)
         {
             n= "off";
         }
        return n;
    }

}
