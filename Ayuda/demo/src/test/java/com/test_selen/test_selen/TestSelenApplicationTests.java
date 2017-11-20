package com.test_selen.test_selen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSelenApplicationTests {

	@Test
	public void contextLoads() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://suvian.in/selenium/index.html");
		//tiempo
		Thread.sleep(2000);
		//comenzar
		System.out.println("===========Comenzar=================");
		WebElement btn = driver.findElement(By.linkText("Start Level 1"));
		btn.click();
		System.out.println("============termina================");
		//tiempo
		Thread.sleep(2000);
		//comenzar
		System.out.println("===========Comenzar1=================");
				/*
		Hacer clic en cualquier enlace o botón es uno
		 de los primeros desafíos en Automatización con
		Selenium Webdriver. Entonces comencemos.
		Intenta hacer clic en el enlace a continuación*/
		 btn = driver.findElement(By.linkText("Click Here"));
		btn.click();
		Thread.sleep(1000);
		/*regresa al link anterior */
		btn = driver.findElement(By.linkText("<< Navigate Back"));
		btn.click();
		Thread.sleep(1000);
		/*siguiente reto*/
		btn = driver.findElement(By.linkText("Next Task >"));
		btn.click();

		System.out.println("============termina1================");
		//tiempo
		Thread.sleep(2000);
		//comenzar
		System.out.println("===========Comenzar2=================");
				/*

				Ingrese su nombre en el
				campo de texto a continuación*/
		btn = driver.findElement(By.id("namefield"));
		btn.sendKeys("Rafael Hidalgo");
		Thread.sleep(1000);

		/*siguiente reto*/
		btn = driver.findElement(By.linkText("Next Task >"));
		btn.click();

		System.out.println("============termina2================");
		//tiempo
		Thread.sleep(2000);
		//comenzar
		System.out.println("===========Comenzar3=================");
				/*Elimina el texto predeterminado e ingresa tu edad*/
		btn = driver.findElement(By.id("agefield"));
		btn.clear();
		btn.sendKeys("21");
		Thread.sleep(1000);

		/*siguiente reto*/
		btn = driver.findElement(By.linkText("Next Task >"));
		btn.click();

		System.out.println("============termina3================");
		//tiempo
		Thread.sleep(2000);
		//comenzar
		System.out.println("===========Comenzar4=================");
				/*
					Seleccione su género desde abajo desplegable*/
		btn=driver.findElement(By.name("gender"));
		btn.click();
		Thread.sleep(1000);
		Select dropdown = new Select(driver.findElement(By.name("gender")));
		dropdown.selectByVisibleText("Male");
		//cualquiera de los dos funciona
		//dropdown.selectByValue("1");
		Thread.sleep(1000);

		/*siguiente reto*/
		btn = driver.findElement(By.linkText("Next Task >"));
		btn.click();

		System.out.println("============termina4================");
		//tiempo
		Thread.sleep(2000);
		//comenzar
		System.out.println("===========Comenzar5=================");
				/*
					Estás casada ?*/

		List<WebElement> elementos = driver.findElements(By.name("married"));
		System.out.println(elementos.size());
		for (int i=0;i< elementos.size();i++
			 ) {
			String sValue = elementos.get(i).getAttribute("value");
			System.out.println("+++++++++++++++++++++++++++++++++++++++");
			System.out.println(sValue);
			int numero=Integer.parseInt(sValue);
			System.out.println("+++++++++++++++++++++++++++++++++++++++");
			if(numero==1){
				System.out.println("+++Seleccionado+++++="+elementos.get(i).getText());
				elementos.get(i).click();
				break;
			}
		}
		//cualquiera de los dos funciona
		//dropdown.selectByValue("1");
		Thread.sleep(1000);

		/*siguiente reto*/
		btn = driver.findElement(By.linkText("Next Task >"));
		btn.click();

		System.out.println("============termina5================");
		//tiempo
		Thread.sleep(2000);
		//comenzar
		System.out.println("===========Comenzar6=================");
				/*
					Seleccione sus pasatiempos ?*/

		btn = driver.findElement(By.id("3"));
		btn.click();
		Thread.sleep(1000);
		btn= driver.findElement(By.id("4"));
		btn.click();
		Thread.sleep(1000);


		/*siguiente reto*/
		btn = driver.findElement(By.linkText("Next Task >"));
		btn.click();


		System.out.println("============termina6================");
		//tiempo
		Thread.sleep(2000);
		//comenzar
		System.out.println("===========Comenzar7=================");
				/*
					Botón hecho clic con éxito. Espere 10
					segundos en esta página y luego haga clic en
					el botón 'Navegar hacia atrás'*/

		btn = driver.findElement(By.linkText("Click Me"));
		btn.click();
		Thread.sleep(10000);
		btn = driver.findElement(By.linkText("<< Navigate Back"));
		btn.click();
		Thread.sleep(1000);


		/*siguiente reto*/
		btn = driver.findElement(By.linkText("Next Task >"));
		btn.click();


		System.out.println("============termina7================");
//tiempo
		Thread.sleep(2000);
		//comenzar
		System.out.println("===========Comenzar8=================");
				/*
					Copie este texto y péguelo en el siguiente cuadro*/
		List<WebElement> divs =driver.findElements(By.tagName("h3"));
		String copiar= divs.get(0).getText();
		Thread.sleep(1000);
		btn = driver.findElement(By.id("copyandpaste"));
		btn.sendKeys(copiar);
		Thread.sleep(1000);


		/*siguiente reto*/
		btn = driver.findElement(By.linkText("Next Task >"));
		btn.click();


		System.out.println("============termina8================");
		//tiempo
		Thread.sleep(2000);
		//comenzar
		System.out.println("===========Comenzar9=================");
				/*
					Copie este texto y péguelo en el siguiente cuadro*/

		divs =driver.findElements(By.tagName("h3"));
		copiar= divs.get(0).getText();

		String copiarF="";
		int cont=0;
		for (char n:copiar.toCharArray()
			 ) {

			if (n=='"'){
				cont++;
			}

			if (cont==1){
				copiarF+=n;
			}
			if (cont==2){
				break;
			}

		}

		Thread.sleep(1000);

		btn = driver.findElement(By.id("copyandpasteadvanced"));
		btn.sendKeys(copiarF);
		Thread.sleep(1000);


		/*siguiente reto*/
		btn = driver.findElement(By.linkText("Next Task >"));
		btn.click();


		System.out.println("============termina9================");
		//tiempo
		Thread.sleep(2000);
		//comenzar
		System.out.println("===========Comenzar10=================");
				/*
					Seleccione la opción 2 del menú desplegable*/
		btn = driver.findElement(By.className("dropbtn"));
		btn.click();
		Thread.sleep(1000);
		btn = driver.findElement(By.linkText("Option 2"));
		btn.click();
		Thread.sleep(1000);

		String originalHandle = driver.getWindowHandle();
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		System.out.println(originalHandle);
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		//Do something to open new tabs

		for(String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				driver.close();
				Thread.sleep(1000);

			}
		}

		driver.switchTo().window(originalHandle);


		Thread.sleep(1000);
		/*siguiente reto*/
		btn = driver.findElement(By.linkText("Finish Level 1 >"));
		btn.click();


		System.out.println("============termina10================");


		Thread.sleep(2000);
		driver.quit();
	}


}
