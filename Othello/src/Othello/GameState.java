package Othello;

import java.util.ArrayList;

//*****************************
//Nicklas Persson
//Nicolas Swiech
//2016-09-28
//
//*****************************

public class GameState {

	// Some function is called in this class that will recieve the updated grid.
	// From this grid create a set of available moves for the heavy algorithm.
	//
	private Slot[][] gState;
	private ArrayList<Action> availMoves;

	
	// Trying to implement the Minimax
	
	public Action[] minimaxAI(int depth, int currentPlayer) {
		//Let's get all the available moves from the GameState object
		ArrayList<Action> moves = this.getAvailMoves();
		int bestScore;
		//Minimax : the computer wants the best score for him
		if (currentPlayer % 2 == 1) {
			bestScore = Integer.MIN_VALUE;//means -infinite, because we want to make this increase
		}
		else {
			bestScore = Integer.MAX_VALUE;//means +infinite, because we want to make this decrease
		}
		int currentScore;//will be useful to compare with bestScore
		
		if (this.getAvailMoves().isEmpty()){//end of the game
			bestScore = Game.getBlackScore();//calculates the score of the black player (end of the tree)
		}
		else {
			for (Action move : moves){
				
			}
		}
		
		return;
	}
	
		//Getting all the available moves one by one to fill the list
	public ArrayList<Action> findAvailMoves(Slot[][] gState) {
		for (int row = 0 ; row < 3 ; row++) {
			for (int col = 0 ; col < 3 ; col++) {
				if (gState[row][col].getState(gState[row][col]) == "available"){//if a slot is free
					Action tempAction = new Action(row,col); //then create this available move
					availMoves.add(tempAction);//and add this move to the list of available moves
				}
			}
		}
		return availMoves;//returning the list of available moves
		
	}
	
	public Slot[][] getgState() {
		return this.gState;
	}

	public void setgState(Slot[][] gState) {
		this.gState = gState;
	}

	public ArrayList<Action> getAvailMoves() {
		return this.availMoves;
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
