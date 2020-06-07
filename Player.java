import java.util.ArrayList;

public class Player{

    private String name;
    private ArrayList<Piece> pieces;
    
    Player(String name, int place){
        this.name = name;
        pieces = new ArrayList<Piece>(1);
        for(int i=0; i<pieces.size(); i++){
            pieces.add(new Piece(place));
        }
    }

    
    void showState(){
        System.out.println(name + "'s pieces:");
        for(int i=0; i<pieces.size(); i++){
            System.out.println("Piece " + (i+1) + " is at location "
             + pieces.get(i).getLocation());
        }
    }

    
    boolean getPiecesState(){
        int counter = 0;        

        for(int i=0; i<pieces.size(); i++){
            int num = pieces.get(i).getSpacesTravelled();
            if(num > 95 && (num % 100) == 5)
                    counter++;
        }
        
        if(counter == pieces.size())
            return true;

        return false;
    }


}
