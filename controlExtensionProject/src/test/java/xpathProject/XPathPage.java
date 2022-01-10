package xpathProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class XPathPage extends PageObjectBase{
	
	protected XPathPage(WebDriver driver) {
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
}
