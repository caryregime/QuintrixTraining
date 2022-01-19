package controlExtension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.LinkControl;
import framework.PageObjectBase;

public class LinkPage extends PageObjectBase{
	private static final String URL = "https://demoqa.com/links";
	@FindBy(how = How.ID, using = "no-content")
	private WebElement linknocontent;
	@FindBy(how = How.ID, using = "linkResponse")
	private WebElement linkresponse;

	protected LinkPage(WebDriver driver) {
		super(driver);
	}

	public LinkPage navigate() {
		this.driver.get(URL);
		return this;
	}

	public LinkPage click(String link) {
		new LinkControl(linknocontent).click();
		return this;
	}

	public String isClicked() {
		String actualResponse = new LinkControl(linkresponse).isClicked();
		return actualResponse;
	}

}
