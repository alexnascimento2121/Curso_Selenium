package br.com.suite;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.core.DriverFactory;
import br.com.teste.TestCadastroComDSL;
import br.com.teste.TesteCampoTreinamentoComDSL;
import br.com.teste.TesteRegrasCadastroComDSL;

@RunWith(Suite.class)
@SuiteClasses({
	TestCadastroComDSL.class,
	TesteRegrasCadastroComDSL.class,
	TesteCampoTreinamentoComDSL.class
})
public class SuiteTeste {
	@AfterClass
	public static void finalizaTudo(){
		DriverFactory.killDriver();
	}

}
