package exercise1;
public class YellowCar extends WrappableCar {
	private static int COLOR = 3;
	private static int numTurns = 0;
	private static int numBlocks = 0;
	public YellowCar(Orientation dir) {
		super(dir,COLOR);
		s.add(this);
	}
	@Override
	protected void calculateTurn() {
		int r = rand.nextInt(100);
		if(r >= 75){
			rightTurn();			
			s.addTurns(this, ++numTurns);
		}
		s.addBlocks(this, ++numBlocks);
		checkedTurn = true;
		
	}

	

}
