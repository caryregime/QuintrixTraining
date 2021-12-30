package activity2.Cars;

public abstract class Vehicle {
	
	protected int odometer;

	public int getOdometer() {
		return this.odometer;
	}
	
	public void drive(int distance) {
		this.odometer += distance;
	}
}
