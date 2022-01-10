package progressBar;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.TestBase;

public class progressBar extends TestBase{

	@Test
	public void loadprogressBar() {
		progressBarPage progress = new progressBarPage(getDriver());
		super.gotoProgressBar();
		progress.startProgressBar();
		progress.resetProgressBar();
		Assert.assertTrue(progress.resetProgressBar());
		System.out.println("Progress Bar is done");
	}

	@BeforeMethod
	public void setup() {
		super.setup();
	}

	@AfterMethod
	public void cleanup() {
		super.cleanup();
	}
}
