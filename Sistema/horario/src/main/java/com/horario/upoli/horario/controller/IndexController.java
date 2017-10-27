package com.horario.upoli.horario.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import view.Html;

@RestController
public class IndexController {
private Html nuevo= new Html();


    @RequestMapping("/")
    String  index()
    {

        return  nuevo.headComienzo()+nuevo.bodyComienzo()+"<h1>rafael </h1>"+nuevo.bodyFin()+nuevo.headFin();
    }
}
