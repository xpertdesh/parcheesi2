import java.util.*;
public class Zach extends Player{

	String name;
	int place;

	public Zach(String name, int place){
		super(name, place);
	}
	@Override
		public int movePiece(int roll, ArrayList<Integer> enemyList){
			int newLocation = 0;
			for (int i = 0; i < this.getPiecesList().size(); i++){
				newLocation = (this.getPiecesList().get(i).getLocation()) + roll;
				for (int j = 0; j < enemyList.size(); j++){
					if (newLocation == enemyList.get(j)){
						this.getPiece(i).setLocation(roll);
						this.getPiece(i).setSpacesTraveled(roll);
						return i;
					}
				}
			}
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
