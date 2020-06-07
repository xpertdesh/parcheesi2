public class Piece {
	
	private int location;
	private int spacesTraveled;
	
	public Piece(int playerNum) {
		switch (playerNum) {
			// set player ones location
			case 1:
			this.location = 1;
			break;
			
			// set player twos location
			case 2:
			this.location = 17;
			break;
			
			// set player threes location
			case 3:
			this.location = 33;
			break;
			
			// set player fours location
			case 4:
			this.location = 49;
			break;
		}
		this.spacesTraveled = 0;	
	}
	
	public int getLocation() {
		return this.location;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
	
	public int getSpacesTraveled() {
		return this.spacesTraveled;
	}
	
	public void setSpacesTraveled(int spaces) {
		this.spacesTraveled += spaces;
	}
}
