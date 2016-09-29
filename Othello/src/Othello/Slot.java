package Othello;
//*****************************
//Nicklas Persson
//Nicolas Swiech
//2016-09-28
//
//*****************************

public class Slot {
	private int row;
	private int col;
	private String state;

	// boolean available; // clarify and agree on meaning of this
	// if(this.white || this.black){
	// this available=false;
	// displayData branch
	// }
	

	// not totally sure position belongs slot
	// perhaps its enough to do like call grid[1][4].slot.flipp()
	// and grid[1][3].slot.available=false;

	// Position pos = new Position();

	public Slot(int x, int y, String state) {
		this.row = x;
		this.col = y;
		this.state = state;
	}

	public void flip() {
		if (this.state == "White")
			this.state = "Black";
		else if (this.state == "Black")
			this.state = "White";
		else {
			System.out.println("Error in slot flip function.");
		}
	};
	
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public String getState() {
		return this.state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

};
