package com.horario.upoli.horario.bdd;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumBaseDriver {
    private static WebDriver webDriver;

    private static boolean initialized = false;

    @Before
    public void start() {
        if (!initialized) {
            System.out.println("Iniciando test Cucumber...");
            System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            initialized = true;
        }
    }

    @After
    public void quit() {
        System.out.println("Finalizando...");
        initialized = false;
        webDriver.close();
        webDriver.quit();
    }

    public static WebDriver getDriver(){
        return webDriver;
    }
}
