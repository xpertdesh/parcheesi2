import java.util.*;
public class Tyler extends Player{

	String name;
	int place;

	public Tyler(String name, int place){
		super(name, place);
	}
	@Override
	public int movePiece(int roll, ArrayList<Integer> enemyList){
		int fartherstBack = 100;
		int pieceToMove = 0;
		for (int tyler = 0; tyler < this.getPiecesList().size(); tyler++){
			if (this.getPiecesList().get(tyler).getSpacesTraveled() < fartherstBack){
				if (this.getPiecesList().get(tyler).getCanMove() == true){
					fartherstBack = this.getPiecesList().get(tyler).getSpacesTraveled();
					pieceToMove = tyler;
				}
			}
		}
		this.getPiece(pieceToMove).setLocation(roll);
		this.getPiece(pieceToMove).setSpacesTraveled(roll);
		return pieceToMove;
	}
}

