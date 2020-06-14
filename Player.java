import java.util.ArrayList;
import java.util.Random;
public class Player{

	private String name;
	private int place;
	private ArrayList<Piece> pieces;
    private final int numPieces = 2;
	private final int startingLocation;


	public Player(String name, int place){
		this.name = name;
		this.place = place;
		pieces = new ArrayList<Piece>(numPieces);
        
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

	public int getNumPieces() {
		return pieces.size();
	}
	
    //shows player's progress
	public void showState(){
		System.out.println("\n" + name + "'s pieces:");

		for(int i=0; i<numPieces; i++){
		 System.out.println("Piece " + (i+1) + " is at location " + pieces.get(i).getLocation() + " and has moved " + pieces.get(i).getSpacesTraveled() + " spaces.");
        }
        System.out.print("\n");
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
	public Piece getPiece(int pieceNum){
		return pieces.get(pieceNum);
	}


	public String getName(){
		return this.name;
	}
	public int getPlace(){
		return this.place;
	}
	public int movePiece(int roll){
		this.getPiece().setLocation(roll);
		this.getPiece().setSpacesTraveled(roll);
		return 1;
	}
	public int getStartingLocation(){
		return this.startingLocation;
	}
}
