package controlExtension;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.PageObjectBase;

public class SelectMenuPage extends PageObjectBase{

	private static final String URL = "https://demoqa.com/select-menu";
	@FindBy(how = How.ID, using = "oldSelectMenu")
	private WebElement selectmenu;
	
	@FindBy(how = How.ID, using = "oldSelectMenu")
	private List<WebElement> selectoptions;
	
	public SelectMenuPage(WebDriver driver) {
		super(driver);
	}

	public SelectMenuPage navigate() {
		this.driver.get(URL);
		return this;
	}

	public void setValue(String color) {
		new ControlExtensionPage(selectmenu).setValueDropDown(color, selectmenu);
	}

	public String getValue() {
		return new ControlExtensionPage(selectmenu).getValueDropDown(selectmenu);
	}

	public void getOptions() {
		new ControlExtensionPage(selectmenu).getOptions(selectoptions);
		
	}

}
