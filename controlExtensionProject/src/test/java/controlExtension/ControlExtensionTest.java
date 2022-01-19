package controlExtension;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.TestBase;


public class ControlExtensionTest extends TestBase{

	@Test
	private void radiobutton_yes() {
		new RadioButtonPage(getDriver())
		.navigate()
		.select_yes("Yes")
		.getSelected();
	}

	@Test
	private void radiobutton_impressive() {
		new RadioButtonPage(getDriver())
		.navigate()
		.select_impressive("Impressive")
		.getSelected();
	}

	@Test
	private void radiobutton_no() {
		new RadioButtonPage(getDriver())
		.navigate()
		.select_no("No")
		.getSelected();
	}

	@Test
	private void link() {
		String expectedResponse = "Link has responded with staus 204 and status text No Content";
		LinkPage link = new LinkPage(getDriver())
				.navigate()
				.click("No Content");
		String actualResponse = link.isClicked();
		Assert.assertEquals(expectedResponse,actualResponse);
	}

	@Test
	private void slider() {
		String[] values = { "80", "17", "0", "100" };
		String expectedResultText;
		String resultSliderValue;

		for (String value : values) {
			expectedResultText = value;
			resultSliderValue = new SliderPage(this.getDriver())
					.navigate()
					.setValue(value)
					.getValue();

			Assert.assertEquals(resultSliderValue, expectedResultText,
					"the slider value " + expectedResultText + " was not set");

		}
	}

	@Test
	private void select_menu() {
		String expectedcolor = "White";
		SelectMenuPage selectmenu = new SelectMenuPage(getDriver())
				.navigate()
				.setValue(expectedcolor);
		String actualcolor = selectmenu.getValue();
		Assert.assertEquals(expectedcolor, actualcolor);
	}

	@Test
	private void select_menu_options() {
		new SelectMenuPage(getDriver())
		.navigate()
		.getOptions();
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
