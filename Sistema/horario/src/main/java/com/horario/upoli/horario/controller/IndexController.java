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





}
