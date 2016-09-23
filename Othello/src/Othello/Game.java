package Othello;

import java.util.ArrayList;

//TODO while instead of do/while


public class Game {

	public static Slot[][] grid = new Slot[4][4];
	public static int utility[] = new int[2]; // Score keeper White,Black
	public boolean actions[][] = new boolean[4][4];
	public static final String White = "White";
	public static final String Black = "Black";
	// public static String player = "White";
	// public static int currentPlayer = 0;
	public static Human Player1 = new Human(White);
	public static Computer Player2 = new Computer(Black);

	// ArrayList<??> ?? = new ArrayList<??>();

	public static void main(String[] args) {
		// main game loop
		initializeGrid();// set each Slot of the grid to "available"
		startGame();
		
		// for (int n = 0; n < 16; n++) {
		// play();
		// updateGrid();
		// displayGrid();
	}

	public static void startGame() {
		int currentPlayer = 0;
		boolean victory = false;
		System.out.println("We are off to a great start, Vive la France");
		while (!victory) {
			if (currentPlayer % 2 == 0) {
				Player1.play();
			} else {
				Player2.play();
			}
			updateGrid(currentPlayer);
			displayGrid();
			currentPlayer++;
		}
	}

	// }
	// 
	public static void updateGrid(int currentPlayer) {
		int row, col;
		if (currentPlayer % 2 == 0) {
			System.out.println("bla");
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();
			System.out.println("bla");
			// check N (North)
			do {
				row--;
				row = Math.max(0,row);
			} while ((grid[row][col].state == Player2.getColor() && (row > 0)));

			if (grid[row][col].state == Player1.getColor()) {
				do {
					row++;
					row = Math.min(3,row);
					System.out.println("@");
					grid[row][col].flip();
				} while (row != Player1.getLastRowPlayed());
			}
			
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();

			// check NE (North East)
			do {
				col++;
				col = Math.min(3,col);
				row--;
				row = Math.max(0,row);
			} while ((grid[row][col].state == Player2.getColor()) && (row > 0) && (col < 3));

			if (grid[row][col].state == Player1.getColor()) {
				do {
					col--;
					col = Math.max(0,col);
					row++;
					row = Math.min(3,row);
					grid[row][col].flip();
				} while ((row != Player1.getLastRowPlayed())
						&& col != Player1.getLastColPlayed());
			}
			
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();

			// check E
			do {
				col++;
				col = Math.min(3,col);
			} while ((grid[row][col].state == Player2.getColor()) && (col < 3));

			if (grid[row][col].state == Player1.getColor()) {
				do {
					col--;
					col = Math.max(0,col);
					grid[row][col].flip();
				} while (col != Player1.getLastColPlayed());
			}
			
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();

			// check SE
			do {
				col++;
				col = Math.min(3,col);
				row++;
				row = Math.min(3,row);
			} while ((grid[row][col].state == Player2.getColor()) && (row < 3) && (col < 3));

			if (grid[row][col].state == Player1.getColor()) {
				do {
					col--;
					col = Math.max(0,col);
					row--;
					row = Math.max(0,row);
					grid[row][col].flip();
				} while ((row != Player1.getLastRowPlayed())
						&& col != Player1.getLastColPlayed());
			}
			
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();
			
			// check S
			do {
				row++;
				row = Math.min(3,row);
			} while ((grid[row][col].state == Player2.getColor()) && (row < 3));

			if (grid[row][col].state == Player1.getColor()) {
				do {
					row--;
					row = Math.max(0,row);
					grid[row][col].flip();
				} while (row != Player1.getLastRowPlayed());
			}
			
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();

			// check SW

			do {
				col--;
				col = Math.max(0,col);
				row++;
				row = Math.min(3,row);
			} while ((grid[row][col].state == Player2.getColor()) && (row < 3) && (col > 0));

			if (grid[row][col].state == Player1.getColor()) {
				do {
					col++;
					col = Math.min(3,col);
					row--;
					row = Math.max(0,row);
					grid[row][col].flip();
				} while ((row != Player1.getLastRowPlayed())
						&& col != Player1.getLastColPlayed());
			}
			
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();
			
			// check W
			do {
				col--;
				col = Math.max(0,row);
			} while ((grid[row][col].state == Player2.getColor()) && (col > 0));

			if (grid[row][col].state == Player1.getColor()) {
				do {
					col++;
					col = Math.min(3,col);
					grid[row][col].flip();
				} while (col != Player1.getLastColPlayed());
			}
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();
			// check NW
			do {
				col--;
				col = Math.max(0,col);
				row--;
				row = Math.max(0,row);
			} while ((grid[row][col].state == Player2.getColor()) && (row > 0) && (col > 0));

			if (grid[row][col].state == Player1.getColor()) {
				do {
					col++;
					col = Math.min(3,col);
					row++;
					row = Math.min(3,row);
					grid[row][col].flip();
				} while ((row != Player1.getLastRowPlayed())
						&& col != Player1.getLastColPlayed());
			}
		}

		else {
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();
			// check N
			do {
				row--;
				row = Math.max(0,row);
			} while ((grid[row][col].state == Player1.getColor() && (row > 0)));

			if (grid[row][col].state == Player2.getColor()) {
				do {
					row++;
					row = Math.min(3,row);
					grid[row][col].flip();
				} while (row != Player2.getLastRowPlayed());
			}
			
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();

			// check NE
			do {
				col++;
				col = Math.min(3,col);
				row--;
				row = Math.max(0,row);
			} while ((grid[row][col].state == Player1.getColor()) && (row > 0) && (col < 3));

			if (grid[row][col].state == Player2.getColor()) {
				do {
					col--;
					col = Math.max(0,col);
					row++;
					row = Math.min(3,row);
					grid[row][col].flip();
				} while ((row != Player2.getLastRowPlayed())
						&& col != Player2.getLastColPlayed());
			}
			
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();

			// check E
			do {
				col++;
				col = Math.min(3,col);
			} while ((grid[row][col].state == Player1.getColor()) && (col < 3));

			if (grid[row][col].state == Player2.getColor()) {
				do {
					col--;
					col = Math.max(0,col);
					grid[row][col].flip();
				} while ((col+1) != Player2.getLastColPlayed());
			}
			
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();

			// check SE
			do {
				col++;
				col = Math.min(3,col);
				row++;
				row = Math.min(3,row);
			} while ((grid[row][col].state == Player1.getColor()) && (row < 3) && (col < 3));

			if (grid[row][col].state == Player2.getColor()) {
				do {
					col--;
					col = Math.max(0,col);
					row--;
					row = Math.max(0,row);
					grid[row][col].flip();
				} while ((row != Player2.getLastRowPlayed())
						&& col > Player2.getLastColPlayed());
			}
			
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();
			
			// check S
			do {
				row++;
				row = Math.min(3,row);
			} while ((grid[row][col].state == Player1.getColor()) && (row < 3));

			if (grid[row][col].state == Player2.getColor()) {
				do {
					row--;
					row = Math.max(0,row);
					grid[row][col].flip();
				} while (row != Player2.getLastRowPlayed());
			}
			
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();

			// check SW

			do {
				col--;
				col = Math.max(0,col);
				row++;
				row = Math.min(3,row);
			} while ((grid[row][col].state == Player1.getColor()) && (row < 3) && (col > 0));

			if (grid[row][col].state == Player2.getColor()) {
				do {
					col++;
					col = Math.min(3,col);
					row--;
					row = Math.max(0,row);
					grid[row][col].flip();
				} while ((row != Player2.getLastRowPlayed())
						&& col != Player2.getLastColPlayed());
			}
			
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();
			
			// check W
			do {
				col--;
				col = Math.max(0,col);
			} while ((grid[row][col].state == Player1.getColor()) && (col > 0));

			if (grid[row][col].state == Player2.getColor()) {
				do {
					col++;
					col = Math.min(3,col);
					grid[row][col].flip();
				} while (col != Player2.getLastColPlayed());
			}
			
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();
			
			// check NW
			do {
				col--;
				col = Math.max(0,col);
				row--;
				row = Math.max(0,row);
			} while ((grid[row][col].state == Player1.getColor()) && (row > 0) && (col > 0));

			if (grid[row][col].state == Player2.getColor()) {
				do {
					col++;
					col = Math.min(3,col);
					row++;
					row = Math.min(3,row);
					grid[row][col].flip();
				} while ((row != Player2.getLastRowPlayed())
						&& col != Player2.getLastColPlayed());
			}
		}
		return;
	}

	public static void displayGrid() {
		for (int row = 0; row <3 ; row++) {
			String rowString = "|";
			for (int col = 0; col < 3; col++) {
				if (grid[row][col].state == "available") {
					rowString = rowString + " |";
				} else if (grid[row][col].state.equals(White)) {
					rowString = rowString + "W|";
				} else {
					rowString = rowString + "B|";
				}
			}
			System.out.println(rowString);
		}
		System.out.println("Current ccore is: White:" + utility()[0] + " Black:" + utility()[1]);
	}

	// Calculate both players current score
	public static int[] utility() {
		int noOfBlack = 0;
		int noOfWhite = 0;
		int[] score = new int[2]; // Score keeper White,Black

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (grid[row][col].state.equals(Black)) {
					noOfBlack++;
				} else if (grid[row][col].state.equals(White)) {
					noOfWhite++;
				}
			}
		}
		score[0] = noOfWhite;
		score[1] = noOfBlack;
		return score;
	}

	public static void initializeGrid() {
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				grid[row][col] = new Slot(row, col, "available");
			}
		}
	}

}