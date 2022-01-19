package framework;

import org.openqa.selenium.WebElement;

public class ButtonControl {
	private WebElement element;
	
	public ButtonControl(WebElement element) {
		this.element = element;
	}
	
	public void select_yes(String btn) {
		this.element.click();
	}
	
	public void select_no(String btn) {
		this.element.click();
	}

	public void select_impressive(String btn) {
		this.element.click();
	}
	
	public void getSelected() {
		String btn_selected = this.element.getText();
		System.out.println(btn_selected);
	}
}
