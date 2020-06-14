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

					if(current.getPiece().getCanMove() == false){
						if (roll == 5){
							System.out.println("Congratulations " + current.getName() + ", you can move forward with your next roll!\n");
							current.getPiece().setCanMove(true);
						}
						else{
					        System.out.println("Sorry " + current.getName() + " but you need to roll a 5 before you can move");
						}
					}
					else{
						int pieceMoved = current.movePiece(roll);
						for (int j = 0; j < players.size(); j++){
							for (int h = 0; h < 2; h++){
								if (j == i){
								}
								else{
									if (current.getPiece(pieceMoved).getLocation() == players.get(j).getPiece(h).getLocation()){
										System.out.println(current.getName() + " ran into " + players.get(j).getName() + " piece number " + h + ".");
										System.out.println(players.get(j).getName() + " piece will be moved back to his starting position of " + players.get(j).getStartingLocation());
										players.get(j).getPiece(h).setLocation(0);
										players.get(j).getPiece(h).setSpacesTraveled(0);
									}
								}
							}
						}		
						current.showState();
						winner = current.madeIt();
					}
				}
			}
		}


	}//end runGame()
}
