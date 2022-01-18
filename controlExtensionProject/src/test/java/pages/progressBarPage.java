package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class progressBarPage extends PageObjectBase{
	private String URL = "https://demoqa.com/progress-bar";
	WebDriverWait wait=new WebDriverWait(driver,20);

	@FindBy(how=How.ID, using="startStopButton")
	private WebElement StartButton;
	
	public progressBarPage(WebDriver driver) {
		super(driver);
	}

	public progressBarPage gotoProgressBar() {
		this.driver.navigate().to(URL);
		return this;
		}
	
	public progressBarPage startProgressBar() {
		StartButton.click();
		return this;
	}

	public boolean isStartedProgressBar() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resetButton")));
		return element.isDisplayed();
	}
}
