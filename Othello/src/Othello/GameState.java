package Othello;

public class GameState {
	
	// Some function is called in this class that will recieve the updated grid.
	// From this grid create a set of available moves for the heavy algorithm.
	//
	private static Slot[][] gState;
	private static Action[] availMoves;
	
	public static Slot[][] getgState() {
		return gState;
	}

	public static void setgState(Slot[][] gState) {
		GameState.gState = gState;
	}
	
	public static Action[] getAvailMoves() {
		return availMoves;
	}

	public static void setAvailMoves(Action[] availMoves) {
		GameState.availMoves = availMoves;
	}

	//Constructor
	public GameState(Slot[][] status){
		gState = status;
	};
	
	private static class Dir{
		private int row;
		private int col;
		
		private Dir(int y, int x){
			this.row = y;
			this.col = x;
		}
	};
	// Array of all directions
	Dir N  = new Dir(-1,0);
	Dir NE = new Dir(-1,1);
	Dir E  = new Dir(0,1);
	Dir SE = new Dir(1,1);
	Dir S  = new Dir(1,0);
	Dir SW = new Dir(1,-1);
	Dir W  = new Dir(0,-1);
	Dir NW = new Dir(-1,-1);
	Dir[] direcions = {N,NE,E,SE,S,SW,W,NW};
	

	
	//{{-1,0}{-1,1}{0,1}{1,1}{1,0}{1,-1}{0,-1}{-1,-1}}
	//   N,     NE,   E,  SE,   S,   SW,    W,     NW

}

                                                                                  

