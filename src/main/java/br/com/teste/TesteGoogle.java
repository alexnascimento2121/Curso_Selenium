package br.com.teste;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
//	private WebDriver driver;
//
//	@Before
//	public void inicializa(){
//		driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension(1200, 765));
//	}
//	
//	@After
//	public void finaliza(){
//		driver.quit();
//	}
//	
	@Test
	public void teste() {
//		System.setProperty("webdriver.chrome.driver", "/Users/wcaquino/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		//driver.get("http://www.google.com");
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.manage().window().setSize(new Dimension(1200, 765));
		//driver.manage().window().maximize(); maximiza janela
		//System.out.println(driver.getTitle());
		//Assert.assertEquals("Google", driver.getTitle());
		//driver.quit();
	}
	

}
