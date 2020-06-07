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
}

