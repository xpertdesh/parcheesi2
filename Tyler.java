public class Tyler extends Player{

	String name;
	int place;

	public Tyler(String name, int place){
		super(name, place);
	}
	@Override
	public int movePiece(int roll){
		this.getPiece().setLocation(roll);
		this.getPiece().setSpacesTraveled(roll);
		return 1;
	}
}

