package projectTestNg;

import org.testng.annotations.Test;

public class TestNgTest {

	@Test
	public void Test1() {
		System.out.println("Test 1 done | "+Thread.currentThread().getId() );
	}
	@Test
	public void Test2() {
		System.out.println("Test 2 done | "+Thread.currentThread().getId());
	}
}
