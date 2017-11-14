package com.horario.upoli.horario.bdd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends  BasePage {
    @FindBy(name = "txt_usuario")
    private WebElement txt_usuario;

    @FindBy(name = "txt_clave")
    private WebElement txt_clave;

    @FindBy(tagName = "body")
    private WebElement body;
    @FindBy(name = "btn_ingresar")
    private WebElement btn_ingresar;


    public void llenarCampoUsuario(String texto){
        sendKeys(txt_usuario,texto);
    }

    public void llenarCampoClave(String texto){
        sendKeys(txt_clave,texto);
    }

    public void hagoClickEnIngresar(){
        click(btn_ingresar);
    }

    public void esperar(int segundos) {
        wait(segundos);
    }

    public void buscarTextoVisible(String texto){
        findTextInBody(body, texto);
    }



    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
            isElementPresent(txt_usuario);
    }
}
