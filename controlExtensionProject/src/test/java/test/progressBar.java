package test;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.TestBase;
import pages.progressBarPage;

public class progressBar extends TestBase{

	@Test
	public void loadprogressBar() {
		progressBarPage progress = new progressBarPage(getDriver())
				.gotoProgressBar()
				.startProgressBar();
		Assert.assertTrue(progress.isStartedProgressBar());
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