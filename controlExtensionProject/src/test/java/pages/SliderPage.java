package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.PageObjectBase;
import framework.SliderControl;

public class SliderPage extends PageObjectBase{

	private static final String URL = "https://demoqa.com/slider";

	@FindBy(how = How.ID, using = "sliderValue")
	private WebElement slidervalue;

	@FindBy(how = How.CSS, using = "input[type='range']")
	private WebElement sliderElement;
	
	public SliderPage(WebDriver driver) {
		super(driver);
	}

	public SliderPage navigate() {
		this.driver.get(URL);
		return this;
	}

	public SliderPage setValue(String value) {
		new SliderControl(sliderElement, driver).setValue(value);
		return this;
	}

	public String getValue() {
		return slidervalue.getAttribute("value");
	}
}
