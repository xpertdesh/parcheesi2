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
						current.movePiece(roll);
						current.showState();
						winner = current.madeIt();
					}
				}
			}
		}


	}//end runGame()









}
