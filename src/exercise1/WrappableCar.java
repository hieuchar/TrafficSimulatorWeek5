package exercise1;

import java.util.ArrayList;

public abstract class WrappableCar extends Car {
	public WrappableCar(Orientation dir, int color){
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
				if(dir.equals(Orientation.NORTH) || dir.equals(Orientation.SOUTH)){
					this.setLocation(this.getX(), (this.getY() == 0)?TrafficWorld.HEIGHT:0);
				}
				else if(dir.equals(Orientation.EAST) || dir.equals(Orientation.WEST)){
					if (this.getX() == 0){
						this.setLocation(1000, this.getY());
					}
					else {
						this.setLocation(0, this.getY());
					}
				}
			}
		}		
	}
}
