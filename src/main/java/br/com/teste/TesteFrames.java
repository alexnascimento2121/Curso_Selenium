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

public class TesteFrames {
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
//	public void deveInteragirComFrames(){
//		dsl.entrarFrame("frame1");
//		dsl.clicarBotao("frameButton");
//		String msg = dsl.alertaObterTextoEAceita();
//		Assert.assertEquals("Frame OK!", msg);
//
//		dsl.sairFrame();
//		dsl.escrever("elementosForm:nome", msg);
//	}
//	
//	@Test
//	public void deveInteragirComFrameEscondido(){
//		WebElement frame = getDriver().findElement(By.id("frame2"));
//		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
//		dsl.entrarFrame("frame2");
//		dsl.clicarBotao("frameButton");
//		String msg = dsl.alertaObterTextoEAceita();
//		Assert.assertEquals("Frame OK!", msg);
//	}
//	
//	@Test
//	public void deveInteragirComJanelas(){
//		dsl.clicarBotao("buttonPopUpEasy");
//		dsl.trocarJanela("Popup");
//		dsl.escrever(By.tagName("textarea"), "Deu certo?");
//		getDriver().close();
//		dsl.trocarJanela("");
//		dsl.escrever(By.tagName("textarea"), "e agora?");
//	}
//	
//	@Test
//	public void deveInteragirComJanelasSemTitulo(){
//		dsl.clicarBotao("buttonPopUpHard");
//		System.out.println(getDriver().getWindowHandle());
//		System.out.println(getDriver().getWindowHandles());
//		dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[1]);
//		dsl.escrever(By.tagName("textarea"), "Deu certo?");
//		dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[0]);
//		dsl.escrever(By.tagName("textarea"), "e agora?");
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
	public void deveInteragirComFrames(){
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert =driver.switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		alert.accept();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);		
	}
	
	@Test
	public void deveInteragirComJanelas(){		
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");		
		driver.close();
		driver.switchTo().window("");
		driver.findElement(By.tagName("textarea")).sendKeys("e agora?");
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo(){		
		driver.findElement(By.id("buttonPopUpHard")).click();		
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("e agora?");
	}
}
