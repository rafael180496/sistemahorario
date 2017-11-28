package com.horario.upoli.horario.bdd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AulaPage extends  BasePage   {



    public AulaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
