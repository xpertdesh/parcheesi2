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
	
	boolean winner = false;
	Dice dice = Dice.getInstance();
	
	while (winner) {
            
		for (int i = 0; i < players.size(); i++) {
            Player current = player.get(i);
			int roll = dice.rollDice();
            
			current.setLocation(roll);
			current.setSpacesTraveled(roll);
            winnner = current.getPiecesState();
		}
	}
	
}

