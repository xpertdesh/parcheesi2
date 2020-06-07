import java.util.ArrayList;
public class Player{

	private String name;
	//private ArrayList<Piece> pieces;
	private Piece piece;

	public Player(String name, int place){
		this.name = name;
		//pieces
		piece = new Piece(place);
	}



	public void showState(){
		System.out.println(name + "'s pieces:");
		//for(int i=0; i<pieces.size(); i++){
		// System.out.println("Piece " + (i+1) + " is at location "
		//+ pieces.get(i).getLocation());
		System.out.println("Piece is at location " + piece.getLocation());
	}
	public boolean getPiecesState(){
		int counter = 0;
		int num = piece.getSpacesTraveled();
		if(num > 95 && (num % 100) == 5){
			counter++;
		}
		if(counter == 1){
			return true;
		}
		else{
			return false;
		}
	}
	public Piece getPiece(){
		return piece;
	}
}
