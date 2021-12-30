package feature1cars;

public class Car {
	private int odometer;
	private String model;
	private LargeEngine engine = new LargeEngine();
	
	public Car() {
	}
	
	public Car(LargeEngine engine) {
		this.engine = engine;
	}
	
	public Car(String model) {
		this.model=model;
	}
	
	public int getOdometer() {
		return odometer;
	}
	
	public void start() {
		engine.Start();
	}
	
}
