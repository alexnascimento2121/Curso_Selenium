package br.com.teste;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.core.DSL;

public class TestePrimefaces {
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa(){
		driver = new ChromeDriver();
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.manage().window().setSize(new Dimension(1200, 765));
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}

	@Test
	public void deveInteragirComRadioPrime(){
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clicarRadio(By.xpath("//input[@id='j_idt342:line:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt342:line:0"));
		dsl.clicarRadio(By.xpath("//label[.='Option3']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt342:line:2"));
	}
	
	@Test
	public void deveInteragirComSelectPrime(){
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.clicarRadio(By.xpath("//div[@id='j_idt341:option']//span"));
		Assert.assertEquals("Select One",dsl.obterTexto("j_idt341:option_label"));
		dsl.selecionarComboPrime("j_idt341:option", "Option2");
		Assert.assertEquals("Option2", dsl.obterTexto("j_idt341:option_label"));
	}

}
