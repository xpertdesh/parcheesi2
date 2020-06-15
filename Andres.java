import java.util.*;

public class Andres extends Player{

    String name;
    int place;

    public Andres(String name, int place){
        super(name, place);
    }


    @Override
    public int movePiece(int roll, ArrayList<Integer> enemyList){
        this.getPiece().setLocation(roll);
        this.getPiece().setSpacesTraveled(roll);
        return 1;
    }




}
