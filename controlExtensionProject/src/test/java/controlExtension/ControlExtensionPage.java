package controlExtension;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

	public void setValueDropDown(String string, WebElement selectmenu) {
		Select option = new Select(selectmenu);
		option.selectByVisibleText(string);
	}

	public String getValueDropDown(WebElement selectmenu) {
		Select option = new Select(selectmenu);
		return option.getFirstSelectedOption().getText();
	}

	public void getOptions(List<WebElement> selectmenu) {
		for(int i=0;i<selectmenu.size();i++){
			System.out.println(selectmenu.get(i).getText());
		}
	}
}
