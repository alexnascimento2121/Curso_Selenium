package br.com.teste;
import static br.com.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.core.BaseTeste;
import br.com.page.CampoTreinamentoPage_SemDSL;

public class TestCadastroComDSL extends BaseTeste{
	
	private CampoTreinamentoPage_SemDSL page;
	
	@Before
	public void inicializa() {	
		getDriver().get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");		
		page = new CampoTreinamentoPage_SemDSL();
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
		Assert.assertEquals("Alex",page.obterNomeCadastro());
		Assert.assertEquals("Nascimento", page.obterSobrenomeCadastro());
		Assert.assertEquals("Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Pizza", page.obterComidaCadastro());
		Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Natacao", page.obterEsportesCadastro());
	}
}
