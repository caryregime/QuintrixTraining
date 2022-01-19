package CSSandXpathProject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class XpathPage extends PageObjectBase{

	public XpathPage(WebDriver driver) {
		super(driver);
	}

	public void gotoElements() {
		driver.findElement(By.xpath("//div[@class=\"card-body\"]//h5[normalize-space(text())=\"Elements\"]")).click();
	}

	public void gotoTextbox() {
		gotoElements();
		driver.findElement(By.xpath("//li[@class=\"btn btn-light \"]//span[normalize-space(text())=\"Text Box\"]")).click();
	}

	public void gotoButtons() {
		gotoElements();
		driver.findElement(By.xpath("//li[@class=\"btn btn-light \"]//span[normalize-space(text())=\"Buttons\"]")).click();
	}

	public void gotoWebTables() {
		gotoElements();
		driver.findElement(By.xpath("//li[@class=\"btn btn-light \"]//span[normalize-space(text())=\"Web Tables\"]")).click();
	}

	public void gotoRadioButtons() {
		gotoElements();
		driver.findElement(By.xpath("//*[@id=\"item-2\"]//span[normalize-space(text())=\"Radio Button\"]")).click();
	}

	public String getActualTextBox() {
		String actualtextbox = driver.findElement(By.xpath("//*[@id=\"userName\"]")).getAttribute("placeholder");
		return actualtextbox;
	}

	public boolean clickButtons() {
		driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"]")).click();
		return true;
	}

	public String getWebTable() {
		String actualcell = driver.findElement(By.xpath("//div[@class=\"rt-tr -odd\"]//div[normalize-space(text())=\"Vega\"]")).getText();
		return actualcell;
	}

	public void getRadioButtonAncestor() {
		List <WebElement> divAncestor = driver.findElements(By.xpath("//*[@id=\"impressiveRadio\"]/ancestor::div"));
		for (WebElement webElement : divAncestor) {
			System.out.println(webElement.getText());
		}
	}

	public void getRadioButtonSiblings() {
		List <WebElement> divSiblings = driver.findElements(By.xpath("//*[@id=\"impressiveRadio\"]/following-sibling::div"));
		for (WebElement webElement : divSiblings) {
			System.out.println(webElement.getText());
		}
		
	}

	public void getClickButtons() {
		List <WebElement> btnWithClick = driver.findElements(By.xpath("//div[@class=\"col-12 mt-4 col-md-6\"]//button[contains(text(),'Click')]"));
		for (WebElement webElement : btnWithClick) {
			System.out.println(webElement.getText());
		}
	}
	
}
