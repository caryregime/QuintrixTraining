package activity2.Cars;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class CarTests {

	@Test
	public void canBuildCar() {
		String model = "Corvette";
		
		Car car = CarFactory.buildCarWithLargeEngine(model);

		canStartCar(car);
	}
	
	@Test
	public void canDriveBicycle() {
		Bicycle bike = new Bicycle();
		canDriveVehicle(bike);
	}
	
	@Test
	public void canDriveCar() {
		Car car = new Car("Corvette", new LargeEngine());
		canDriveVehicle(car);
	}

	@Test
	public void enginesHaveTheCorrectEngineSize() {
		int smallEngineCylinderCount = 4;
		int largeEngineCylinderCount = 8;
		
		SmallEngine smallEngine = new SmallEngine();
		LargeEngine largeEngine = new LargeEngine();
		
		int actualSmallEngineCylinderCount = smallEngine.getCylinderCount();
		int actualLargeEngineCylinderCount = largeEngine.getCylinderCount();
		
		AssertJUnit.assertTrue("cylinder counts should match as expected.", smallEngineCylinderCount == actualSmallEngineCylinderCount);
		AssertJUnit.assertTrue("cylinder counts should match as expected.", largeEngineCylinderCount == actualLargeEngineCylinderCount);
	}
	
	@Test
	public void canBuildConvertibleCar() {
		String model = "Miata";
	
		ConvertibleCar convertibleCar = CarFactory.buildConvertibleCar(model);

		canStartCar(convertibleCar);
	}
	
	@Test
	public void canLowerAndRaiseConvertibleTop() {
		String model = "Miata";
		boolean isTopDown = false;
		
		ConvertibleCar convertible = new ConvertibleCar(model, new SmallEngine());
		isTopDown = convertible.isTopDown();
		
		AssertJUnit.assertFalse("the default position of top is up.", isTopDown);
		
		convertible.lowerTop();
		isTopDown = convertible.isTopDown();

		AssertJUnit.assertTrue("the top should be lowered.", isTopDown);
	}
	
	private void canStartCar(Car car) {
		car.Start();
		
		AssertJUnit.assertTrue(car != null);
	}
	
	private void canDriveVehicle(Vehicle vehicle) {
		int distance = 1;
		
		int odometerBefore = vehicle.getOdometer();
		vehicle.drive(distance);
		int expectedOdometer = odometerBefore + distance;
		int actualOdometer = vehicle.getOdometer();
		
		AssertJUnit.assertEquals("the odometer should be incremented by the distance.", expectedOdometer, actualOdometer);
	}
}