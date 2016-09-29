package Othello;
//*****************************

//Nicklas Persson
//Nicolas Swiech
//2016-09-28
//
//*****************************

public class Action {
	private int x;
	private int y;
	private int val;
	
	public Action(int row, int col, int value){
		this.x = col;
		this.y = row;
		this.val = value;
	}*/

/*	public int getValue() {
		return this.val;
	}*/

	public int getRow() {
		return this.x;
	}
	
	public int getCol() {
		return this.y;
	}
	
/*	public int[] getPosition() {
		int[] pos = new int[2];
		pos[0] = this.x;
		pos[1] = this.y;

		return pos;
	}*/

}
