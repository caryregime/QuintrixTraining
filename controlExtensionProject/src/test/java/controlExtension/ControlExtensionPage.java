package controlExtension;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ControlExtensionPage{

	private WebElement element;

	public ControlExtensionPage(WebElement element) {
		this.element = element;
	}

	public void select() {
		this.element.click();
	}

	public void getSelected() {
		String btn_selected = this.element.getText();
		System.out.println(btn_selected);
	}

	public void click() {
		this.element.click();
	}

	public String isClicked() {
		return this.element.getText();
	}

	public void setValue(String string) {
		this.element.sendKeys("value", string);
	}

	public String getValue() {
		String value = this.element.getAttribute("value");
		System.out.println(value);
		return null;
	}
}
