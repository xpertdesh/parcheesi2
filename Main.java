import java.util.*;
import java.lang.*;


public class Main{
	public static void main (String[] args){

		//Scanner we no longer needed after the sockets
		Scanner input = new Scanner(System.in);
		
		//getting the names of the players from the sockets
		MultiClientServer ourServer = new MultiClientServer();
		MultiClientServer2 ourServer2 = new MultiClientServer2();
		String name1 = ourServer.getName();
		String name2 = ourServer2.getName();

		//Showing we got the correct name from the sockets
		System.out.println("Name from the 1st socket is " + name1);
		System.out.println("Name from the 2nd socket is " + name2);

		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException a){

		}

		System.out.println("Hello! Welcome to Parchessi!");
		System.out.println("We will be running our simulation today with two players!");
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException b){

		}


		//manual entrance of names and number of players before sockets
        /*
		System.out.println("How many players will be playing today?i\n");
		
		   Scanner input = new Scanner(System.in);
		   int numPlayers = -1;
		   boolean validNum = false;

		//check the number of players
		while(validNum == false){
		try{
		System.out.println("Enter a number between 1-4: ");
		numPlayers = input.nextInt();
		if ((numPlayers <= 0) || (numPlayers >=5)){
		validNum = false;
		}
		else{
		validNum = true;
		}
		}
		catch (InputMismatchException e){
		String trash = input.nextLine();
		System.out.println("\nNumber was not recognized.");
		System.out.println("Please enter a number between 1-4\n");
		validNum = false;
		}
		}
		 */

		//arraylist of all our players
		ArrayList<Player> playerNames = new ArrayList<Player>();


		//get the name of players
		//Player currentPlayer = new Player(name, place);

		//creating the players based of name and adding them to our players list
		
		if(name1.equals("Tyler")){
			playerNames.add(new Tyler(name1, (1)));
		}
		else if(name1.equals("Andres")){
			playerNames.add(new Andres(name1, (1)));
		}
		else if(name1.equals("Zach")){
			playerNames.add(new Zach(name1, (1)));
		}
		else{
			playerNames.add(new Player("Computer Player", 1));
		}
		if(name2.equals("Tyler")){
			playerNames.add(new Tyler(name2, (2)));
		}
		else if(name2.equals("Andres")){
			playerNames.add(new Andres(name2, (2)));
		}
		else if(name2.equals("Zach")){
			playerNames.add(new Zach(name2, (2)));
		}
		else{
			playerNames.add(new Player("Computer Player", 2));
		}

		//create new game and add players to it
		System.out.println("Good luck! Let the game begin!\n");
		Board board = Board.getInstance();
		board.setPlayers(playerNames);

		//start game
		board.runGame();
	}
}
