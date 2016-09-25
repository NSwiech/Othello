package Othello;

public class Action {
	private int x;
	private int y;
	private int val;
	
	private Action(int row, int col, int value){
		this.x = col;
		this.y = row;
		this.val = value;
	}
	
	public void setValue(int value){
		this.val=value;	
	}
	public int getValue(){
		return this.val;	
	}

	public int[] getPosition(){
		int[] pos = new int[2];
		pos[0] = this.y;
		pos[1] = this.x;
		
		return pos;	
	}

}
