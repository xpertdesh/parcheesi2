import java.util.*;

public class Board{
	
	private ArrayList<Player> players;
	private static Board theBoard;
	public Board(){

	}
	public static Board getInstance(){
		if(theBoard == null){
			theBoard = new Board();
		}
		return theBoard;
	}
	public void setPlayers(ArrayList<Player> players){
		this.players = players;
	}
	
	/*boolean winner = false;
	Dice dice = new Dice();
	
	while (winner != true) {
		for (int i = 0; i < players.size(); i++) {
			int roll = dice.rollDice();
			players.get(i).setLocation(roll);
			players.get(i).setSpacesTraveled(roll);
		}
	}
	* */
}

