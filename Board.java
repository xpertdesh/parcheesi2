import java.util.*;

public class Board{

	//the ArrayList of players playing
	private ArrayList<Player> players;
	//the one instance of the board
	private static Board theBoard;

	private Board(){}

	//Singleton Pattern to ensure there is only one Board object
	public static Board getInstance(){
		if(theBoard == null){
			theBoard = new Board();
		}
		return theBoard;
	}


	//setting the list of players from main
	public void setPlayers(ArrayList<Player> players){
		this.players = players;
	}

	//run the game until someone wins
	public void runGame(){
		//our one dice object
		Dice dice = Dice.getInstance();

		//playing until winner is true
		boolean winner = false;        

		while (winner == false) {
			
			//going through each player in the list, and restarting
			for (int i = 0; i < players.size(); i++) {
				Player current = players.get(i);
				if(winner == false){
					int roll = dice.rollDice();

					//booleans to check the current pieces conditions
					boolean didPieceEscapeHome = false;
					boolean canAnyPiecesMove = false;
					boolean anyPieceSafe = false;
					//seeing how many pieces they player has in the safe zone
					int pieceSafeNum = 0;

					//passing the current player all of the other player locations to guide their move
					ArrayList<Integer> enemyLocations = new ArrayList<Integer>();
					for(int tyler = 0; tyler < players.size(); tyler++){
						for(int zach = 0; zach < players.get(tyler).getPiecesList().size(); zach++){
							Integer enemyLocation = players.get(tyler).getPiece(zach).getLocation();
							enemyLocations.add(enemyLocation);
						}
					}
					
					//checking piece status
					for (int z = 0; z < current.getNumPieces(); z++){
						if (current.getPiece(z).getCanMove() == true){
							canAnyPiecesMove = true;
						}
						if(current.getPiece(z).getInSafeSpace() == true){
							anyPieceSafe = true;
							pieceSafeNum = z;
						}

					}

					//checking conditions to see if user can roll the dice,
					//if the roll is a 5 and the player has a piece in home, then their piece is automatically moved out
					//if the roll is 5 and the player has a piece in the safe zone, the piece is automatically moved home
					if((roll == 5) && (anyPieceSafe == true)){
						System.out.println("Congratulations " + players.get(i).getName() + ", your " + (pieceSafeNum + 1) + " made it home safe!");
						players.get(i).getPiecesList().remove(pieceSafeNum);
					}

					else if (roll == 5){
						for (int t = 0; t < current.getNumPieces(); t++){
							if(current.getPiece(t).getCanMove() == false){
								current.getPiece(t).setCanMove(true);
								System.out.println("Congratulations " + current.getName() + ", you can move your " + (t+1) + " forward with your next roll!\n");
								didPieceEscapeHome = true;
								break;
							}
						}
					}
					else if((didPieceEscapeHome == false) && (canAnyPiecesMove == true)){

						//moving the piece and returning the piece number the plaer moved
						int pieceMoved = current.movePiece(roll, enemyLocations);

						//trying to avoid cheating!
						if (current.getPiece(pieceMoved).getCanMove() == false){
							System.out.println("You are trying to move a piece stuck at home. Pick another piece until that one is out of home.");
							int goBack = roll * -1;
							current.getPiece(pieceMoved).setLocation(goBack);
							if(current.getPiece(pieceMoved).getSpacesTraveled() == 0){
							}
							else{
								current.getPiece(pieceMoved).setSpacesTraveled(goBack);
							}
						}

						//checking to see if the piece has made it into the safe zone
						//the players specific safe zone is determined by their player number or i
						else{
							if (current.getPiece(pieceMoved).getSpacesTraveled() >= 64){
								current.getPiece(pieceMoved).setSpacesTraveled(0);
								current.getPiece(pieceMoved).setInSafeSpace(true);
								if(i == 0){
									current.getPiece(pieceMoved).setLocation(100);
									current.getPiece(pieceMoved).setCanMove(false);
								}
								else if(i == 1){
									current.getPiece(pieceMoved).setLocation(200);
									current.getPiece(pieceMoved).setCanMove(false);

								}
								else if(i == 2){
									current.getPiece(pieceMoved).setLocation(300);
									current.getPiece(pieceMoved).setCanMove(false);

								}
								else{
									current.getPiece(pieceMoved).setLocation(400);
									current.getPiece(pieceMoved).setCanMove(false);
								}
								
								//checking to see if a player knocked another players piece off the board
								//but making sure to skip their own pieces
								for (int j = 0; j < players.size(); j++){
									for (int h = 0; h < current.getNumPieces(); h++){
										if (j == i){
										}
										else{
											if (current.getPiece(pieceMoved).getLocation() == players.get(j).getPiece(h).getLocation()){
												System.out.println(current.getName() + " ran into " + players.get(j).getName() + " piece number " + (h + 1) + ".");
												System.out.println(players.get(j).getName() + " piece will be moved back to his starting position of " + players.get(j).getStartingLocation());
												players.get(j).getPiece(h).setLocation(0);
												players.get(j).getPiece(h).setSpacesTraveled(0);
												players.get(j).getPiece(h).setCanMove(false);
											}
										}
									}
								}

							}
						}
					}

					//no pieces can move until a 5 is rolled
					else if((didPieceEscapeHome == false) && (canAnyPiecesMove == false)){
						System.out.println("Sorry " + current.getName() + " but you need to roll a 5 before you can move");
					}

					//checking for a winner!
					if (players.get(i).getPiecesList().size() == 0){
						try{
							Thread.sleep(2500);
						}
						catch(InterruptedException a){

						}
						System.out.println();
						System.out.println();
						System.out.println("Congratulations " + players.get(i).getName() + " on winning this round of Parcheesi.");
						System.out.println("We hope you enjoyed our game - Andres, Jackson, Tyler, & Zach");

						try{
							Thread.sleep(2500);
						}
						catch(InterruptedException b){

						}
						System.exit(0);
					}
					try{
						Thread.sleep(500);
					}
					catch(InterruptedException c){

					}

					//showing where the players pieces are and how far they have traveled after their move
					current.showState();
					//	winner = current.madeIt();
				}
			}
		}
	}


}//end runGame()

