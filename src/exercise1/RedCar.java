package exercise1;
public class RedCar extends WrappableCar{
	private static int COLOR = 1;
	private static int numBlocks = 0;
	public RedCar(Orientation dir) {
		super(dir,COLOR);
		s.add(this);
	}
	@Override
	protected void calculateTurn() {
		checkedTurn = true;
		s.addBlocks(this, ++numBlocks);
	}	

}
