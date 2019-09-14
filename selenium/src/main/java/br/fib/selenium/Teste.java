package br.fib.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Teste {

	@Test
	public void deveAdicionarUmCorrentista() {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\ALUNO\\Desktop\\chromedriver.exe");
	   WebDriver driver = new ChromeDriver();
	   driver.get("http://192.168.5.115:8080/correntista/novo");
	   WebElement nome = driver.findElement(By.name("nome"));
	   WebElement email = driver.findElement(By.name("email"));

	   nome.sendKeys("Manoel da Silva");
	   email.sendKeys("manoel.silva@mailinator.com");

	   WebElement botaoSalvar = driver.findElement(By.id("button1"));
	   botaoSalvar.click();

	   boolean achouNome = driver.getPageSource().contains("Manoel da Silva");
	   boolean achouEmail = driver.getPageSource().contains("manoel.silva@mailinator.com");

	   assertTrue(achouNome);
	   assertTrue(achouEmail);

	   driver.close();
	}

}
