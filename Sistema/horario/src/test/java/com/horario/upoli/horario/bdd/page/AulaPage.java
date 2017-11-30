package com.horario.upoli.horario.bdd.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AulaPage extends  BasePage   {
    @FindBy(linkText = "Aulas")
    private WebElement link_Aulas;

    @FindBy(linkText = "add")
    private WebElement link_agregar;

    @FindBy(id = "txt_nombre")
    private WebElement txt_Aulas;

    @FindBy(className = "check_aula")
    private WebElement check_mant_c;


    @FindBy(className = "grabar")
    private WebElement btn_grabar;

    @FindBy(tagName = "table")
    private  WebElement tabla;


    public void llenarCampoAula(String texto){
        sendKeys(txt_Aulas,texto);
    }


    public  void  EditfilaAula(Long id)
    {
        WebElement btn_edit = driver.findElement(By.className("edit"+id));
        click(btn_edit);
    }

    public  void  DeletefilaAula(Long id)
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

    public void hagoClickEnMantenimiento(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", check_mant_c);
    }


    public void hagoClickEnIngresar(){
        click(link_Aulas);
    }
    public AulaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
