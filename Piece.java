public class Piece {

	//instance variables for dice
	private int location;
	private int spacesTraveled;
	private boolean canMove;
	private int playerNum;
	private int startingLocation = 0;
	private boolean inSafeSpace;

	public Piece(int playerNum) {
		this.playerNum = playerNum;
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
		this.inSafeSpace = false;
	}
	//get and setters for whether the piece is in the safe zone
	public boolean getInSafeSpace(){
		return this.inSafeSpace;
	}
	public void setInSafeSpace(boolean inSafeSpace){
		this.inSafeSpace = inSafeSpace;
	}

	//get and set for the piece current location
	public int getLocation() {
		return this.location;
	}

	public void setLocation(int spaces) {
		if (spaces == 0){
			location = startingLocation;
		}
		else if(spaces >= 100){
			location = spaces;
		}
		else if (this.spacesTraveled <= 64){
			this.location += spaces;
			if (this.location > 64) {
				this.location = this.location - 64;
			}
		}
	}

	//get and set for piece current location
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

	//get and set for whether the piece is still in home or not
	public void setCanMove(boolean canMove){
		this.canMove = canMove;
	}

	public boolean getCanMove(){
		return canMove;
	}
}
