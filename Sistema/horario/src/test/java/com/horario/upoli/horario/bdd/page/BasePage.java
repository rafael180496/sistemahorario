package com.horario.upoli.horario.bdd.page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;


    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
    }

    public boolean isElementPresent(WebElement element){
        return element.isDisplayed();
    }

    public void waitForVisibilityOfElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickabilityOfElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element){
        waitForClickabilityOfElement(element);
        element.click();
    }

    public void sendKeys(WebElement element, String keyword){
        waitForVisibilityOfElement(element);
        element.clear();
        element.sendKeys(keyword);
    }

    public String getText(WebElement element){
        waitForVisibilityOfElement(element);
        return element.getText();
    }

    public String getAttributeValue(WebElement element, String attribute){
        waitForVisibilityOfElement(element);
        return element.getAttribute(attribute);
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public void wait(int time){
        try {
            long milliseconds = time*1000;
            Thread.sleep(milliseconds);
        } catch (InterruptedException e){
            System.out.println(">>> Error: " + e);
        }
    }

    public void findTextInBody(WebElement body, String text){
        waitForVisibilityOfElement(body);
        String bodyText = body.getText();
        Assert.assertTrue("Texto no econtrado! => Se busca: \"" + text + "\" Se econtro: \"" + bodyText + "\"", bodyText.contains(text));
    }


}
