package com.horario.upoli.horario.bdd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensajePage extends  BasePage {
    @FindBy(className = "verde")
    private WebElement link_verde;

    @FindBy(className = "rojo")
    private WebElement link_rojo;

    public  void hagoClickEnVerde()
    {
        click(link_verde);
    }
    public  void hagoClickEnRojo()
    {
        click(link_rojo);
    }

    public MensajePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
