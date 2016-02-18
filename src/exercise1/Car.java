package exercise1;

import java.util.Random;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

public abstract class Car extends Actor implements IntersectionListener {
	protected static Stats s = new Stats();
	protected GreenfootImage image;
	protected Orientation dir;
	protected Orientation turnDir;
	protected Speed speed = Speed.GO;
	protected boolean passed = false;
	protected Intersection current = null;
	protected Random rand = new Random();
	protected boolean turning = false;
	protected boolean checkedTurn = false;
	protected int currentX;
	protected int targetX;
	protected int currentY;
	protected int targetY;
	protected String[] cars = {"images/topCarBlue.png","images/topCarRed.png","images/topCarPurple.png","images/topCarYellow.png"};
	public Car(Orientation dir, int color){
		this.dir = dir;
		image = new GreenfootImage(cars[color]);
		this.setImage(image);
	}
	protected static enum Speed{
		STOP,
		SLOW,
		GO;		
	}
	public abstract void act();
	protected abstract void calculateTurn();
	public Orientation getOrientation(){
		return dir;
	}
	public int getWidth(){
		return image.getWidth();
	}
	public int getHeight(){
		return image.getHeight();
	}
	public String toString(){
		return ("" + dir);
	}
	public void setSpeed(Speed speed){
		this.speed = speed;
	}
	protected void rightTurn(){
		turning = true;
		if(dir.equals(Orientation.SOUTH)){
			targetY = currentY + (TrafficWorld.ROADWIDTH / 2 );
			turnDir = Orientation.WEST;
		}
		else if(dir.equals(Orientation.NORTH)){
			targetY = currentY - (TrafficWorld.ROADWIDTH/ 2);
			turnDir = Orientation.EAST;
		}
		else if(dir.equals(Orientation.EAST)){
			targetX = currentX + ( ( TrafficWorld.ROADWIDTH / 2));
			turnDir = Orientation.SOUTH;
		}
		else if(dir.equals(Orientation.WEST)){
			targetX = currentX - (TrafficWorld.ROADWIDTH / 2);
			turnDir = Orientation.NORTH;
		}
	}
	protected void makeTurn(){
		if(dir.equals(Orientation.EAST)){
			if(currentX > targetX){
				this.setRotation(turnDir.getRotation());
				dir = turnDir;
				turning = false;
				checkedTurn = false;
			}
		}
		else if (dir.equals(Orientation.WEST)){
			if(currentX < targetX){
				this.setRotation(turnDir.getRotation());
				dir = turnDir;
				turning = false;
				checkedTurn = false;
			}
		}
		else if(dir.equals(Orientation.SOUTH) ){
			if(currentY > targetY){
				this.setRotation(turnDir.getRotation());
				dir = turnDir;
				turning = false;
				checkedTurn = false;
			}
		}
		else if(dir.equals(Orientation.NORTH)){
			if(currentY < targetY){
				this.setRotation(turnDir.getRotation());
				dir = turnDir;
				turning = false;
				checkedTurn = false;
			}
		}
	}
	protected void leftTurn(){
		turning = true;
		if(dir.equals(Orientation.SOUTH)){
			currentY = this.getY();
			targetY = currentY + (TrafficWorld.ROADWIDTH + TrafficWorld.ROADWIDTH / 4 );
			turnDir = Orientation.EAST;
		}
		else if(dir.equals(Orientation.NORTH)){
			currentY = this.getY();
			targetY = currentY - (TrafficWorld.ROADWIDTH + TrafficWorld.ROADWIDTH / 4);
			turnDir = Orientation.WEST;
		}
		else if(dir.equals(Orientation.EAST)){
			currentX = this.getX();
			targetX = currentX + (TrafficWorld.ROADWIDTH + TrafficWorld.ROADWIDTH / 4);
			turnDir = Orientation.NORTH;
		}
		else if(dir.equals(Orientation.WEST)){
			currentX = this.getX();
			targetX = currentX - (TrafficWorld.ROADWIDTH + TrafficWorld.ROADWIDTH / 4);
			turnDir = Orientation.SOUTH;
		}
	}
	
	@Override
	public void approachingIntersection(Intersection in){
		if(passed && in.equals(current) ){
			passedIntersection(in);
		}
		else{
			if(!turning && !checkedTurn){
				calculateTurn();
			}
			if(turning) {
				makeTurn();
			}
			current = in;
			passed = false;
			if(dir.equals(Orientation.NORTH) || dir.equals(Orientation.SOUTH)){
				if(in.verticalColor.equals(TrafficLight.Color.RED)){
					speed = Speed.STOP;
				}
				else if(in.verticalColor.equals(TrafficLight.Color.YELLOW)){
					speed = Speed.SLOW;
				}
				else {
					if(turning){
						speed = Speed.SLOW;
					}
					else {
						speed = Speed.GO;
					}
				}
			}
			if(dir.equals(Orientation.EAST) || dir.equals(Orientation.WEST)){
				if(in.horizColor.equals(TrafficLight.Color.RED)){
					speed = Speed.STOP;
				}
				else if(in.horizColor.equals(TrafficLight.Color.YELLOW)){
					speed = Speed.SLOW;
				}
				else {
					if(turning){
						speed = Speed.SLOW;
					}
					else {
						speed = Speed.GO;
					}
				}
			}
		}
	}
	@Override
	public void inIntersection(Intersection in){
		assert in != null;
		if(turning){
			makeTurn();
		}
		checkedTurn = false;
		current = in;
		passed = true;
		if(dir.equals(Orientation.NORTH) || dir.equals(Orientation.SOUTH)){
			if(in.verticalColor.equals(TrafficLight.Color.RED)){
					speed = Speed.STOP;
			}
			else if(in.verticalColor.equals(TrafficLight.Color.YELLOW)){
				if(turning){
					speed = Speed.SLOW;
				}
				else {
					speed = Speed.GO;
				}
			}
			else {
				if(turning){
					speed = Speed.SLOW;
				}
				else {
					speed = Speed.GO;
				}
			}
		}
		if(dir.equals(Orientation.EAST) || dir.equals(Orientation.WEST)){
			if(in.horizColor.equals(TrafficLight.Color.RED)){
					speed = Speed.STOP;
			}
			else if(in.horizColor.equals(TrafficLight.Color.YELLOW)){
				if(turning){
					speed = Speed.SLOW;
				}
				else {
					speed = Speed.GO;
				}
			}
			else {
				if(turning){
					speed = Speed.SLOW;
				}
				else {
					speed = Speed.GO;
				}
			}
		}		
	}
	@Override
	public void passedIntersection(Intersection in){
		assert in != null;
		if(turning){
			speed = Speed.SLOW;
		}
		else{
		speed = Speed.GO;
		}
		
	}
}
