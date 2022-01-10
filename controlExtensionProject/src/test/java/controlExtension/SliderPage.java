package controlExtension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.PageObjectBase;

public class SliderPage extends PageObjectBase{

	private static final String URL = "https://demoqa.com/slider";

	@FindBy(how = How.ID, using = "sliderValue")
	private WebElement slidervalue;
	
	protected SliderPage(WebDriver driver) {
		super(driver);
	}

	public SliderPage navigate() {
		this.driver.get(URL);
		return this;
	}

	public void setValue(String string) {
		new ControlExtensionPage(slidervalue).setValue(string);
	}

	public String getValue() {
		return new ControlExtensionPage(slidervalue).getValue();
	}
}
