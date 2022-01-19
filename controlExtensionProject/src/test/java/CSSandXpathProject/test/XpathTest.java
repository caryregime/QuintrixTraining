package CSSandXpathProject.test;
import framework.TestBase;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CSSandXpathProject.pages.XpathPage;

public class XpathTest extends TestBase{
	private ChromeDriver driver;
	private final String url = "https://demoqa.com/";
	XpathPage xpath = new XpathPage(driver);

	@Test
	public void textbox() {
		xpath.gotoTextbox();
		String expectedtextbox = "Full Name";
		String actualtextbox = xpath.getActualTextBox();
		Assert.assertEquals(expectedtextbox, actualtextbox);
	}

	@Test
	public void buttons() {
		xpath.gotoButtons();
		boolean isClick = xpath.clickButtons();
		Assert.assertTrue(isClick);
	}

	@Test
	public void webtables(){
		xpath.gotoWebTables();
		String expectedcell = "Vega";
		String actualcell = xpath.getWebTable();
		Assert.assertEquals(expectedcell, actualcell);
	}

	@Test
	public void radiobuttons() {
		xpath.gotoRadioButtons();
		xpath.getRadioButtonAncestor();
	}

	@Test
	public void radiobuttonsSiblings() {
		xpath.gotoRadioButtons();
		xpath.getRadioButtonSiblings();
	}

	@Test
	public void clickButtons() {
		xpath.gotoButtons();
		xpath.getClickButtons();
	}

	@BeforeMethod
	public void setup() {
		super.setup();
	}

	@AfterMethod
	public void cleanup() {
		this.driver.quit();
	}
}
