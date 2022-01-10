package progressBar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObjectBase {
	protected WebDriver driver;

	protected PageObjectBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * protected progressBarPage waitProgressBar() { return
	 * PageFactory.initElements(driver, progressBarPage.class); }
	 */
}