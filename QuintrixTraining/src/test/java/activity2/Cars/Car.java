package activity2.Cars;

public class Car extends Vehicle{
	public IEngine engine;
	public String model;

	public Car(String model, IEngine engine) {
		this.model = model;
		this.engine = engine;
	}
	
	public void Start() {
		this.engine.startEngine();		
	}
}
