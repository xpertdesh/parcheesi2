import java.util.Random;

public class Dice{

	//Singleton pattern for the Dice
    private static Dice INSTANCE;
    
    private Dice(){}

	//our one instance of the dice
    public static Dice getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Dice();
        }
        return INSTANCE;
    }
    
	//the random int (6) +1 returns 0-5, + 1, just like a real dice
    static int rollDice(){
        Random random = new Random();
        return random.nextInt(6) + 1;
    }    
}
