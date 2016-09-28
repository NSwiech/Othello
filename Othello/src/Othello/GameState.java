package Othello;

public class GameState {

	// Some function is called in this class that will recieve the updated grid.
	// From this grid create a set of available moves for the heavy algorithm.
	//
	private Slot[][] gState;
	private Action[] availMoves;

	public Slot[][] getgState() {
		return this.gState;
	}

	public void setgState(Slot[][] gState) {
		this.gState = gState;
	}

	public Action[] getAvailMoves() {
		return this.availMoves;
	}

	public void setAvailMoves(Action[] availMoves) {
		this.availMoves = availMoves;
	}

	// Constructor
	public GameState(Slot[][] status) {
		gState = status;
	};

	private static class Dir {
		private int row;
		private int col;

		private Dir(int y, int x) {
			this.row = y;
			this.col = x;
		}
	};

	// Array of all directions
	// {{-1,0}{-1,1}{0,1}{1,1}{1,0}{1,-1}{0,-1}{-1,-1}}
	// N, NE, E, SE, S, SW, W, NW
	Dir N = new Dir(-1, 0);
	Dir NE = new Dir(-1, 1);
	Dir E = new Dir(0, 1);
	Dir SE = new Dir(1, 1);
	Dir S = new Dir(1, 0);
	Dir SW = new Dir(1, -1);
	Dir W = new Dir(0, -1);
	Dir NW = new Dir(-1, -1);
	Dir[] dirs = { N, NE, E, SE, S, SW, W, NW };

}
