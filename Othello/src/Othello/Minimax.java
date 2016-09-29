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
	
	// 
	public void dummymentod(){
		Node bacon = new Node(123,123,45,3);
		ArrayList<Node> availMoves = new ArrayList<Node>();
		availMoves.add(bacon);
		alfaBetaSearch(availMoves);
	}
	
	private Node alfaBetaSearch(ArrayList<Node> availMoves){
		Node a1 = new Node();
		return a1;
	}
	
}

