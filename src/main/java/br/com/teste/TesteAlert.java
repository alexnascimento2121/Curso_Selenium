package br.com.teste;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {
	
//	private DSL dsl;
//	
//	@Before
//	public void inicializa(){
//		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		dsl = new DSL();
//	}
//	
//	@After
//	public void finaliza(){
//		DriverFactory.killDriver();
//	}
//
//	@Test
//	public void deveInteragirComAlertSimples(){
//		dsl.clicarBotao("alert");
//		String texto = dsl.alertaObterTextoEAceita(); 
//		Assert.assertEquals("Alert Simples", texto);
//		
//		dsl.escrever("elementosForm:nome", texto);
//	}
//	
//	@Test
//	public void deveInteragirComAlertConfirm(){
//		dsl.clicarBotao("confirm");
//		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
//		Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());
//		
//		dsl.clicarBotao("confirm");
//		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
//		Assert.assertEquals("Negado", dsl.alertaObterTextoENega());
//	}
//	
//	@Test
//	public void deveInteragirComAlertPrompt(){
//		dsl.clicarBotao("prompt");
//		Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
//		dsl.alertaEscrever("12");
//		Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
//		Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
//	}
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.manage().window().setSize(new Dimension(1200, 765));
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	
	@Test
	public void deveInteragirComAlertSimples(){		
		driver.findElement(By.id("alert")).click();
		Alert alert=driver.switchTo().alert();
		 String texto=alert.getText();
		Assert.assertEquals("Alert Simples",texto);
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}
	
	@Test
	public void deveInteragirComAlertConfirm(){	
		driver.findElement(By.id("confirm")).click();
		Alert alert=driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();		
	}
	
	@Test
	public void deveInteragirComAlertPrompt(){		
		driver.findElement(By.id("prompt")).click();
		Alert alert=driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("12");
		alert.accept();
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D",alert.getText());
		alert.accept();
	}
}
