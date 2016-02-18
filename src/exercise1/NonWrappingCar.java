package exercise1;

import java.util.ArrayList;

public abstract class NonWrappingCar extends Car{
	public NonWrappingCar(Orientation dir, int color){
		super(dir, color);
	}
	@Override
	public void act() {
		currentX = this.getX();
		currentY = this.getY();
		if(this.isTouching(Car.class)){
			ArrayList<Car> crash = new ArrayList<Car>();
			crash.add(this);
			crash.addAll(this.getIntersectingObjects(Car.class));
			try { 
				throw new CarCrashException(crash);
			} catch (CarCrashException e) {
				
			}
		}
		else {
			this.move(speed.ordinal());
			if(this.isAtEdge()){
				this.getWorld().removeObject(this);
			}
		}		
		
	}

}
