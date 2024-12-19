package br.com.teste;
import static br.com.core.DriverFactory.getDriver;
import static br.com.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.core.DSL;
import br.com.page.CampoTreinamentoPage;

public class TestCadastro {
	//private WebDriver driver;
	private CampoTreinamentoPage page;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
//		driver = new ChromeDriver();
//		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
//		driver.manage().window().setSize(new Dimension(1200, 765));
		page = new CampoTreinamentoPage(getDriver());
		dsl= new DSL(getDriver());
	}
	
	@After
	public void finaliza() {
		//driver.quit();
		killDriver();
	}

	
	@Test
	public void deveRealizarCadastroComSucesso(){
		page.setNome("Alex");
		page.setSobrenome("Nascimento");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		page.cadastrar();
		
		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Alex", page.obterNomeCadastro());
		Assert.assertEquals("Nascimento", page.obterSobrenomeCadastro());
		Assert.assertEquals("Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Pizza", page.obterComidaCadastro());
		Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Natacao", page.obterEsportesCadastro());
	}
	
	@Test
	public void deveValidarNomeObrigatorio(){
		page.cadastrar();		
		Assert.assertEquals("Nome eh obrigatorio",dsl.alertaObterTextoEAceita());		
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio(){		
		page.setNome("Alex");
		page.cadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSexoObrigatorio(){
		page.setNome("Alex");
		page.setSobrenome("Nascimento");
		page.cadastrar();		
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarComidaVegetariana(){
		page.setNome("Alex");
		page.setSobrenome("Nascimento");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setComidaVegetariano();
		page.cadastrar();		
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	}
	
	
	@Test
	public void deveValidarEsportistaIndeciso(){
		page.setNome("Alex");
		page.setSobrenome("Nascimento");
		page.setSexoMasculino();
		page.setComidaCarne();	
		page.setEsporte("Natacao", "O que eh esporte?");
		page.cadastrar();		
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	}
}
