public class Piece {

	private int location;
	private int spacesTraveled;
	private boolean canMove;
	private int startingLocation = 0;

	public Piece(int playerNum) {
		switch (playerNum) {
			// set player ones location
			case 1:
				this.location = 1;
				this.startingLocation = 1;
				break;

				// set player twos location
			case 2:
				this.location = 17;
				this.startingLocation = 17;
				break;

				// set player threes location
			case 3:
				this.location = 33;
				this.startingLocation = 33;
				break;

				// set player fours location
			case 4:
				this.location = 49;
				this.startingLocation = 49;
				break;
		}
		this.spacesTraveled = 0;	
		this.canMove = false;
	}

	public int getLocation() {
		return this.location;
	}

	public void setLocation(int spaces) {
		if (spaces == 0){
			location = startingLocation;
		}
		else{
			this.location += spaces;
			if (this.location > 64) {
				this.location = this.location - 64;
			}
		}
	}

	public int getSpacesTraveled() {
		return this.spacesTraveled;
	}

	public void setSpacesTraveled(int spaces) {
		if(spaces == 0){
			spacesTraveled = 0;
		}
		else{
			this.spacesTraveled += spaces;
		}
	}

	public void setCanMove(boolean canMove){
		this.canMove = canMove;
	}

	public boolean getCanMove(){
		return canMove;
	}
}
