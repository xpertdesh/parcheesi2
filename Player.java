import java.util.ArrayList;
import java.util.Random;
public class Player{

	//instance variables
	private String name;
	private int place;
	private ArrayList<Piece> pieces;
	private final int numPieces = 2;
	private final int startingLocation;


	public Player(String name, int place){
		this.name = name;
		this.place = place;
		pieces = new ArrayList<Piece>(numPieces);
		
		//determining the player number
		for(int i=0; i<numPieces; i++){
			pieces.add(new Piece(place));
		}
		if (place == 1){
			startingLocation = 1;
		}
		else if (place == 2){
			startingLocation = 17;
		}
		else if (place == 3){
			startingLocation = 33;
		}
		else{
			startingLocation = 49;
		}
	}
	
	//return the size of the piece arraylist
	public int getNumPieces() {
		return pieces.size();
	}

	//shows player's progress
	public void showState(){
		System.out.println("\n" + name + "'s pieces:");

		for(int i=0; i< pieces.size(); i++){
			System.out.println("Piece " + (i+1) + " is at location " +
					pieces.get(i).getLocation() + " and has moved " +
					pieces.get(i).getSpacesTraveled() + " spaces.");
		}
		System.out.print("\n");
	}
	
	//return the arraylist of pieces
	public ArrayList<Piece> getPiecesList(){
		return this.pieces;
	}


	//checks if all pieces have finished a lap	
	public boolean madeIt() {
		int num = 0;
		int counter = 0;
		for(int i=0; i<numPieces; i++){
			num = pieces.get(i).getSpacesTraveled();
			if(num >= 64){
				counter++;
			}
		}

		if (counter == numPieces) {
			return true;
		}

		return false;
	}


	//finds the first piece on the ArrayList
	//that hasn't finished a lap
	public Piece getPiece(){
		for(int i=0; i<numPieces; i++){
			Piece current = pieces.get(i);
			if(current.getSpacesTraveled() < 64){
				return current;
			}
		}
		//should never get to here
		return null; 
	}
	
	//returns the specificed piece based on the parameter
	public Piece getPiece(int pieceNum){
		//make sure to avoid index out of bounds
		if(pieceNum <= (pieces.size() - 1)){
			return pieces.get(pieceNum);
		}
		else{
			return pieces.get(0);
		}
	}

	//return the name of this player
	public String getName(){
		return this.name;
	}

	//return the player number, 1, 2, 3, or 4
	public int getPlace(){
		return this.place;
	}

	//moving piece method for what the dice roll was and where the enemies are
	public int movePiece(int roll, ArrayList<Integer> enemyList){
		int newLocation = 0;
		for (int i = 0; i < this.getPiecesList().size(); i++){
			newLocation = (this.getPiecesList().get(i).getLocation()) + roll;
			for (int j = 0; j < enemyList.size(); j++){
				if (newLocation == enemyList.get(j)){
					this.getPiece(i).setLocation(roll);
					this.getPiece(i).setSpacesTraveled(roll);
					return i;
				}
			}
		}
		int fartherstBack = 100;
		int pieceToMove = 0;
		for (int tyler = 0; tyler < this.getPiecesList().size(); tyler++){
			if (this.getPiecesList().get(tyler).getSpacesTraveled() < fartherstBack){
				if (this.getPiecesList().get(tyler).getCanMove() == true){
					fartherstBack = this.getPiecesList().get(tyler).getSpacesTraveled();
					pieceToMove = tyler;
				}
			}
		}
		this.getPiece(pieceToMove).setLocation(roll);
		this.getPiece(pieceToMove).setSpacesTraveled(roll);
		return pieceToMove;


	}

	//getter for the starting location
	//used if the piece gets knocked off to return to its original piece
	public int getStartingLocation(){
		return this.startingLocation;
	}
}
