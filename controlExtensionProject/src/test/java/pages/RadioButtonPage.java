package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.ButtonControl;
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

	public RadioButtonPage(WebDriver driver) {
		super(driver);
	}

	public RadioButtonPage navigate() {
		this.driver.get(URL);
		return this;
	}

	public RadioButtonPage select_yes(String btn) {
		new ButtonControl(btnYes).select_yes(btn);
		return this;
	}
	public RadioButtonPage select_no(String btn) {
		new ButtonControl(btnNo).select_no(btn);
		return this;
	}
	public RadioButtonPage select_impressive(String btn) {
		new ButtonControl(btnImpressive).select_impressive(btn);
		return this;
	}

	public void getSelected() {
		new ButtonControl(btnselected).getSelected();
	}
}
