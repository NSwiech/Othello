package Othello;



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

	
	
}
class Node{
	private Node parentNode;//nodeID instead perhaps? 
	private Node leftChildNode; //nodeID instead perhaps?
	private Node rightChildNode; //nodeID instead perhaps?
	private String nodeID; //hash hmmmm howto do?
	private int value = Integer.MIN_VALUE;
	private int alfa = Integer.MIN_VALUE;
	private int beta = Integer.MAX_VALUE;
	
	//Constructor
	public Node(int v,int a,int b, Node parNode){
		this.value = v;
		this.alfa = a;
		this.beta = b;
		this.parentNode = parNode;
	}
	
	public String toString(){
		return "ID:" + nodeID + "Value:" + value + " alfa:" + alfa + ", beta:" + beta;
	}
}