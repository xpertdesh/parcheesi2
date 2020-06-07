import java.util.Random;

public class Dice{
    private static Dice INSTANCE;
    
    private Dice(){}

    public static Dice getInstance(){
        if(INSTANCE == null)
            INSTANCE = new Dice();
        return INSTANCE;
    }
    
    static int rollDice(){
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    
}
