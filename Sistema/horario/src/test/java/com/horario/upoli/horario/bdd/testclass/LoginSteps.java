package com.horario.upoli.horario.bdd.testclass;

import com.horario.upoli.horario.bdd.page.CarreraPage;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.runtime.java.StepDefAnnotation;
import com.horario.upoli.horario.bdd.Context;
import com.horario.upoli.horario.bdd.SeleniumBaseDriver;
import com.horario.upoli.horario.bdd.page.LoginPage;
import org.openqa.selenium.WebDriver;

@StepDefAnnotation
public class LoginSteps  extends Context {

    String urlbase;
    WebDriver driver;
    LoginPage login;
    CarreraPage carrera;

    private SeleniumBaseDriver selenium;

    public LoginSteps(SeleniumBaseDriver selenium){
        super();
        this.selenium = selenium;
        this.urlbase = "http://localhost:8080/login";
    }

    @Dado("^que estoy en la pagina de Login")
    public void estoy_en_pagina_login() throws Throwable {
        driver = selenium.getDriver();
        driver.get(urlbase);
        login = new LoginPage(driver);
        carrera=new CarreraPage(driver);
    }

    @Cuando("^yo lleno el campo nombre de usuario con \"(.+)\"$")
    public void lleno_el_campo_nombre_con(String valor) throws Throwable {
        login.llenarCampoUsuario(valor);
    }

    @Cuando("^yo lleno el campo contraseña con \"(.+)\"$")
    public void lleno_el_campo_password_con(String valor) throws Throwable {
        login.llenarCampoClave(valor);
    }

    @Cuando("^yo hago click el boton Ingresar$")
    public void hago_click_en_boton_login() {
        login.hagoClickEnIngresar();
    }

    @Cuando("^yo hago click al link Carrera$")
    public void hago_click_en_link_carrera() {
        carrera.hagoClickEnIngresar();
    }

    @Entonces("^Me detengo por (\\d+) segundos$")
    public void me_detego_por(int segundos) throws Throwable{
        login.esperar(segundos);
    }

    @Entonces("^yo deberia poder ver el texto \"(.+)\"$")
    public void deberia_poder_ver(String texto) throws Throwable{
        login.buscarTextoVisible(texto);
    }
}
