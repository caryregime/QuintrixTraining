package framework;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectMenuControl {
	private WebElement element;

	public SelectMenuControl(WebElement element) {
		this.element = element;
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
