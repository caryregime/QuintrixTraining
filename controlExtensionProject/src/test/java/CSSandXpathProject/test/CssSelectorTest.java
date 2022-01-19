package CSSandXpathProject.test;
import framework.TestBase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CSSandXpathProject.pages.CssSelectorPage;

public class CssSelectorTest extends TestBase{
	private ChromeDriver driver;
	CssSelectorPage css2 = new CssSelectorPage(driver);

	@Test
	public void textbox() {
		String expectedtextbox = "Full Name";
		css2.gotoTextbox();
		String actualtextbox = css2.getActualTextbox();
		Assert.assertEquals(expectedtextbox, actualtextbox);
	}

	@Test
	public void buttons() {
		css2.gotoButtons();
		boolean isClick = css2.clickButton();
		Assert.assertTrue(isClick);
	}

	@Test
	public void buttonfooter(){
		String expectedfooter = "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";
		css2.gotoButtons();
		String actualfooter = css2.getActualFooter();
		Assert.assertEquals(expectedfooter, actualfooter);
	}

	@Test
	public void menu() {
		css2.gotoMenu();
		css2.getMenu();
	}

	@Test
	public void select_menu() {
		String expectedselect = "Purple";
		css2.gotoSelectMenu();
		String actualselect = css2.getActualMenu();
		Assert.assertEquals(expectedselect, actualselect);
	}

	@Test
	public void slider() {
		String expectedslider = "25";
		css2.gotoSlider();
		String actualslider = css2.getSliderValue();
		Assert.assertEquals(expectedslider, actualslider);
	}

	@Test
	public void settextbox() {
		String expectedtextbox = "ABC";
		css2.gotoTextbox();
		css2.setTextBox(expectedtextbox);
		String actualtextbox = css2.getTextbox();
		Assert.assertEquals(expectedtextbox, actualtextbox);
	}

	@BeforeMethod
	public void setup() {
		super.setup();
	}

	@AfterMethod
	public void cleanup() {
		super.cleanup();
	}
}
