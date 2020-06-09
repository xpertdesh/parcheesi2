import java.util.*;
import java.lang.*;
public class Main{
	public static void main (String[] args){
		System.out.println("Hello! Welcome to Parchessi!");
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

        
		System.out.println("\nExcellent! There will be " + numPlayers + " playing today!");
		ArrayList<Player> playerNames = new ArrayList<Player>();
		String trash = input.nextLine();

        //get the name of players
		for(int i = 0; i < numPlayers; i++){
			System.out.println("Please enter the name of PLAYER " + (i+1) + ": ");
			String name = input.nextLine();
            System.out.print("\n");
			Player currentPlayer = new Player(name, (i+1));
			playerNames.add(currentPlayer);
		}

        //create new game and add players to it
		System.out.println("Good luck! Let the game begin!\n");
		Board board = Board.getInstance();
		board.setPlayers(playerNames);

        //start game
		board.runGame();
	}
}

