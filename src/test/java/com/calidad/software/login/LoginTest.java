package com.calidad.software.login;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	private WebDriver driver;
	
	@Before
	public void iniciar() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200");
	}

	@Test
	public void testLogin() {

	    WebElement emailField = driver.findElement(By.name("email"));
	    WebElement passwordField = driver.findElement(By.name("password"));
	    WebElement loginButton = driver.findElement(By.name("submit"));
	    
	    emailField.sendKeys("admin@udea.edu.co");
	    passwordField.sendKeys("Admin123");
	    loginButton.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    WebElement nameField = driver.findElement(By.name("name"));
	    WebElement idField = driver.findElement(By.name("id"));
	    WebElement genderField = driver.findElement(By.name("gender"));
	    WebElement ageField = driver.findElement(By.name("age"));
	    WebElement addressField = driver.findElement(By.name("address"));
	    WebElement cityField = driver.findElement(By.name("city"));
	    
	    nameField.sendKeys("Juan Esteban Andrade");
	    idField.sendKeys("1039701466");
	    genderField.sendKeys("Male");
	    ageField.sendKeys("24");
	    addressField.sendKeys("Calle 68a");
	    cityField.sendKeys("Medellin");
	    cityField.submit();
	    
		assertEquals("Data Saved",driver.switchTo().alert().getText());
	}

	@After
	public void finalizar() {
		//driver.quit();
	}
}
