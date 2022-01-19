package activity2.Cars;

public class ConvertibleCar extends Car {

	private boolean isTopDown;

	public ConvertibleCar(String model, IEngine engine) {
		super(model, engine);
	}

	public boolean isTopDown() {
		return this.isTopDown;
	}

	public void lowerTop() {
		this.isTopDown = true;		
	}
}