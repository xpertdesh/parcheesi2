import java.util.*;
import java.lang.*;
public class Main{
	public static void main (String[] args){
		System.out.println("Hello! Welcome to Parchessi!");
		System.out.println("How many players will be playing today?");

		Scanner input = new Scanner(System.in);
		int numPlayers = -1;
		boolean validNum = false;
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
				System.out.println("Number was not recognized.");
				System.out.println("Please enter a number between 1-4");
				numPlayers = input.nextInt();
				validNum = false;
			}
		}
		System.out.println("Excellent! There will be " + numPlayers + " playing today!");
		ArrayList<Player> playerNames = new ArrayList<Player>();
		String trash = input.nextLine();
		for(int i = 0; i < numPlayers; i++){
			System.out.println("Please enter the name of player " + (i+1) + ": ");
			String name = input.nextLine();
			Player currentPlayer = new Player(name, (i+1));
			playerNames.add(currentPlayer);
		}
		System.out.println("Good luck! Let the game begin!");
		Board board = Board.getInstance();
		board.setPlayers(playerNames);
	}
}

