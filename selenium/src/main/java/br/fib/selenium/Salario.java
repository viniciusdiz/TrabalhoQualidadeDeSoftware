package br.fib.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Salario {
	private WebDriver driver;
	
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ALUNO\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void testeSalario() {
		driver.get("http://192.168.5.115:9098/calculator/new");
		WebElement nome 			= driver.findElement(By.name("name"));
	    WebElement dependentes 	= driver.findElement(By.name("dependents"));
	    WebElement horas 		= driver.findElement(By.name("timeToWork"));
	    WebElement salario 		= driver.findElement(By.name("salaryHour"));
	
	    nome.sendKeys("teste123456789");
	    dependentes.clear();
	    dependentes.sendKeys("1");
	    horas.clear();
	    horas.sendKeys("40");
	    salario.clear();
	    salario.sendKeys("15");
	
	    WebElement botaoSalvar = driver.findElement(By.id("salvar"));
	    botaoSalvar.click();

	    boolean achouNome = driver.getPageSource().contains("teste1");
	    boolean achouSalarioLiquido = driver.getPageSource().contains("562,25");

	    assertTrue(achouNome);
	    assertTrue(achouSalarioLiquido);

	}
	
	@Test
	public void testeNomeVazio() {
	   
	   driver.get("http://192.168.5.115:9098/calculator/new");
	   WebElement nome 			= driver.findElement(By.name("name"));
	   WebElement dependentes 	= driver.findElement(By.name("dependents"));
	   WebElement horas 		= driver.findElement(By.name("timeToWork"));
	   WebElement salario 		= driver.findElement(By.name("salaryHour"));

	   nome.sendKeys("");
	   dependentes.clear();
	   dependentes.sendKeys("1");
	   horas.clear();
	   horas.sendKeys("40");
	   salario.clear();
	   salario.sendKeys("15");

	   WebElement botaoSalvar = driver.findElement(By.id("salvar"));
	   botaoSalvar.click();

	   boolean achouErro = driver.getPageSource().contains("não pode estar vazio");

	   assertTrue(achouErro);

	}
	
	@Test
	public void testeNumerosVazios() {
	   
	   driver.get("http://192.168.5.115:9098/calculator/new");
	   WebElement nome 			= driver.findElement(By.name("name"));
	   WebElement dependentes 	= driver.findElement(By.name("dependents"));
	   WebElement horas 		= driver.findElement(By.name("timeToWork"));
	   WebElement salario 		= driver.findElement(By.name("salaryHour"));

	   nome.sendKeys("teste987654321");
	   dependentes.clear();
	   dependentes.sendKeys("0");
	   horas.clear();
	   horas.sendKeys("0");
	   salario.clear();
	   salario.sendKeys("0");

	   WebElement botaoSalvar = driver.findElement(By.id("salvar"));
	   botaoSalvar.click();

	   boolean achouErro = driver.getPageSource().contains("deve ser maior ou igual a 1");

	   assertTrue(achouErro);

	}
	
	@After
	public void after() {
		
		driver.close();
	}

}

