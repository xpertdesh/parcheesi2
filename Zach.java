import java.util.*;
public class Zach extends Player{

	String name;
	int place;

	public Zach(String name, int place){
		super(name, place);
	}
	@Override
	public int movePiece(int roll, ArrayList<Integer> enemyList){
		this.getPiece().setLocation(roll);
		this.getPiece().setSpacesTraveled(roll);
		return 1;
	}
}
