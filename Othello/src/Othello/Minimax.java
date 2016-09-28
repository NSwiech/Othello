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

	
	private Node n1 = new Node(6534,1,2,4,4,666,665);
	int h1 = n1.hashCode(); // interesting.....
	
}
class Node{
	private int parentNodeID = 0;; 	
	private int nodeID = -1; 
	private int row = -1;
	private int col = -1;
	private int value = Integer.MIN_VALUE;
	private int alfa = Integer.MIN_VALUE;
	private int beta = Integer.MAX_VALUE;
	
	//Constructor
	public Node(int v,int a,int b,int row, int col, int ID, int parNodeID){
		this.value = v;
		this.alfa = a;
		this.beta = b;
		this.row = row;
		this.col = col;
		this.nodeID = ID; 
		this.parentNodeID = parNodeID;
		
	}

	public String toString(){
		return "parentID:" + parentNodeID + ", ID:" + nodeID + "Value:" + value + ", row:"+ row + 
				", col:" + col + ", alfa:" + alfa + ", beta:" + beta;
	}
}