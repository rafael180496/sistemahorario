package com.horario.upoli.horario.bdd.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClasePage extends  BasePage  {
    @FindBy(linkText = "Clases")
    private WebElement link_Clase;

    @FindBy(linkText = "add")
    private WebElement link_agregar;

    @FindBy(id = "txt_nombre")
    private WebElement txt_clase;

    @FindBy(className = "grabar")
    private WebElement btn_grabar;

    @FindBy(tagName = "table")
    private  WebElement tabla;


    public void llenarCampoClase(String texto){
        sendKeys(txt_clase,texto);
    }


    public  void  EditfilaClase(Long id)
    {
        WebElement btn_edit = driver.findElement(By.className("edit"+id));
        click(btn_edit);
    }

    public  void  DeletefilaCarrera(Long id)
    {
        WebElement btn_edit = driver.findElement(By.className("delete"+id));
        click(btn_edit);
    }
    public void hagoClickEnAgregar(){

        click(link_agregar);
    }

    public void hagoClickEnGrabar(){
        click(btn_grabar);

    }
    public  void  verificar(String verificar)
    {
        findTextInBody(tabla,verificar);
    }

    public void hagoClickEnIngresarClase(){
        click(link_Clase);
    }

    public ClasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
