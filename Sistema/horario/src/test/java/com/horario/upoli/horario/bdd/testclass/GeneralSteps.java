package com.horario.upoli.horario.bdd.testclass;

import com.horario.upoli.horario.bdd.page.CarreraPage;
import com.horario.upoli.horario.bdd.page.MensajePage;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.runtime.java.StepDefAnnotation;
import com.horario.upoli.horario.bdd.Context;
import com.horario.upoli.horario.bdd.SeleniumBaseDriver;
import com.horario.upoli.horario.bdd.page.LoginPage;
import org.openqa.selenium.WebDriver;

@StepDefAnnotation
public class GeneralSteps  extends Context {

    String urlbase;
    WebDriver driver;
    LoginPage login;
    CarreraPage carrera;
    MensajePage mensaje;
    int espera=1;
    private SeleniumBaseDriver selenium;

    public GeneralSteps(SeleniumBaseDriver selenium){
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
        mensaje=new MensajePage(driver);
    }
    @Cuando("^yo espero por cada uno \"(\\d+)\"$")
    public void lleno_el_esperar(int valor) throws Throwable {
        espera=valor;


    }


    @Cuando("^yo lleno el campo nombre de usuario con \"(.+)\"$")
    public void lleno_el_campo_nombre_con(String valor) throws Throwable {
        login.esperar(espera);
        login.llenarCampoUsuario(valor);

    }

    @Cuando("^yo lleno el campo contraseña con \"(.+)\"$")
    public void lleno_el_campo_password_con(String valor) throws Throwable {
        login.esperar(espera);
        login.llenarCampoClave(valor);
    }

    @Cuando("^yo hago click el boton Ingresar$")
    public void hago_click_en_boton_login() {
        login.esperar(espera);
        login.hagoClickEnIngresar();
    }



    @Entonces("^Me detengo por (\\d+) segundos$")
    public void me_detego_por(int segundos) throws Throwable{
        login.esperar(segundos);
    }

    @Entonces("^yo deberia poder ver el texto \"(.+)\"$")
    public void deberia_poder_ver(String texto) throws Throwable{
        login.esperar(espera);
        login.buscarTextoVisible(texto);
    }

    /*carrera*/
    @Cuando("^yo hago click al link Carrera$")
    public void hago_click_en_link_carrera() {
        login.esperar(espera);
        carrera.hagoClickEnIngresar();
    }

    @Cuando("^yo hago click al link Agregar$")
    public void hago_click_en_link_Agregar() {
        login.esperar(espera);
        carrera.hagoClickEnAgregar();
    }

    @Cuando("^yo hago click al Grabar$")
    public void hago_click_en_grabar() {
        login.esperar(espera);
        carrera.hagoClickEnGrabar();
    }

    @Cuando("^yo hago click en el boton Verde")
    public void hago_click_en_Verde() {
        login.esperar(espera);
        mensaje.hagoClickEnVerde();
    }


    @Cuando("^yo hago click en el boton Rojo")
    public void hago_click_en_Rojo()
    {
        login.esperar(espera);
        mensaje.hagoClickEnRojo();
    }

    @Cuando("^yo lleno el campo carrera con \"(.+)\"$")
    public void lleno_el_campo_carrera_con(String valor) throws Throwable {
        login.esperar(espera);
        carrera.llenarCampoCarrera(valor);
    }


    @Cuando("^yo hago click  en el boton editar de la fila  con \"(.+)\"$")
    public void click_editar_carrera(Long valor) throws Throwable {
        login.esperar(espera);
        carrera.EditfilaCarrera(valor);
    }


    @Cuando("^yo hago click  en el boton elimnar de la fila  con \"(.+)\"$")
    public void click_eliminar_carrera(Long valor) throws Throwable {
        login.esperar(espera);
        carrera.DeletefilaCarrera(valor);
    }

    @Cuando("^yo verifico si existe :\"(.+)\"$")
    public void verifico_el_campo(String valor) throws Throwable {
        login.esperar(espera);
        carrera.verificar(valor);
    }

}
