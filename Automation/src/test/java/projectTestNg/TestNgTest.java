package projectTestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgTest {

	private static final String URL = "https://www.google.com/";
	private static final String URL2 = "https://www.yahoo.com/";
	WebDriver driver = null;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Regime Cary\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	//Parallel Testing
	@Test
	public void Test1() {
		System.out.println("TestNGTest Test 1 done | "+Thread.currentThread().getId() );
		driver.get(URL);
	}
	@Test
	public void Test2()  {
		System.out.println("TestNGTest Test 2 done | "+Thread.currentThread().getId());
		driver.get(URL2);
	}
	
	@AfterTest
	public void cleanup() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	
}

/*
 * BeforeSuite BeforeTest BeforeClass BeforeMethod Test AfterMethod AfterClass
 * AfterTest AfterSuite
 * 
 * BeforeSuite and AfterSuite methods would be executed only once. 
 * BeforeTest and AfterTest methods would be executed only once per test class. 
 * BeforeClass and AfterClass methods would be executed only once per class. 
 * BeforeMethod and AfterMethod methods would be executed for all @Test methods. 
 * Test method contains actual business logic of making a test pass/ fail. 
 * If the TestNG class contains more than one methods marked with @BeforeMethod
 * and @AfterMethod, then all the methods would be executed before and after
 * every @Test method.
 */
