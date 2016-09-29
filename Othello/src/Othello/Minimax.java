package Othello;

import java.util.*;

// *****************************
// Nicklas Persson
// Nicolas Swiech
// 2016-09-28
//
// *****************************

public class Minimax {
	private final int MAX_DEPTH = 16; //search cut-off
	private int searchdepth; //  The depth of the search
	private int noOfNodesXd; //  How many nodes were examined
	
	//TODO
	//The following shall be printed after each draw:
	//  The current status of the board --CHECK
	//  The depth of the search
	//  How many nodes were examined
	//
	//A computer draw shall not take longer than 5 seconds

	private Slot[][] board = new Slot[4][4];
	private Node rootTEST = new Node(1,2,3,4,5,6,7);
	// a minimizing node and maximizing nodes has different
	// alfa and beta values when new ? true or false?
	private Node defaultNodeTEST = new Node(10,20,30,40);
	
	//private ArrayList<Integer> availMoves = new ArrayList<Integer>();
	public void dumymethod(){
		Node[] themNodes;
		Node aNode = new Node();
		themNodes = new Node[3];
		themNodes[0] = rootTEST;
		themNodes[1] = rootTEST;
		themNodes[2] = rootTEST;
		AlfaBetaSearch(themNodes);
		
	}
	
	public void AlfaBetaSearch(Node[] availMoves){
		Node[] sock = new Node[0];
		System.arraycopy(availMoves,0,sock,0,2);
	}
}


