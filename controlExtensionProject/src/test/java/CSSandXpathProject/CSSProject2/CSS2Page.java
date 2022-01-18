package CSSandXpathProject.CSSProject2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class CSS2Page extends PageObjectBase{
	private String url = "https://demoqa.com/";
	
	protected CSS2Page(WebDriver driver) {
		super(driver);
	}

	public void gotoURL() {
		this.driver.navigate().to(url);
	}
	
	public void gotoElements() {
		gotoURL();
		driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(1)")).click();
	}

	public void gotoWidgets() {
		gotoURL();
		driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(4) > div > div.avatar.mx-auto.white > svg")).click();
	}
	
	public void gotoTextbox() {
		gotoElements();
		driver.findElement(By.cssSelector("#item-0 > span")).click();
	}

	public void gotoButtons() {
		gotoElements();
		driver.findElement(By.cssSelector("#item-4 > span")).click();
	}

	public void gotoMenu() {
		gotoWidgets();
		driver.findElement(By.xpath("#item-7 > span")).click();
	}

	public void gotoSelectMenu() {
		gotoWidgets();
		driver.findElement(By.xpath("#item-8 > span")).click();
	}

	public void gotoSlider() {
		gotoWidgets();
		driver.findElement(By.xpath("#item-8 > span")).click();
	}
}
