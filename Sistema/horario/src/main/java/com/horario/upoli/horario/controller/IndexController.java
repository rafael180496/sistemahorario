package com.horario.upoli.horario.controller;
import com.horario.upoli.horario.view.Index;
import com.horario.upoli.horario.view.componentes.HtmlK;
import org.springframework.web.bind.annotation.*;


@RestController
public class IndexController {
private HtmlK nuevo= new HtmlK();


    @RequestMapping(value = "",method = RequestMethod.GET)
    String  index()
    {

        Index  index = new Index();
       return index.Generar_Index();
    }





}
