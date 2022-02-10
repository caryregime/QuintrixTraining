package projectTestNg;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestNGTestRunner {

	public static void main(String[] args) {

		TestNG objTNG = new TestNG();
		List<String> suites = new ArrayList<String>();
		
		suites.add("C:\\Users\\Regime Cary\\git\\QuintrixTraining\\Automation\\testng1.xml");
		suites.add("C:\\Users\\Regime Cary\\git\\QuintrixTraining\\Automation\\testng2.xml");

		objTNG.setTestSuites(suites);
		objTNG.run();
	}

}
