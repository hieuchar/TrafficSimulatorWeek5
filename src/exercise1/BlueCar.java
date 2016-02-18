package exercise1;
public class BlueCar extends NonWrappingCar{
	private boolean turn = true;
	private static int COLOR = 0;
	private static int numTurns = 0;
	private static int numBlocks = 0;
	public BlueCar(Orientation dir) {
		super(dir,COLOR);
		s.add(this);
	}

	@Override
	protected void calculateTurn() {
		if(turn){
			leftTurn();
			turn = false;
		}
		else{
			rightTurn();
			turn = true;
		}
		s.addTurns(this, ++numTurns);
		s.addBlocks(this, ++numBlocks);
		checkedTurn = true;
		
	}

	

}
