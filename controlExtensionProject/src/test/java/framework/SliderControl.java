package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SliderControl{

	private WebElement element;
	private WebDriver driver;

	public SliderControl(WebElement element, WebDriver driver) {
		this.element = element;
		this.driver = driver;
	}

	public void setValue(String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:document.querySelector('input').value = " + value);
		js.executeScript("javascript:document.querySelector('input#sliderValue').value = " + value);
		String actualValue = getValue();
		if (!actualValue.equals(value)) {
			throw new RuntimeException("The value '" + value + "' was not set.");
		}
	}

	public String getValue() {
		return this.element.getAttribute("value");
	}

}
