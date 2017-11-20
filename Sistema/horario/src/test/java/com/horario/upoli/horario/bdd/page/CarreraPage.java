package com.horario.upoli.horario.bdd.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarreraPage extends  BasePage  {
    @FindBy(linkText = "Carreras")
    private WebElement link_Carrera;

    public void hagoClickEnIngresar(){
       click(link_Carrera);
    }
    public CarreraPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
