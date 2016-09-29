package Othello;
//*****************************
//Nicklas Persson
//Nicolas Swiech
//2016-09-28
//
//*****************************

public class Game {

	private static Slot[][] grid = new Slot[4][4];
	private boolean actions[][] = new boolean[4][4];
	private static final String White = "White";
	private static final String Black = "Black";
	private Human Player1 = new Human(White);
	private Computer Player2 = new Computer(Black);
	private GameState gState = new GameState(grid);
	private static int whiteScore, blackScore;

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
			if (currentPlayer % 2 == 0) {
				System.out.println("\nThe White Player has to play.");
				Player1.play();
			} else {
				System.out.println("\nThe Black Player has to play.");
				Player2.play();
			}
			updateGrid(currentPlayer);
			gState.setgState(grid);
			displayGrid();

			currentPlayer++;
			if (currentPlayer == 16) {
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

	// flips slots in the grid after a players make a move
	public void updateGrid(int currentPlayer) {
		int rowW, colW, rowB, colB;
		rowW = Player1.getLastRowPlayed();
		colW = Player1.getLastColPlayed();
		rowB = Player2.getLastRowPlayed();
		colB = Player2.getLastColPlayed();
		checksP1 chkp1 = new checksP1();
		checksP2 chkp2 = new checksP2();
		if (currentPlayer % 2 == 0) {

			if (rowW > 1) {
				chkp1.checkN_P1(rowW, colW);
			}
			if ((rowW > 1) && (colW < 2)) {
				chkp1.checkNEP1(rowW, colW);
			}
			if ((colW < 2)) {
				chkp1.checkE_P1(rowW, colW);
			}
			if ((rowW < 2) && (colW < 2)) {
				chkp1.checkSEP1(rowW, colW);
			}
			if ((rowW < 2)) {
				chkp1.checkS_P1(rowW, colW);
			}
			if ((rowW < 2) && (colW > 1)) {
				chkp1.checkSWP1(rowW, colW);
			}
			if ((colW > 1)) {
				chkp1.checkW_P1(rowW, colW);
			}
			if ((rowW > 1) && (colW > 1)) {
				chkp1.checkNWP1(rowW, colW);
			}
		} else {

			if (rowB > 1) {
				chkp2.checkN_P2(rowB, colB);
			}
			if ((rowB > 1) && (colB < 2)) {
				chkp2.checkNEP2(rowB, colB);
			}
			if ((colB < 2)) {
				chkp2.checkE_P2(rowB, colB);
			}
			if ((rowB < 2) && (colB < 2)) {
				chkp2.checkSEP2(rowB, colB);
			}
			if ((rowB < 2)) {
				chkp2.checkS_P2(rowB, colB);
			}
			if ((rowB < 2) && (colB > 1)) {
				chkp2.checkSWP2(rowB, colB);
			}
			if ((colB > 1)) {
				chkp2.checkW_P2(rowB, colB);
			}
			if ((rowB > 1) && (colB > 1)) {
				chkp2.checkNWP2(rowB, colB);
			}
		}
		calculateWScore();
		calculateBScore();
	}

	public class checksP1 {
		// check N (North for Player1)
		public void checkN_P1(int rw, int cl) {
			int row = rw;
			int col = cl;
			// TODO perhaps, if beneficial
			// to avoid making the same calls 4 times * 8 functions
			// perhaps make them parameters to the function and call them
			// outside just once
			// speeds up execution ??
			//
			// String P1Color = p1color;
			// String P2Color = p2color;
			// int P1LastRowPlayed = p1lastrowplayed;

			// Step North until end of board or
			// until no more slots of opposite colour are found
			do {
				row--;
				row = Math.max(0, row);
			} while ((grid[row][col].getState(grid[row][col]) == Player2.getColor() && (row > 0)));
			// Now go south and flip all slots BETWEEN the position found above
			// to the slot position of the last move
			if ((grid[row][col].getState(grid[row][col]) == Player1.getColor())
					&& ((Player1.getLastRowPlayed() != 0))) {
				while (row < Player1.getLastRowPlayed() - 1) {
					row++;
					row = Math.min(3, row);
					// TODO
					// setup a global debug variable and the debug tools can
					// stay in the code
					// when debug is needed set it to true where it is defined
					// if (globalBoolDebug){
					System.out.println("@1");
					// }
					grid[row][col].flip();
				}
			}
		}

		// check NE (North East)
		public void checkNEP1(int rw, int cl) {
			int row = rw;
			int col = cl;
			do {
				col++;
				col = Math.min(3, col);
				row--;
				row = Math.max(0, row);
			} while ((grid[row][col].getState(grid[row][col]) == Player2.getColor()) && (row > 0) && (col < 3));

			if ((grid[row][col].getState(grid[row][col]) == Player1.getColor()) && (Player1.getLastRowPlayed() != 0)
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
		}

		// check E
		public void checkE_P1(int rw, int cl) {
			int row = rw;
			int col = cl;
			do {
				col++;
				col = Math.min(3, col);
			} while ((grid[row][col].getState(grid[row][col]) == Player2.getColor()) && (col < 3));

			if ((grid[row][col].getState(grid[row][col]) == Player1.getColor()) && (Player1.getLastColPlayed() != 3)) {
				while (col > Player1.getLastColPlayed() + 1) {
					col--;
					col = Math.max(0, col);
					System.out.println("@3");
					grid[row][col].flip();
				}
			}
		}

		// check SE
		public void checkSEP1(int rw, int cl) {
			int row = rw;
			int col = cl;
			do {
				col++;
				col = Math.min(3, col);
				row++;
				row = Math.min(3, row);
			} while ((grid[row][col].getState(grid[row][col]) == Player2.getColor()) && (row < 3) && (col < 3));

			if ((grid[row][col].getState(grid[row][col]) == Player1.getColor()) && (Player1.getLastRowPlayed() != 3)
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
		}

		// check S
		public void checkS_P1(int rw, int cl) {
			int row = rw;
			int col = cl;
			do {
				row++;
				row = Math.min(3, row);
			} while ((grid[row][col].getState(grid[row][col]) == Player2.getColor()) && (row < 3));

			if ((grid[row][col].getState(grid[row][col]) == Player1.getColor()) && (Player1.getLastRowPlayed() != 3)) {
				while (row > Player1.getLastRowPlayed() + 1) {
					row--;
					row = Math.max(0, row);
					System.out.println("@5");
					grid[row][col].flip();
				}
			}
		}

		// check SW
		public void checkSWP1(int rw, int cl) {
			int row = rw;
			int col = cl;
			do {
				col--;
				col = Math.max(0, col);
				row++;
				row = Math.min(3, row);
			} while ((grid[row][col].getState(grid[row][col]) == Player2.getColor()) && (row < 3) && (col > 0));

			if ((grid[row][col].getState(grid[row][col]) == Player1.getColor()) && (Player1.getLastRowPlayed() != 3)
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
		}

		// check W
		public void checkW_P1(int rw, int cl) {
			int row = rw;
			int col = cl;
			do {
				col--;
				col = Math.max(0, col);
			} while ((grid[row][col].getState(grid[row][col]) == Player2.getColor()) && (col > 0));

			if ((grid[row][col].getState(grid[row][col]) == Player1.getColor()) && (Player1.getLastColPlayed() != 0)) {

				while (col < Player1.getLastColPlayed() - 1) {
					col++;
					col = Math.min(3, col);
					System.out.println("@7");
					System.out.println(row + "" + col + "" + grid[row][col].getState(grid[row][col]));
					grid[row][col].flip();
					System.out.println(row + "" + col + "" + grid[row][col].getState(grid[row][col]));
				}
			}
		}

		// check NW
		public void checkNWP1(int rw, int cl) {
			int row = rw;
			int col = cl;
			do {
				col--;
				col = Math.max(0, col);
				row--;
				row = Math.max(0, row);
			} while ((grid[row][col].getState(grid[row][col]) == Player2.getColor()) && (row > 0) && (col > 0));

			if ((grid[row][col].getState(grid[row][col]) == Player1.getColor()) && (Player1.getLastRowPlayed() != 0)
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

	}

	class checksP2 {
		// check N
		public void checkN_P2(int rw, int cl) {
			int row = rw;
			int col = cl;
			do {
				row--;
				row = Math.max(0, row);
			} while ((grid[row][col].getState(grid[row][col]) == Player1.getColor() && (row > 0)));

			if ((grid[row][col].getState(grid[row][col]) == Player2.getColor())
					&& ((Player2.getLastRowPlayed() != 0))) {
				while (row < Player2.getLastRowPlayed() - 1) {
					row++;
					row = Math.min(3, row);
					System.out.println("@@1");
					grid[row][col].flip();
				}
			}
		}

		// check NE
		public void checkNEP2(int rw, int cl) {
			int row = rw;
			int col = cl;
			do {
				col++;
				col = Math.min(3, col);
				row--;
				row = Math.max(0, row);
			} while ((grid[row][col].getState(grid[row][col]) == Player1.getColor()) && (row > 0) && (col < 3));

			if ((grid[row][col].getState(grid[row][col]) == Player2.getColor()) && (Player2.getLastRowPlayed() != 0)
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
		}

		// check E
		public void checkE_P2(int rw, int cl) {
			int row = rw;
			int col = cl;
			do {
				col++;
				col = Math.min(3, col);
			} while ((grid[row][col].getState(grid[row][col]) == Player1.getColor()) && (col < 3));

			if ((grid[row][col].getState(grid[row][col]) == Player2.getColor()) && (Player2.getLastColPlayed() != 3)) {
				while (col > Player2.getLastColPlayed() + 1) {
					col--;
					col = Math.max(0, col);
					System.out.println("@@3");
					grid[row][col].flip();
				}
			}
		}

		// check SE
		public void checkSEP2(int rw, int cl) {
			int row = rw;
			int col = cl;
			do {
				col++;
				col = Math.min(3, col);
				row++;
				row = Math.min(3, row);
			} while ((grid[row][col].getState(grid[row][col]) == Player1.getColor()) && (row < 3) && (col < 3));

			if ((grid[row][col].getState(grid[row][col]) == Player2.getColor()) && (Player2.getLastRowPlayed() != 3)
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
		}

		// check S
		public void checkS_P2(int rw, int cl) {
			int row = rw;
			int col = cl;
			do {
				row++;
				row = Math.min(3, row);
			} while ((grid[row][col].getState(grid[row][col]) == Player1.getColor()) && (row < 3));

			if ((grid[row][col].getState(grid[row][col]) == Player2.getColor()) && (Player2.getLastRowPlayed() != 3)) {
				while (row > Player2.getLastRowPlayed() + 1) {
					row--;
					row = Math.max(0, row);
					System.out.println("@@5");
					grid[row][col].flip();
				}
			}
		}

		// check SW
		public void checkSWP2(int rw, int cl) {
			int row = rw;
			int col = cl;
			do {
				col--;
				col = Math.max(0, col);
				row++;
				row = Math.min(3, row);
			} while ((grid[row][col].getState(grid[row][col]) == Player1.getColor()) && (row < 3) && (col > 0));

			if ((grid[row][col].getState(grid[row][col]) == Player2.getColor()) && (Player2.getLastRowPlayed() != 3)
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
		}

		// check W
		public void checkW_P2(int rw, int cl) {
			int row = rw;
			int col = cl;
			do {
				col--;
				col = Math.max(0, col);
			} while ((grid[row][col].getState(grid[row][col]) == Player1.getColor()) && (col > 0));

			if ((grid[row][col].getState(grid[row][col]) == Player2.getColor()) && (Player2.getLastColPlayed() != 0)) {
				while (col < Player2.getLastColPlayed() - 1) {
					col++;
					col = Math.min(3, col);
					System.out.println("@@7");
					grid[row][col].flip();
				}
			}
		}

		// check NW
		public void checkNWP2(int rw, int cl) {
			int row = rw;
			int col = cl;
			do {
				col--;
				col = Math.max(0, col);
				row--;
				row = Math.max(0, row);
			} while ((grid[row][col].getState(grid[row][col]) == Player1.getColor()) && (row > 0) && (col > 0));

			if ((grid[row][col].getState(grid[row][col]) == Player2.getColor()) && (Player2.getLastRowPlayed() != 0)
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

	}

	// Display current game status in the console

	public void displayGrid() {

		System.out.println("   1 2 3 4");
		for (int row = 0; row < 4; row++) {
			String rowString = row + 1 + " |";
			for (int col = 0; col < 4; col++) {
				if (grid[row][col].getState(grid[row][col]) == "available") {
					rowString = rowString + " |";
				} else if (grid[row][col].getState(grid[row][col]).equals(White)) {
					rowString = rowString + "W|";
				} else {
					rowString = rowString + "B|";
				}
			}
			System.out.println(rowString);
		}
		System.out.println("Current score is: White:" + Game.whiteScore + " Black:" + Game.blackScore);
	}

	// Calculate white player score
	public int calculateWScore() {
		Game.whiteScore = 0;	
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				if (grid[row][col].getState(grid[row][col]).equals(White)) {
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
				if (grid[row][col].getState(grid[row][col]).equals(Black)) {
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
		return grid[row][col].getState(grid[row][col]);
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

}
