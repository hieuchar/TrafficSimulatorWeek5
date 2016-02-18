package exercise1;
public class PurpleCar extends NonWrappingCar{
	private static int COLOR = 2;
	private static int numTurns = 0;
	private static int numBlocks = 0;
	public PurpleCar(Orientation dir) {
		super(dir,COLOR);
		s.add(this);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void calculateTurn() {
		int r = rand.nextInt(100);
		if(r >= 75){
			leftTurn();
			s.addTurns(this, ++numTurns);
		}
		s.addBlocks(this, ++numBlocks);
		checkedTurn = true;
	}

}
