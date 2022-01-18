package CSSandXpathProject.xpathProject;
import framework.TestBase;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XPath extends TestBase{
	private ChromeDriver driver;
	private final String url = "https://demoqa.com/";
	XPathPage xpath = new XPathPage(driver);
	@Test
	public void textbox() {
		xpath.gotoTextbox();
		String expectedtextbox = "Full Name";
		String actualtextbox = driver.findElement(By.xpath("//*[@id=\"userName\"]")).getAttribute("placeholder");
		Assert.assertEquals(expectedtextbox, actualtextbox);
	}

	@Test
	public void buttons() {
		xpath.gotoButtons();
		driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"]")).click();
		Assert.assertTrue(true, "buttons");
	}

	@Test
	public void webtables(){
		xpath.gotoWebTables();
		String expectedcell = "Vega";
		String actualcell = driver.findElement(By.xpath("//div[@class=\"rt-tr -odd\"]//div[normalize-space(text())=\"Vega\"]")).getText();
		System.out.println(actualcell);
		Assert.assertEquals(expectedcell, actualcell);
	}

	@Test
	public void radiobuttons() {
		xpath.gotoRadioButtons();
		List <WebElement> divAncestor = driver.findElements(By.xpath("//*[@id=\"impressiveRadio\"]/ancestor::div"));
		for (WebElement webElement : divAncestor) {
			System.out.println(webElement.getText());
		}
	}

	@Test
	public void radiobuttonsSiblings() {
		xpath.gotoRadioButtons();
		List <WebElement> divSiblings = driver.findElements(By.xpath("//*[@id=\"impressiveRadio\"]/following-sibling::div"));
		for (WebElement webElement : divSiblings) {
			System.out.println(webElement.getText());
		}
	}

	@Test
	public void clickButtons() {
		xpath.gotoButtons();
		List <WebElement> btnWithClick = driver.findElements(By.xpath("//div[@class=\"col-12 mt-4 col-md-6\"]//button[contains(text(),'Click')]"));
		for (WebElement webElement : btnWithClick) {
			System.out.println(webElement.getText());
		}
	}

	@BeforeMethod
	public void setup() {
		String os = System.getProperty("os.name").toLowerCase();
		if(os.contains("win")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
		}
		else if(os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");
		}
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.navigate().to(url);
	}

	@AfterMethod
	public void cleanup() {
		this.driver.quit();
	}
}
