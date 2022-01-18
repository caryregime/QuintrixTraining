package CSSandXpathProject.CSSProject2;
import framework.TestBase;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CSS2 extends TestBase{
	private ChromeDriver driver;
	CSS2Page css2 = new CSS2Page(driver);

	@Test
	public void textbox() {
		String expectedtextbox = "Full Name";
		css2.gotoTextbox();
		String actualtextbox = driver.findElement(By.cssSelector("input#userName")).getAttribute("placeholder");
		Assert.assertEquals(expectedtextbox, actualtextbox);
	}

	@Test
	public void buttons() {
		css2.gotoButtons();
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		Assert.assertTrue(true, "buttons");
	}

	@Test
	public void buttonfooter(){
		String expectedfooter = "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";
		css2.gotoButtons();
		String actualfooter = driver.findElement(By.cssSelector("footer > span")).getText();
		Assert.assertEquals(expectedfooter, actualfooter);
	}

	@Test
	public void menu() {
		css2.gotoMenu();
		List <WebElement> menu_item = driver.findElements(By.cssSelector("ul#nav > li > a[href^=\"#\"]"));
		for (WebElement webElement : menu_item) {
			System.out.println(webElement.getText());
		}
	}

	@Test
	public void select_menu() {
		String expectedselect = "Purple";
		css2.gotoSelectMenu();
		String actualselect = driver.findElement(By.cssSelector("select#oldSelectMenu > option[value=\"4\"]")).getText();
		Assert.assertEquals(expectedselect, actualselect);
	}

	@Test
	public void slider() {
		String expectedslider = "25";
		css2.gotoSlider();
		String actualslider = driver.findElement(By.cssSelector("input#sliderValue")).getText();
		Assert.assertEquals(expectedslider, actualslider);
	}

	@Test
	public void settextbox() {
		String expectedtextbox = "ABC";
		css2.gotoTextbox();
		driver.findElement(By.cssSelector("input#userName")).sendKeys("expectedtextbox");
		String actualtextbox = driver.findElement(By.cssSelector("input#userName")).getText();
		Assert.assertEquals(expectedtextbox, actualtextbox);
	}

	@BeforeMethod
	public void setup() {
		super.setup();
		/*
		 * String os = System.getProperty("os.name").toLowerCase();
		 * if(os.contains("win")) { System.setProperty("webdriver.chrome.driver",
		 * System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe"); }
		 * else if(os.contains("mac")) { System.setProperty("webdriver.chrome.driver",
		 * System.getProperty("user.dir") + "/src/test/resources/chromedriver"); }
		 * this.driver = new ChromeDriver(); this.driver.manage().window().maximize();
		 * this.driver.navigate().to(url);
		 */
	}

	@AfterMethod
	public void cleanup() {
		super.cleanup();
	}
}
