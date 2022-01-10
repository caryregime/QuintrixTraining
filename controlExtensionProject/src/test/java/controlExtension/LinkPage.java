package controlExtension;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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

	public void click(String link) {
		new ControlExtensionPage(linknocontent).click();
	}

	public void isClicked() {
		String expectedResponse = "Link has responded with staus 204 and status text No Content";
		String actualResponse = new ControlExtensionPage(linkresponse).isClicked();
		Assert.assertEquals(expectedResponse,actualResponse);
	}

}
