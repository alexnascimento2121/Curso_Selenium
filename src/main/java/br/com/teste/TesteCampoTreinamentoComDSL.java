package br.com.teste;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import br.com.core.BaseTeste;
import br.com.core.DSL_Core;
import br.com.core.DriverFactory;

public class TesteCampoTreinamentoComDSL extends BaseTeste{
	private DSL_Core dsl;
	
	
	@Before
	public void inicializa() {
		DriverFactory.getDriver().get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		dsl= new DSL_Core();
	}
		
	@Test
	public void testeTextField(){		
		dsl.escrever("elementosForm:nome","Teste de escrita");	
		Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));
	}
	
	@Test
	public void testeTextFieldDuplo(){		
		dsl.escrever("elementosForm:nome","Alex");	
		Assert.assertEquals("Alex", dsl.obterValorCampo("elementosForm:nome"));
		dsl.escrever("elementosForm:nome","Nascimento");	
		Assert.assertEquals("Nascimento", dsl.obterValorCampo("elementosForm:nome"));
	}
	
	
	@Test
	public void deveInteragirComTextArea(){		
		dsl.escrever("elementosForm:sugestoes", "teste\n\naasldjdlks\nUltima linha");			
		Assert.assertEquals("teste\n\naasldjdlks\nUltima linha",dsl.obterValorCampo("elementosForm:sugestoes"));		
	}
	
	@Test
	public void deveInteragirComRadioButton(){		
		dsl.clicarRadio("elementosForm:sexo:0");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));		
	}
	
	
	@Test
	public void deveInteragirComCheckbox(){			
		dsl.clicarCheck("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.isCheckMarcado("elementosForm:comidaFavorita:2"));
	}
	
	@Test
	public void deveInteragirComCombo(){		
		dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
		Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));
	}
	
	@Test
	public void deveVerificarValoresCombo(){	
		Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));		
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo(){		
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		List<String> options =dsl.obterValoresCombo("elementosForm:escolaridade");
		Assert.assertEquals(3, options.size());
		
		
		dsl.deselecionarCombo("elementosForm:esportes","Corrida");
		options = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(2, options.size());
		Assert.assertTrue(options.containsAll(Arrays.asList("Natacao","O que eh esporte?")));
	}
	
	
	@Test
	public void deveinteragirComBotoes(){		
		dsl.clicarBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", dsl.obterValorCampo("buttonSimple"));
	}
	
	@Test
	public void deveinteragirComLinks(){	
		dsl.clicarLink("Voltar");		
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
	}
	
	@Test
	public void deveBuscarTextosNaPagina(){	
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));	
	}	
	
	@Test
	public void testJavascript(){
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
//		js.executeScript("alert('Testando js via selenium')");
		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
		js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
		
		WebElement element = DriverFactory.getDriver().findElement(By.id("elementosForm:nome"));
		js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
	}
	
	@Test
	public void deveClicarBotaoTabela(){
		dsl.clicarBotaoTabela("Escolaridade", "Mestrado", "Radio", "elementosForm:tableUsuarios");
	}
}
