import java.util.*;

public class Board{

	private ArrayList<Player> players;
	private static Board theBoard;

	private Board(){}

	public static Board getInstance(){
		if(theBoard == null){
			theBoard = new Board();
		}
		return theBoard;
	}



	public void setPlayers(ArrayList<Player> players){
		this.players = players;
	}



	public void runGame(){
		Dice dice = Dice.getInstance();
		boolean winner = false;        

		while (winner == false) {

			for (int i = 0; i < players.size(); i++) {
				Player current = players.get(i);
				if(winner == false){
					int roll = dice.rollDice();
					boolean didPieceEscapeHome = false;
					boolean canAnyPiecesMove = false;
					boolean anyPieceSafe = false;
					int pieceSafeNum = 0;

					ArrayList<Integer> enemyLocations = new ArrayList<Integer>();
					for(int tyler = 0; tyler < players.size(); tyler++){
						for(int zach = 0; zach < players.get(tyler).getPiecesList().size(); zach++){
							Integer enemyLocation = players.get(tyler).getPiece(zach).getLocation();
							enemyLocations.add(enemyLocation);
						}
					}

					for (int z = 0; z < current.getNumPieces(); z++){
						if (current.getPiece(z).getCanMove() == true){
							canAnyPiecesMove = true;
						}
						if(current.getPiece(z).getInSafeSpace() == true){
							anyPieceSafe = true;
							pieceSafeNum = z;
						}

					}
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
						int pieceMoved = current.movePiece(roll, enemyLocations);
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
					else if((didPieceEscapeHome == false) && (canAnyPiecesMove == false)){
						System.out.println("Sorry " + current.getName() + " but you need to roll a 5 before you can move");
					}
					if (players.get(i).getPiecesList().size() == 0){
						System.out.print("Congratulations " + players.get(i).getName() + " on winning this round of Parcheesi.");
						System.out.println("We hope you enjoyed our game - Andres, Jackson, Tyler, & Zach");
						System.exit(0);
					}
					current.showState();
					//	winner = current.madeIt();
				}
			}
		}
	}


}//end runGame()

