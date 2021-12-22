package activity2.Cars;

public class CarFactory {
	public static Car buildCarWithLargeEngine(String model) {
		return new Car(model, new LargeEngine());
	}

	public static ConvertibleCar buildConvertibleCar(String model) {
		return new ConvertibleCar(model, new SmallEngine());
	}
}
