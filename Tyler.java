public class Tyler extends Player{

	String name;
	int place;

	public Tyler(String name, int place){
		super(name, place);
	}
	@Override
	public void movePiece(int roll){
		this.getPiece().setLocation(roll);
		this.getPiece().setSpacesTraveled(roll);
	}
}

