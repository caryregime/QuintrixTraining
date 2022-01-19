package CSSandXpathProject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class CssSelectorPage extends PageObjectBase{
	private String url = "https://demoqa.com/";
	
	public CssSelectorPage(WebDriver driver) {
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

	public String getActualTextbox() {
		String actualtextbox = driver.findElement(By.cssSelector("input#userName")).getAttribute("placeholder");
		return actualtextbox;
	}

	public boolean clickButton() {
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		return true;
	}

	public String getActualFooter() {
		String actualfooter = driver.findElement(By.cssSelector("footer > span")).getText();
		return actualfooter;
	}

	public void getMenu() {
		List <WebElement> menu_item = driver.findElements(By.cssSelector("ul#nav > li > a[href^=\"#\"]"));
		for (WebElement webElement : menu_item) {
			System.out.println(webElement.getText());
		}
	}

	public String getActualMenu() {
		String actualselect = driver.findElement(By.cssSelector("select#oldSelectMenu > option[value=\"4\"]")).getText();
		return actualselect;
	}

	public String getSliderValue() {
		String actualslider = driver.findElement(By.cssSelector("input#sliderValue")).getText();
		return actualslider;
	}

	public void setTextBox(String expectedtextbox) {
		driver.findElement(By.cssSelector("input#userName")).sendKeys("expectedtextbox");
	}

	public String getTextbox() {
		String actualtextbox = driver.findElement(By.cssSelector("input#userName")).getText();
		return actualtextbox;
	}
}
