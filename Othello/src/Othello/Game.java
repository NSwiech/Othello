package Othello;

import java.util.ArrayList;

//TODO while instead of do/while
//TODO not flipping yourself!
//TODO working on line 189

public class Game {

	public static Slot[][] grid = new Slot[4][4];
	public static int utility[] = new int[2]; // Score keeper White,Black
	public boolean actions[][] = new boolean[4][4];
	public static final String White = "White";
	public static final String Black = "Black";
	public static Human Player1 = new Human(White);
	public static Computer Player2 = new Computer(Black);

	public static void main(String[] args) {
		// main game loop
		initializeGrid();// set each Slot of the grid to "available"
		startGame();
	}

	public static void startGame() {
		int currentPlayer = 0;
		System.out.println("We are off to a great start, Vive la France\n");
		displayGrid();
		
		boolean victory = false;
		while (!victory) {
			if (currentPlayer % 2 == 0) {
				System.out.println("\nThe White Player has to play.");
				Player1.play();
			} else {
				System.out.println("\nThe Black Player has to play.");
				Player2.play();
			}
			updateGrid(currentPlayer);
			displayGrid();
			
			currentPlayer++;
			if (currentPlayer == 16) {
				victory = true;
				if (utility()[0] == utility()[1]){
					System.out.println("The game ends in a tie!");
				}
				else {
					System.out.println("The White Player ends with a score of " + utility()[0]);
					System.out.println("The Black Player ends with a score of " + utility()[1]);
				}
			}
		}
	}

	public static void updateGrid(int currentPlayer) {
		int row, col;
		if (currentPlayer % 2 == 0) {
			
			// check N (North)
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();
			do {
				row--;
				row = Math.max(0, row);
			} while ((grid[row][col].state == Player2.getColor() && (row > 0)));

			if ((grid[row][col].state == Player1.getColor()) && ((Player1.getLastRowPlayed() != 0))) {
				while (row < Player1.getLastRowPlayed() - 1) {
					row++;
					row = Math.min(3, row);
					System.out.println("@1");
					grid[row][col].flip();
				}
			}
			
			// check NE (North East)
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();
			do {
				col++;
				col = Math.min(3, col);
				row--;
				row = Math.max(0, row);
			} while ((grid[row][col].state == Player2.getColor()) && (row > 0) && (col < 3));

			if ((grid[row][col].state == Player1.getColor()) && (Player1.getLastRowPlayed() != 0)
					&& (Player1.getLastColPlayed() != 3)) {
				while ((row < Player1.getLastRowPlayed() - 1) && col > Player1.getLastColPlayed() + 1) {
					col--;
					col = Math.max(0, col);
					row++;
					row = Math.min(3, row);
					System.out.println("@2");
					grid[row][col].flip();
				}
			}
		
			// check E
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();
			do {
				col++;
				col = Math.min(3, col);
			} while ((grid[row][col].state == Player2.getColor()) && (col < 3));

			if ((grid[row][col].state == Player1.getColor()) && (Player1.getLastColPlayed() != 3)) {
				while (col > Player1.getLastColPlayed() + 1) {
					col--;
					col = Math.max(0, col);
					System.out.println("@3");
					grid[row][col].flip();
				}
			}

			// check SE
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();
			do {
				col++;
				col = Math.min(3, col);
				row++;
				row = Math.min(3, row);
			} while ((grid[row][col].state == Player2.getColor()) && (row < 3) && (col < 3));

			if ((grid[row][col].state == Player1.getColor()) && (Player1.getLastRowPlayed() != 3)
					&& (Player1.getLastColPlayed() != 3)) {
				while ((row > Player1.getLastRowPlayed() + 1) && col > Player1.getLastColPlayed() + 1) {
					col--;
					col = Math.max(0, col);
					row--;
					row = Math.max(0, row);
					System.out.println("@4");
					grid[row][col].flip();
				}
			}

			// check S
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();
			do {
				row++;
				row = Math.min(3, row);
			} while ((grid[row][col].state == Player2.getColor()) && (row < 3));

			if ((grid[row][col].state == Player1.getColor()) && (Player1.getLastRowPlayed() != 3)) {
				while (row > Player1.getLastRowPlayed() + 1) {
					row--;
					row = Math.max(0, row);
					System.out.println("@5");
					grid[row][col].flip();
				}
			}

			// check SW
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();
			do {
				col--;
				col = Math.max(0, col);
				row++;
				row = Math.min(3, row);
			} while ((grid[row][col].state == Player2.getColor()) && (row < 3) && (col > 0));

			if ((grid[row][col].state == Player1.getColor()) && (Player1.getLastRowPlayed() != 3)
					&& (Player1.getLastColPlayed() != 0)) {
				while ((row > Player1.getLastRowPlayed() + 1) && col < Player1.getLastColPlayed() - 1) {
					col++;
					col = Math.min(3, col);
					row--;
					row = Math.max(0, row);
					System.out.println("@6");
					grid[row][col].flip();
				}
			}

			// check W
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();
			do {
				col--;
				col = Math.max(0, col);
			} while ((grid[row][col].state == Player2.getColor()) && (col > 0));

			if ((grid[row][col].state == Player1.getColor()) && (Player1.getLastColPlayed() != 0)) {

				while (col < Player1.getLastColPlayed() - 1) {
					col++;
					col = Math.min(3, col);
					System.out.println("@7");
					System.out.println(row + "" + col + "" + grid[row][col].state);
					grid[row][col].flip();
					System.out.println(row + "" + col + "" + grid[row][col].state);
				}
			}

			// check NW
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();
			do {
				col--;
				col = Math.max(0, col);
				row--;
				row = Math.max(0, row);
			} while ((grid[row][col].state == Player2.getColor()) && (row > 0) && (col > 0));

			if ((grid[row][col].state == Player1.getColor()) && (Player1.getLastRowPlayed() != 0)
					&& (Player1.getLastColPlayed() != 0)) {
				while ((row < Player1.getLastRowPlayed() - 1) && col < Player1.getLastColPlayed() - 1) {
					col++;
					col = Math.min(3, col);
					row++;
					row = Math.min(3, row);
					System.out.println("@8");
					grid[row][col].flip();
				}
			}
		}

		else {
			// check N
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();
			do {
				row--;
				row = Math.max(0, row);
			} while ((grid[row][col].state == Player1.getColor() && (row > 0)));

			if ((grid[row][col].state == Player2.getColor()) && ((Player2.getLastRowPlayed() != 0))) {
				while (row < Player2.getLastRowPlayed() - 1) {
					row++;
					row = Math.min(3, row);
					System.out.println("@@1");
					grid[row][col].flip();
				}
			}

			// check NE
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();
			do {
				col++;
				col = Math.min(3, col);
				row--;
				row = Math.max(0, row);
			} while ((grid[row][col].state == Player1.getColor()) && (row > 0) && (col < 3));

			if ((grid[row][col].state == Player2.getColor()) && (Player2.getLastRowPlayed() != 0)
					&& (Player2.getLastColPlayed() != 3)) {
				while ((row < Player2.getLastRowPlayed() - 1) && col > Player2.getLastColPlayed() + 1) {
					col--;
					col = Math.max(0, col);
					row++;
					row = Math.min(3, row);
					System.out.println("@@2");
					grid[row][col].flip();
				}
			}

			// check E
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();
			do {
				col++;
				col = Math.min(3, col);
			} while ((grid[row][col].state == Player1.getColor()) && (col < 3));

			if ((grid[row][col].state == Player2.getColor()) && (Player2.getLastColPlayed() != 3)) {
				while (col > Player2.getLastColPlayed() + 1) {
					col--;
					col = Math.max(0, col);
					System.out.println("@@3");
					grid[row][col].flip();
				}
			}

			// check SE
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();
			do {
				col++;
				col = Math.min(3, col);
				row++;
				row = Math.min(3, row);
			} while ((grid[row][col].state == Player1.getColor()) && (row < 3) && (col < 3));

			if ((grid[row][col].state == Player2.getColor()) && (Player2.getLastRowPlayed() != 3)
					&& (Player2.getLastColPlayed() != 0)) {
				while ((row > Player2.getLastRowPlayed() + 1) && col > Player2.getLastColPlayed() + 1) {
					col--;
					col = Math.max(0, col);
					row--;
					row = Math.max(0, row);
					System.out.println("@@4");
					grid[row][col].flip();
				}
			}

			// check S
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();
			do {
				row++;
				row = Math.min(3, row);
			} while ((grid[row][col].state == Player1.getColor()) && (row < 3));

			if ((grid[row][col].state == Player2.getColor()) && (Player2.getLastRowPlayed() != 3)) {
				while (row > Player2.getLastRowPlayed() + 1) {
					row--;
					row = Math.max(0, row);
					System.out.println("@@5");
					grid[row][col].flip();
				}
			}

			// check SW
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();
			do {
				col--;
				col = Math.max(0, col);
				row++;
				row = Math.min(3, row);
			} while ((grid[row][col].state == Player1.getColor()) && (row < 3) && (col > 0));

			if ((grid[row][col].state == Player2.getColor()) && (Player2.getLastRowPlayed() != 3)
					&& (Player2.getLastColPlayed() != 0)) {
				while ((row > Player2.getLastRowPlayed() + 1) && col < Player2.getLastColPlayed() - 1) {
					col++;
					col = Math.min(3, col);
					row--;
					row = Math.max(0, row);
					System.out.println("@@6");
					grid[row][col].flip();
				}
			}

			// check W
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();
			do {
				col--;
				col = Math.max(0, col);
			} while ((grid[row][col].state == Player1.getColor()) && (col > 0));

			if ((grid[row][col].state == Player2.getColor()) && (Player2.getLastColPlayed() != 0)) {
				while (col < Player2.getLastColPlayed() - 1) {
					col++;
					col = Math.min(3, col);
					System.out.println("@@7");
					grid[row][col].flip();
				}
			}

			// check NW
			row = Player2.getLastRowPlayed();
			col = Player2.getLastColPlayed();
			do {
				col--;
				col = Math.max(0, col);
				row--;
				row = Math.max(0, row);
			} while ((grid[row][col].state == Player1.getColor()) && (row > 0) && (col > 0));

			if ((grid[row][col].state == Player2.getColor()) && (Player2.getLastRowPlayed() != 0)
					&& (Player2.getLastColPlayed() != 0)) {
				while ((row < Player2.getLastRowPlayed() - 1) && col < Player2.getLastColPlayed() - 1) {
					col++;
					col = Math.min(3, col);
					row++;
					row = Math.min(3, row);
					System.out.println("@@8");
					grid[row][col].flip();
				}
			}
		}
		return;
	}
	
	//Display current game status in the console
	public static void displayGrid() {
	
		System.out.println("   1 2 3 4");
		for (int row = 0; row < 4; row++) {
			String rowString = row+1+" |";
			for (int col = 0; col < 4; col++) {
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
		System.out.println("Current score is: White:" + utility()[0] + " Black:" + utility()[1]);
	}

	// Calculate both players current score
	public static int[] utility() {
		int noOfBlack = 0;
		int noOfWhite = 0;
		int[] score = new int[2]; // Score keeper White,Black

		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
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
	// Set each Slot of the grid to "available"
	public static void initializeGrid() {
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				grid[row][col] = new Slot(row, col, "available");
			}
		}
	}

}
