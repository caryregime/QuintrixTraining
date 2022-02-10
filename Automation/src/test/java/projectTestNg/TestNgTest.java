package projectTestNg;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNgTest {

	WebDriver driver = null;
	
	@Test
	public void Test1() {
		System.out.println("Test 1 done | "+Thread.currentThread().getId() );
		System.setProperty("webdriver.chrome.driver", driverFile.toFile().getAbsolutePath());
		driver = new ChromeDriver();
	}
	@Test
	public void Test2() {
		System.out.println("Test 2 done | "+Thread.currentThread().getId());
	}
}
