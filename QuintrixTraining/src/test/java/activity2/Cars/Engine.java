package activity2.Cars;

public abstract class Engine implements IEngine{
	protected int cylinderCount;

	public int getCylinderCount() {
		return this.cylinderCount;
	}
	
	public void startEngine() {
		System.out.println("Engine Started");
	}
}
