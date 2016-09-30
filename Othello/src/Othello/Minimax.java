package Othello;

import java.util.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

// *****************************
// Nicklas Persson
// Nicolas Swiech
// 2016-09-28
//
// *****************************

//TODO
	//The following shall be printed after each draw:
	//  The current status of the board --CHECK
	//  The depth of the search
	//  How many nodes were examined
	//
	//A computer draw shall not take longer than 5 seconds

//**************************************************

public class Minimax {
	// Nicolas area
	//**************************************************
	public ArrayList<int[]> getActions(Slot[][] gState){
		ArrayList<int[]> legalMoves = new ArrayList<int[]>();
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){	
				// if a slot is free
				if (gState[row][col].getState() == "available") {
					// checking if not out of boundaries
					if ((gState[row][col].hasNextDownRow(row)) && (gState[row][col].hasNextUpRow(row))
					&& (gState[row][col].hasNextLeftCol(col)) && (gState[row][col].hasNextRightCol(col))) {
						// counter of opponent disks around
						int opponentDisks = 0;
						for (int localRow = -1; localRow == 1; localRow++){
							for (int localCol = -1; localCol == 1; localCol++) {
								if (gState[row][col].getState() == "White") {
									opponentDisks++;
								}
							}
						}
						if (opponentDisks > 0) {
							int[] move = null;
							move[0] = row;
							move[1] = col;
							legalMoves.add(move);
						}
						
					}else {
						throw new NoSuchElementException();
					}
				}
			}
		}
			return legalMoves;// returning the list of legalMoves
		}

	public int getUtility(Slot[][] gState, String playerColor){
		int outcome = 0;	
		for(int row = 0; row < 4; row++) {
			for(int col = 0; col < 4; col++) {
				if (gState[row][col].getState().equals(playerColor)){
					outcome++;
				}
			}
		}
		return outcome;
	}

	//_________________________________________________________
	
	// **** Nicklas area *******
	private final int MAX_DEPTH = 5; //search cut-off
	private int searchdepth; //  The depth of the search
	private int noOfNodesXd; //  How many nodes were examined
	
	private int[] availMoves; // First filter result
	private int[] proxMoves; // First filter result
	private int[] legalMoves;// First filter result
	
	// a minimizing node and maximizing nodes has different
	// alfa and beta values when new ? true or false?
	private Node defaultNodeTEST = new Node(10,20,30,40);
	
	
	//-1 = black 2 = available 1 = white 
	private int[] ctate = new int[16]; 
	
	//Constructor
	public Minimax(){
		availMoves = initAvailMoves();
	}
	
	// Set each Node to value 0 heap of leafs
	// returns an array of Nodes
	public Node[] initAvailMoves() {
		Node[] aMoves = null;
		int n=0;
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				//Node(int v,int a,int b,int row, int col, int ID, int parNodeID){
				availMoves[n++] = new Node(0, row, col, -1);
			}
		}
		return aMoves;
	}
	
	// xxx
	public void dummymentod(){
		Node bacon = new Node(123,123,45,3);
		ArrayList<Node> availMoves = new ArrayList<Node>();
		availMoves.add(bacon);
		alfaBetaSearch(availMoves);
	}
	
	// Returns a Node that contains the row and column that is the best move
	private Node alfaBetaSearch(Node[] moves){
		Node[] allMoves;
		allMoves = moves;
		Node[] resultNodes;//result to be returned
		
		for(Node j:allMoves){
			if(j.getValue()>  TO BE CONTINUED    ){
			}
		}
		return resultNodes;
	}
	
	private int maxValue(int[] Ztat, int alfa, int beta ,int depth, int maxDepth){
		if(terminalTest(Zstat) || depth >= maxDepth) {
			return util(Ztat); // returns a value and a 'move'
		}else{
			legalMovesList = generateLegalMoves(sZtat);
			if (legalMovesList.lenght == 0){
				
			}
			
		}
		
		return 777;
	}
	
	private int minValue(){
		return 777;
	}
}

