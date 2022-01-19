package framework;

import org.openqa.selenium.WebElement;

public class LinkControl {
private WebElement element;
	
	public LinkControl(WebElement element) {
		this.element = element;
	}
	
	public void click() {
		this.element.click();
	}
	
	public String isClicked() {
		return this.element.getText();
	}
}
