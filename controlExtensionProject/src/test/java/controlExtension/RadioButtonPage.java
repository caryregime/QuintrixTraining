package controlExtension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.PageObjectBase;

public class RadioButtonPage extends PageObjectBase{
	private String URL = "https://demoqa.com/radio-button";

	@FindBy(how = How.ID, using = "yesRadio")
	private WebElement btnYes;
	@FindBy(how = How.ID, using = "impressiveRadio")
	private WebElement btnImpressive;
	@FindBy(how = How.ID, using = "noRadio")
	private WebElement btnNo;
	@FindBy(how = How.XPATH, using = "//p[@class='mt-3']")
	private WebElement btnselected;

	protected RadioButtonPage(WebDriver driver) {
		super(driver);
	}

	public RadioButtonPage navigate() {
		this.driver.get(URL);
		return this;
	}

	public void select(String btn) {
		if(btn == "Yes") {
			new ControlExtensionPage(btnYes).select();
		}
		else if(btn == "Impressive") {
			new ControlExtensionPage(btnImpressive).select();
		}
		else if(btn == "No") {
			new ControlExtensionPage(btnNo).select();
		}
	}

	public void getSelected() {
		new ControlExtensionPage(btnselected).getSelected();
	}
}
