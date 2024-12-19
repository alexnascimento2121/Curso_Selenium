package br.com.teste;
import static br.com.core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.com.core.BaseTeste;
import br.com.core.DSL_Core;
import br.com.page.CampoTreinamentoPage_SemDSL;

@RunWith(Parameterized.class)
public class TesteRegrasCadastroComDSL extends BaseTeste{

	private CampoTreinamentoPage_SemDSL page;
	private DSL_Core dsl;
	
	@Parameter // são usado dentro da collection para repassar os dados para teste
	public String nome;
	@Parameter(value=1)// vao conforme a numeracao, começando com 0 do que nao tem numero
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String msg;
	
	@Before
	public void inicializa() {		
		getDriver().get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");		
		dsl= new DSL_Core();
		page = new CampoTreinamentoPage_SemDSL();
	}
	
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
			{"Alex", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
			{"Alex", "Nascimento", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
			{"Alex", "Nascimento", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
			{"Alex", "Nascimento", "Masculino", Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"}
		});
	}
	
	@Test
	public void deveValidarRegras(){
		page.setNome(nome);
		page.setSobrenome(sobrenome);
		if(sexo.equals("Masculino")) {
			page.setSexoMasculino();
		} 
		if(sexo.equals("Feminino")) {
			page.setSexoFeminino();
		}
		if(comidas.contains("Carne")) page.setComidaCarne(); 
		if(comidas.contains("Pizza")) page.setComidaPizza(); 
		if(comidas.contains("Vegetariano")) page.setComidaVegetariano(); 
		page.setEsporte(esportes);
		page.cadastrar();
		System.out.println(msg);
		Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());
	}
}
