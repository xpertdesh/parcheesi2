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

    public void runGame(){
        Dice dice = Dice.getInstance();
        boolean winner = false;        

        while (winner == false) {

            for (int i = 0; i < players.size(); i++) {
                Player current = players.get(i);
                int roll = dice.rollDice();
				
				if(players.get(i).getPiece().getCanMove == false){
					if (roll == 5){
						System.out.println("Congratulations " + players.get(i).getName() + ", you can move forward with your next roll!");
						players.get(i).getPiece().setCanMove(true);
					}
					else{
						System.out.println("Sorry but you need to roll a 5 before you can move");
					}
				}
				else{
					current.getPiece().setLocation(roll);
                	current.getPiece().setSpacesTraveled(roll);
					current.showState();
                	//winner = current.getPiecesState();
                	winner = current.madeIt();
            }
        }
    }
}

