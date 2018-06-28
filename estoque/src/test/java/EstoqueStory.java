import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EstoqueStory
{

	static WebDriver driver;

	WebElement quant, valoruni, total;

	@Given("estou na lista de compras")
	public void naListaDeCompras()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("lista-compras.html");
	}

	@When("informo que adquiri 38 unidades")
	public void informaUnidades(int units)
	{
		quant = driver.findElement(By.id("quantidade"));
		quant.sendKeys(String.valueOf(units));
	}

	@When("informo que custo por unidade foi de 5 reais")
	public void informaCusto(int reais)
	{
		valoruni = driver.findElement(By.id("valorUnitario"));
		valoruni.sendKeys(String.valueOf(reais));
		valoruni.sendKeys(Keys.ENTER);
	}

	@Then("o valor total apresentado sera de 190 reais")
	public void verificaValorApresentado(String reais)
	{
		total = driver.findElement(By.id("valorTotal"));
		Assert.assertEquals(reais, total.getAttribute("value"));

	}

}