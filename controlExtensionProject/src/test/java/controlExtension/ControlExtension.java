package controlExtension;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.TestBase;

public class ControlExtension extends TestBase{

	@Test
	private void radiobutton_yes() {
		RadioButtonPage radioButton = new RadioButtonPage(getDriver()).navigate();
		radioButton.select("Yes");
		radioButton.getSelected();
	}
	
	@Test
	private void radiobutton_impressive() {
		RadioButtonPage radioButton = new RadioButtonPage(getDriver()).navigate();
		radioButton.select("Impressive");
		radioButton.getSelected();
	}
	
	@Test
	private void radiobutton_no() {
		RadioButtonPage radioButton = new RadioButtonPage(getDriver()).navigate();
		radioButton.select("No");
		radioButton.getSelected();
	}
	
	@Test
	private void link() {
		LinkPage link = new LinkPage(getDriver()).navigate();
		link.click("No Content");
		link.isClicked();
	}
	
	@Test
	private void slider80() {
		String expectedvalue = "80";
		SliderPage sliderpage = new SliderPage(getDriver()).navigate();
		sliderpage.setValue(expectedvalue);
		sliderpage.getValue();
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
