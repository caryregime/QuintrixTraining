package progressBar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.util.Assert;

public class progressBarPage extends PageObjectBase{
	WebDriverWait wait=new WebDriverWait(driver,20);

	protected progressBarPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.ID, using="startStopButton")
	private WebElement StartButton;

	/*
	 * @FindBy(how=How.ID, using="resetButton") private WebElement ResetButton;
	 */
	public void startProgressBar() {
		driver.findElement(By.id("startStopButton")).click();
	}

	public boolean resetProgressBar() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resetButton")));
		return element.isDisplayed();
	}


}
