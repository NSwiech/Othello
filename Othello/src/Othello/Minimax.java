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
	
	// a minimizing node and maximizing nodes has different
	// alfa and beta values when new ? true or false?
	private Node defaultNodeTEST = new Node(10,20,30,40);
	private Node[] availMoves;
	
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
		Node[] resultNodes;
		
		for(Node j:allMoves){
			if(j.getValue()>  TO BE CONMTINUED    ){
			}
		}
		return resultNodes;
	}
	private int maxValue(){
		return 777;
	}
	
}

