package Othello;
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

	
	private Node n1 = new Node(6534,1,2,"jox");
	int h1 = n1.hashCode(); // interesting.....
	
}
class Node{
	private int parentNodeID; 
	
	//private String[] childrenIDs; // is knowing you parent enough. 
	//does parent need to store child names?
	
	private int nodeID; 
	private int row=-1;
	private int col=-1;
	private int value = Integer.MIN_VALUE;
	private int alfa = Integer.MIN_VALUE;
	private int beta = Integer.MAX_VALUE;
	
	//Constructor
	public Node(int v,int a,int b,int row,int col, int parNodeID){
		this.row = row;
		this.col = col;
		this.value = v;
		this.alfa = a;
		this.beta = b;
		this.parentNodeID = parNodeID;
	}

	public String toString(){
		return "ID:" + nodeID + "Value:" + value + " alfa:" + alfa + ", beta:" + beta;
	}
}