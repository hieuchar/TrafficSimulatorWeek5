package exercise1;

import java.util.ArrayList;
import java.util.Hashtable;

public class Stats {
	private Hashtable<String, Integer> carTurns = new Hashtable<String, Integer>();
	private Hashtable<String, Integer> carBlocks = new Hashtable<String, Integer>();
	private ArrayList<BlueCar> blueCars = new ArrayList<BlueCar>();
	private ArrayList<RedCar> redCars = new ArrayList<RedCar>();
	private ArrayList<PurpleCar> purpleCars = new ArrayList<PurpleCar>();
	private ArrayList<YellowCar> yellowCars = new ArrayList<YellowCar>();	
	public void add(RedCar c){
		redCars.add(c);
	}
	public void add(BlueCar c){
		blueCars.add(c);
	}
	public void add(YellowCar c){
		yellowCars.add(c);
	}
	public void add(PurpleCar c){
		purpleCars.add(c);
	}
	public void addTurns(BlueCar c, int numTurns){
		carTurns.put("blue", numTurns);
	}
	public void addTurns(YellowCar c, int numTurns){
		carTurns.put("yellow", numTurns);
	}
	public void addTurns(PurpleCar c, int numTurns){
		carTurns.put("purple", numTurns);
	}
	public void addBlocks(BlueCar c, int numBlocks){
		carBlocks.put("blue", numBlocks);
	}
	public void addBlocks(YellowCar c, int numBlocks){
		carBlocks.put("yellow", numBlocks);
	}
	public void addBlocks(PurpleCar c, int numBlocks){
		carBlocks.put("purple", numBlocks);
	}
	public void addBlocks(RedCar c, int numBlocks){
		carBlocks.put("red", numBlocks);
	}
	public void displayStats(){
		System.out.println("\nBlue Car"
				+ "\n Number of Blue Cars Created: " + blueCars.size() 
				+ "\n Number of Total Turns: " + carTurns.get("blue")
				+ "\n Number of blocks traveled total: " + carBlocks.get("blue")
				+ "\n Average number of blocks per car: " + (double)carBlocks.get("blue") / blueCars.size());
		System.out.println("\nRed Car"
				+ "\n Number of Red Cars Created: " + redCars.size() 
				+ "\n Number of Total Turns: 0" 
				+ "\n Number of blocks traveled total: " + carBlocks.get("red")
				+ "\n Average number of blocks per car: " +  (double)carBlocks.get("red") / redCars.size());
		System.out.println("\nYellow Car"
				+ "\n Number of Yellow Cars Created: " + yellowCars.size() 
				+ "\n Number of Total Turns: " + carTurns.get("yellow") 
				+ "\n Number of blocks traveled total: " + carBlocks.get("yellow")
				+ "\n Average number of blocks per car: " + (double)carBlocks.get("yellow") / yellowCars.size());
		System.out.println("\nPurple Car"
				+ "\n Number of Purple Cars Created: " + purpleCars.size() 
				+ "\n Number of Total Turns: " + carTurns.get("purple")
				+ "\n Number of blocks traveled total: " + carBlocks.get("purple")
				+ "\n Average number of blocks per car: " + (double)carBlocks.get("purple") / purpleCars.size());
		
	}
}
