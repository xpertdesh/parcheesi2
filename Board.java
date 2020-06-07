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

        while (winner) {

            for (int i = 0; i < players.size(); i++) {
                Player current = players.get(i);
                int roll = dice.rollDice();

                current.getPiece(0).setLocation(roll);
                current.getPiece(0).setSpacesTraveled(roll);
                winner = current.getPiecesState();
            }
        }
    }







}

