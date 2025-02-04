package br.com.teste;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
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
//	public void testeTextField(){
//		dsl.escrever("elementosForm:nome", "Teste de escrita");
//		Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));
//	}
//	
//	@Test
//	public void testTextFieldDuplo(){
//		dsl.escrever("elementosForm:nome", "Wagner");
//		Assert.assertEquals("Wagner", dsl.obterValorCampo("elementosForm:nome"));
//		dsl.escrever("elementosForm:nome", "Aquino");
//		Assert.assertEquals("Aquino", dsl.obterValorCampo("elementosForm:nome"));
//	}
//	
//	@Test
//	public void deveIntegarirComTextArea(){
//		dsl.escrever("elementosForm:sugestoes", "teste\n\naasldjdlks\nUltima linha");
//		Assert.assertEquals("teste\n\naasldjdlks\nUltima linha", dsl.obterValorCampo("elementosForm:sugestoes"));
//	}
//	
//	@Test
//	public void deveIntegarirComRadioButton(){
//		dsl.clicarRadio("elementosForm:sexo:0");
//		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
//	}
//	
//	@Test
//	public void deveIntegarirComCheckbox(){
//		dsl.clicarCheck("elementosForm:comidaFavorita:2");
//		Assert.assertTrue(dsl.isCheckMarcado("elementosForm:comidaFavorita:2"));
//	}
//	
//	@Test
//	public void deveIntegarirComCombo(){
//		dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
//		Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));
//	}
//	
//	@Test
//	public void deveVerificarValoresCombo(){
//		Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
//		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
//	}
//	
//	@Test
//	public void deveVerificarValoresComboMultiplo(){
//		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
//		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
//		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
//
//		List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
//		Assert.assertEquals(3, opcoesMarcadas.size());
//		
//		dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
//		opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
//		Assert.assertEquals(2, opcoesMarcadas.size());
//		Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));
//	}
//	
//	@Test
//	public void deveinteragirComBotoes(){
//		dsl.clicarBotao("buttonSimple");
//		Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));
//	}
//	
//	@Test
//	public void deveinteragirComLinks(){
//		dsl.clicarLink("Voltar");
//		
//		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
//	}
//	
//	@Test
//	public void deveBuscarTextosNaPagina(){
////		Assert.assertTrue(driver.findElement(By.tagName("body"))
////				.getText().contains("Campo de Treinamento"));
//		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
//		
//		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", 
//				dsl.obterTexto(By.className("facilAchar")));
//	}
//	
//	@Test
//	public void testJavascript(){
//		JavascriptExecutor js = (JavascriptExecutor) getDriver();
////		js.executeScript("alert('Testando js via selenium')");
//		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
//		js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
//		
//		WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
//		js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
//	}
//	
//	@Test
//	public void deveClicarBotaoTabela(){
//		dsl.clicarBotaoTabela("Escolaridade", "Mestrado", "Radio", "elementosForm:tableUsuarios");
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
	public void testeTextField(){		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");	
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}
	
	
	@Test
	public void deveIntegarirComTextArea(){		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\n\naasldjdlks\nUltima linha");		
		Assert.assertEquals("teste\n\naasldjdlks\nUltima linha", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		}
	
	@Test
	public void deveIntegarirComRadioButton(){
//		WebDriver driver = new ChromeDriver();
//		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
//		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());		
	}
	
	
	@Test
	public void deveIntegarirComCheckbox(){		
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	}
	
	@Test
	public void deveIntegarirComCombo(){		
		WebElement element=driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByIndex(3);
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
	}
	
	@Test
	public void deveVerificarValoresCombo(){		
		WebElement element=driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options =combo.getOptions();
		Assert.assertEquals(8, options.size());
		 boolean encontrou=false;
		 for(WebElement option: options) {
			 if(option.getText().equals("Mestrado")) {
				 encontrou=true;
				 break;
			 }
		 }
		Assert.assertTrue(encontrou);
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo(){		
		WebElement element=driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> options =combo.getAllSelectedOptions();
		Assert.assertEquals(3, options.size());
		
		
		combo.deselectByVisibleText("Corrida");
		options = combo.getAllSelectedOptions();
		Assert.assertEquals(2, options.size());
	}
	
	
	@Test
	public void deveinteragirComBotoes(){		
		driver.findElement(By.id("buttonSimple")).click();		
		Assert.assertEquals("Obrigado!", driver.findElement(By.id("buttonSimple")).getAttribute("value"));
	}
	
	@Test
	public void deveinteragirComLinks(){		
		driver.findElement(By.linkText("Voltar")).click();	
		//Assert.fail();
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	}
	
	@Test
	public void deveBuscarTextosNaPagina(){		
		driver.findElement(By.tagName("body"));
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());	
	}	
}
