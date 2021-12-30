package activity1.Cars;

import org.testng.Assert;
import org.testng.annotations.Test;
	public class CarTest{	
		@Test
		public void canBuildCar() {
			Car car = new Car("Corvette");
			car.start();
			Assert.assertTrue(car != null);
		}
}
