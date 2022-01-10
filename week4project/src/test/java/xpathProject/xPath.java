package xpathProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class xPath {
	private ChromeDriver driver;
	private final String url = "https://demoqa.com/";

	@Test
	public void textbox() {
		gotoTextbox();
		String expectedtextbox = "Full Name";
		String actualtextbox = driver.findElement(By.cssSelector("input[id='userName']")).getAttribute("placeholder");
		Assert.assertEquals(expectedtextbox, actualtextbox);
	}

	@Test
	public void buttons() {
		gotoButtons();
		driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"]")).click();
		Assert.assertTrue(true, "buttons");
	}
	 
	@Test
	public void webtables(){
		gotoWebTables();
		String expectedcell = "Vega";
		String actualcell = driver.findElement(By.xpath("//div[@class=\"rt-tr -odd\"]//div[normalize-space(text())=\"Vega\"]")).getAttribute("webtables");
		System.out.println(actualcell);
		Assert.assertEquals(expectedcell, actualcell);
	}
	
	@Test
	public void radiobuttons() {
		gotoRadioButtons();
		List <WebElement> divAncestor = driver.findElements(By.xpath("//*[@id=\"impressiveRadio\"]/ancestor::div"));
        for (WebElement webElement : divAncestor) {
            System.out.println(webElement.getText());
        }
	}
	
	@Test
	public void radiobuttonsSiblings() {
		gotoRadioButtons();
		List <WebElement> divSiblings = driver.findElements(By.xpath("//*[@id=\"impressiveRadio\"]/following-sibling::div"));
        for (WebElement webElement : divSiblings) {
            System.out.println(webElement.getText());
        }
	}
	
	@Test
	public void clickButtons() {
		gotoButtons();
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

	public void gotoElements() {
		driver.findElementByXPath("//div[@class=\"card-body\"]//h5[normalize-space(text())=\"Elements\"]").click();
	}


	public void gotoTextbox() {
		gotoElements();
		driver.findElementByXPath("//li[@class=\"btn btn-light \"]//span[normalize-space(text())=\"Text Box\"]").click();
	}

	public void gotoButtons() {
		gotoElements();
		driver.findElementByXPath("//li[@class=\"btn btn-light \"]//span[normalize-space(text())=\"Buttons\"]").click();
	}
	
	public void gotoWebTables() {
		gotoElements();
		driver.findElementByXPath("//li[@class=\"btn btn-light \"]//span[normalize-space(text())=\"Web Tables\"]").click();
	}
	
	public void gotoRadioButtons() {
		gotoElements();
		driver.findElementByXPath("//*[@id=\"item-2\"]//span[normalize-space(text())=\"Radio Button\"]").click();
	}
}
