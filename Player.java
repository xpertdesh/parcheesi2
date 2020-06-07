import java.util.ArrayList;

public class Player{

    private String name;
    private ArrayList<Piece> pieces;
    
    Player(String name, int place){
        this.name = name;
        pieces = new ArrayList<Piece>(3);
        for(int i=0; i<pieces.size(); i++){
            pieces.add(new Piece(place));
        }
    }

    
    void showState(){
        System.out.println(name + "'s pieces:");
        for(int i=0; i<pieces.size(); i++){
            System.out.println("Piece " + (i+1) + " is at location " + pieces.get(i).getLocation());
        }
    }


}
