package Othello;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

//*****************************
//Nicklas Persson
//Nicolas Swiech
//2016-09-28
//
//*****************************

public class Game {

	private static Slot[][] grid = new Slot[4][4];
	private static final String White = "White";
	private static final String Black = "Black";
	private Human Player1 = new Human(White);
	private Computer Player2 = new Computer(Black);
	private GameState gState = new GameState(grid);
	private static int whiteScore, blackScore;
	private int flipCounter = 0;

	public static void main(String[] args) {
		Game program = new Game();
		program.startGame();
	}

	public void startGame() {
		initializeGrid();// set each Slot of the grid to "available"
		int currentPlayer = 0;
		System.out.println("We are off to a great start, Vive la France\n");
		displayGrid();

		boolean victory = false;
		while (!victory) {
			this.flipCounter = 0;
			if (currentPlayer % 2 == 0) { // white(human) plays on even
				System.out.println("\nThe White players turn to play.");
				Player1.play();
			} else { 
				System.out.println("\nThe Black players turn to play.");
				Player2.play();
			}
			updateGrid(currentPlayer); //Flipps discs and calculate number of flipped discs
			
			//gState.setgState(grid); //Copy current gamegrid to gState
			displayGrid(); //Show grid in console

			currentPlayer++;
			// Game end detector
			if (currentPlayer >= 16) {
				victory = true;
				if (Game.whiteScore == Game.blackScore) {
					System.out.println("The game ends in a tie!");
				} else {
					System.out.println("The White Player ends with a score of " + Game.whiteScore);
					System.out.println("The Black Player ends with a score of " + Game.whiteScore);
				}
			}
		}
	}

	// Flips slot status in the grid after a players make a move
	public void updateGrid(int currentPlayer) {
		int rw,cl;
		String playingColor,oponentColor;
		
		if(currentPlayer % 2 == 0){
			playingColor = "White";
			oponentColor = "Black";
			rw = Player1.getLastRowPlayed(); // put last move in local variables for recurring use
			cl = Player1.getLastColPlayed();
		}else{
			playingColor = "Black";
			oponentColor = "White";
			rw = Player2.getLastRowPlayed();
			cl = Player2.getLastColPlayed();
		}
		
		checksBoard chk = new checksBoard(grid);
		
		if (rw > 1) {
			chk.checkN(rw, cl, playingColor, oponentColor);
		}
		if ((rw > 1) && (cl < 2)) {
			chk.checkNE(rw, cl, playingColor, oponentColor);
		}
		if ((cl < 2)) {
			chk.checkE(rw, cl, playingColor, oponentColor);
		}
		if ((rw < 2) && (cl < 2)) {
			chk.checkSE(rw, cl, playingColor, oponentColor);
		}
		if ((rw < 2)) {
			chk.checkS(rw, cl, playingColor, oponentColor);
		}
		if ((rw < 2) && (cl > 1)) {
			chk.checkSW(rw, cl, playingColor, oponentColor);
		}
		if ((cl > 1)) {
			chk.checkW(rw, cl, playingColor, oponentColor);
		}
		if ((rw > 1) && (cl > 1)) {
			chk.checkNW(rw, cl, playingColor, oponentColor);
		}
		
		//returns result to global variable 'grid'
		grid = chk.getUpdatedGrid();

		calculateWScore();
		calculateBScore();
	}
	
public class checksBoard {
		private Slot[][] localgrid;
		
		//Constructor
		public checksBoard(Slot[][] slotArray){
			localgrid = Arrays.copyOf(slotArray, slotArray.length);
		}
		
		public void updateLocalGrid(Slot[][] slotArray){
			localgrid = Arrays.copyOf(slotArray, slotArray.length);
		}
		
		//Returns result to grid
		public Slot[][] getUpdatedGrid(){
			return Arrays.copyOf(localgrid, localgrid.length);
		}

		// check N (North for Player1)
		public void checkN(int _row, int _col, String _player, String _oponent) {
			int row = _row, col = _col;
			String player =_player, oponent = _oponent; 
			
			// Step North until end of board or
			// until no more slots of opposite colour are found
			do {
				row--;
				row = Math.max(0, row);
			} while (localgrid[row][col].getState().equals(oponent) && (row > 0));
			// Now go south and flip all slots BETWEEN the position found above
			// back to the slot position of the last move
			if (localgrid[row][col].getState().equals(player) && ((_row != 0))) {
				while (row < _row - 1) {
					row++;
					row = Math.min(3, row);
					localgrid[row][col].flip();
					flipCounter++;
				}
			}
		}

		// check NE (North East)
		public void checkNE(int _row, int _col, String _player, String _oponent) {
			int row = _row, col = _col;
			String player =_player, oponent = _oponent; 
			do {
				col++;
				row--;
				col = Math.min(3, col);
				row = Math.max(0, row);
			} while (localgrid[row][col].getState().equals(oponent) && (row > 0) && (col < 3));

			if (localgrid[row][col].getState().equals(player) && (_row != 0)
					&& (_col != 3)) {
				while ((row < _row - 1) && col > _col + 1) {
					col--;
					row++;
					col = Math.max(0, col);
					row = Math.min(3, row);
					localgrid[row][col].flip();
					flipCounter++;
				}
			}
		}

		// check E
		public void checkE(int _row, int _col, String _player, String _oponent) {
			int row = _row, col = _col;
			String player =_player, oponent = _oponent; 
			do {
				col++;
				col = Math.min(3, col);
			} while (localgrid[row][col].getState().equals(oponent) && (col < 3));

			if (localgrid[row][col].getState().equals(player) && (_col != 3)) {
				while (col > _col + 1) {
					col--;
					col = Math.max(0, col);
					localgrid[row][col].flip();
					flipCounter++;
				}
			}
		}

		// check SE
		public void checkSE(int _row, int _col, String _player, String _oponent) {
			int row = _row, col = _col;
			String player =_player, oponent = _oponent; 
			do {
				col++;
				row++;
				col = Math.min(3, col);
				row = Math.min(3, row);
			} while (localgrid[row][col].getState().equals(oponent) && (row < 3) && (col < 3));

			if (localgrid[row][col].getState().equals(player) && (_row != 3)
					&& (_col != 3)) {
				while ((row > _row + 1) && col > _col + 1) {
					col--;
					row--;
					col = Math.max(0, col);
					row = Math.max(0, row);
					localgrid[row][col].flip();
					flipCounter++;
				}
			}
		}

		// check S
		public void checkS(int _row, int _col, String _player, String _oponent) {
			int row = _row, col = _col;
			String player =_player, oponent = _oponent; 
			do {
				row++;
				row = Math.min(3, row);
			} while (localgrid[row][col].getState().equals(oponent) && (row < 3));

			if (localgrid[row][col].getState().equals(player) && (_row != 3)) {
				while (row > _row + 1) {
					row--;
					row = Math.max(0, row);
					localgrid[row][col].flip();
					flipCounter++;
				}
			}
		}

		// check SW
		public void checkSW(int _row, int _col, String _player, String _oponent) {
			int row = _row, col = _col;
			String player =_player, oponent = _oponent; 
			do {
				col--;
				row++;
				col = Math.max(0, col);
				row = Math.min(3, row);
			} while (localgrid[row][col].getState().equals(oponent) && (row < 3) && (col > 0));

			if (localgrid[row][col].getState().equals(player) && (_row != 3)
					&& (_col != 0)) {
				while ((row > _row + 1) && col < _col - 1) {
					col++;
					row--;
					col = Math.min(3, col);
					row = Math.max(0, row);
					localgrid[row][col].flip();
					flipCounter++;
				}
			}
		}
		
		// check W
		public void checkW(int _row, int _col, String _player, String _oponent) {
			int row = _row, col = _col;
			String player =_player, oponent = _oponent; 
			do {
				col--;
				col = Math.max(0, col);
			} while (localgrid[row][col].getState().equals(oponent) && (col > 0));

			if (localgrid[row][col].getState().equals(player) && (_col != 0)) {
				while (col < (_col - 1)) {
					col++;
					col = Math.min(3, col);
					localgrid[row][col].flip();
					flipCounter++;
				}
			}
		}

		// check NW
		public void checkNW(int _row, int _col, String _player, String _oponent) {
			int row = _row, col = _col;
			String player =_player, oponent = _oponent; 
			do {
				col--;
				row--;
				col = Math.max(0, col);
				row = Math.max(0, row);
			} while (localgrid[row][col].getState().equals(oponent) && (row > 0) && (col > 0));		
	
			if (localgrid[row][col].getState().equals(player) && (_row != 0) && (_col != 0)) {
				while ((row < _row - 1) && (col < (_col - 1))) {
					col++;
					row++;			
					col = Math.min(3, col);
					row = Math.min(3, row);
					localgrid[row][col].flip();
					flipCounter++;
				}
			}
		}
	}

	// Display current game status in the console
	public void displayGrid() {

		System.out.println("   1 2 3 4");
		for (int row = 0; row < 4; row++) {
			String rowString = row + 1 + " |";
			for (int col = 0; col < 4; col++) {
				if (grid[row][col].getState().equals("available")) {
					rowString = rowString + " |";
				} else if (grid[row][col].getState().equals(White)) {
					rowString = rowString + "W|";
				} else {
					rowString = rowString + "B|";
				}
			}
			System.out.println(rowString);
		}
		System.out.println(this.flipCounter + "disks have been flipped after this play!");
		System.out.println("Current score is: White:" + Game.whiteScore + " Black:" + Game.blackScore);
	}

	// Calculate white player score
	public int calculateWScore() {
		Game.whiteScore = 0;	
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				if (grid[row][col].getState().equals(White)) {
					Game.whiteScore++;
				}
			}
		}
		return Game.whiteScore;
	}
	
	// Calculate black player score
	public int calculateBScore() {
		Game.blackScore = 0;	
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				if (grid[row][col].getState().equals(Black)) {
					Game.blackScore++;
				}
			}
		}
		return Game.blackScore;
	}

	// Set each Slot of the grid to "available"
	public void initializeGrid() {
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				grid[row][col] = new Slot(row, col, "available");
			}
		}
	}

	public static String getStateSlot(int row, int col) {
		return grid[row][col].getState();
	}

	public static void setStateSlot(int row, int col, String state) {
		grid[row][col].setState(state);
	}

	public static int getWhiteScore() {
		return whiteScore;
	}

	public void setWhiteScore(int whiteScore) {
		Game.whiteScore = whiteScore;
	}

	public static int getBlackScore() {
		return blackScore;
	}

	public void setBlackScore(int blackScore) {
		Game.blackScore = blackScore;
	}
	
	
	// Conversion to better version slot Slot2. 
	// This is admittedly clumsy but caused by early design mistake.
	public ArrayList<Slot2> getGameState(){
		ArrayList<Slot2> gameState = new ArrayList<Slot2>();
		int status = 0;
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				// NB! Col = x and Row = y Point's constructor is Point(x,y) NOT like in grid[row][col];
				Point point = new Point(col,row);
				//Convert from string to integer status representation
				if(grid[row][col].getState().equals("White"))
					status = 1;
				
				if(grid[row][col].getState().equals("Black"))
					status = -1;
				
				if(grid[row][col].getState().equals("available"))
					status = 0;
				
				gameState.add(new Slot2(point, status));
			}
		}
		return gameState;
	}
	
}
