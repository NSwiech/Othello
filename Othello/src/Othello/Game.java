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
			updateGridVersion2(currentPlayer);
			displayGrid();

			currentPlayer++;
			if (currentPlayer == 16) {
				victory = true;
				if (utility()[0] == utility()[1]) {
					System.out.println("The game ends in a tie!");
				} else {
					System.out.println("The White Player ends with a score of " + utility()[0]);
					System.out.println("The Black Player ends with a score of " + utility()[1]);
				}
			}
		}
	}

	public void updateGrid(int currentPlayer) {
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

	// Nicklas Experiment
	public void updateGridVersion2(int currentPlayer) {
		int row, col;
		Game.checksP1 chkp1 = new Game.checksP1();
		Game.checksP2 chkp2 = new Game.checksP2();

		if (currentPlayer % 2 == 0) {
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();

			chkp1.checkN4P1(row, col);
			chkp1.checkNE4P1(row, col);
			chkp1.checkE4P1(row, col);
			chkp1.checkSE4P1(row, col);

			chkp1.checkS4P1(row, col);
			chkp1.checkSW4P1(row, col);
			chkp1.checkW4P1(row, col);
			chkp1.checkNW4P1(row, col);
		} else {
			row = Player1.getLastRowPlayed();
			col = Player1.getLastColPlayed();

			chkp2.checkN4P2(row, col);
			chkp2.checkNE4P2(row, col);
			chkp2.checkE4P2(row, col);
			chkp2.checkSE4P2(row, col);

			chkp2.checkS4P2(row, col);
			chkp2.checkSW4P2(row, col);
			chkp2.checkW4P2(row, col);
			chkp2.checkNW4P2(row, col);
		}

	}
	public class checksP1 {
		// check N (North for Player1)
		public void checkN4P1(int rw, int cl) {
			int row = rw;
			int col = cl;
			// to avoid making the same calls 4 times * 8 functions
			// lets make them parameters to the function and call them outside just once
			//String P1Color = p1color;
			//String P2Color = p2color;
			//int P1LastRowPlayed = p1lastrowplayed;
			
			//if (row>0){ //border check for north only. Skipps case when on border
			do {
				row--;
				row = Math.max(0, row);
			} while ((grid[row][col].state == Player2.getColor() && (row > 0)));

			if ((grid[row][col].state == Player1.getColor()) && ((Player1.getLastRowPlayed() != 0))) {
				while (row < Player1.getLastRowPlayed() - 1) {
					row++;
					row = Math.min(3, row);
					//setup a global debug variable and the debug tools can stay in the code
					//when debug is needed set it to true where it is defined
					//if (globalBoolDebug){ 
						System.out.println("@1");
					//}
					grid[row][col].flip();
				}
			}
		}
		
		// check NE (North East)
		public void checkNE4P1(int rw, int cl) {
			int row = rw;
			int col = cl;
			//if ((row>0)&&(col<3)){ //border check for northeast only. Skipps case when on border
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
		}

		// check E
		public void checkE4P1(int rw, int cl) {
			int row = rw;
			int col = cl;
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
		}

		// check SE
		public void checkSE4P1(int rw, int cl) {
			int row = rw;
			int col = cl;
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
		}

		// check S
		public void checkS4P1(int rw, int cl) {
			int row = rw;
			int col = cl;
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
		}

		// check SW
		public void checkSW4P1(int rw, int cl) {
			int row = rw;
			int col = cl;
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
		}

		// check W
		public void checkW4P1(int rw, int cl) {
			int row = rw;
			int col = cl;
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
		}

		// check NW
		public void checkNW4P1(int rw, int cl) {
			int row = rw;
			int col = cl;
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

	}

	class checksP2 {
		// check N
		public void checkN4P2(int rw, int cl) {
			int row = rw;
			int col = cl;
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
		}

		// check NE
		public void checkNE4P2(int rw, int cl) {
			int row = rw;
			int col = cl;
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
		}

		// check E
		public void checkE4P2(int rw, int cl) {
			int row = rw;
			int col = cl;
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
		}

		// check SE
		public void checkSE4P2(int rw, int cl) {
			int row = rw;
			int col = cl;
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
		}

		// check S
		public void checkS4P2(int rw, int cl) {
			int row = rw;
			int col = cl;
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
		}

		// check SW
		public void checkSW4P2(int rw, int cl) {
			int row = rw;
			int col = cl;
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
		}

		// check W
		public void checkW4P2(int rw, int cl) {
			int row = rw;
			int col = cl;
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
		}

		// check NW
		public void checkNW4P2(int rw, int cl) {
			int row = rw;
			int col = cl;
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

	}

	// Display current game status in the console
	public static void displayGrid() {

		System.out.println("   1 2 3 4");
		for (int row = 0; row < 4; row++) {
			String rowString = row + 1 + " |";
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
