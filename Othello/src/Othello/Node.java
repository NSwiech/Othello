package Othello;

import java.util.List;

public class Node {
	private String parentNodeID;//ID of the parent node
	private List<Node> children = null;
	
	//private String[] childrenIDs; // is knowing you parent enough. 
	//does parent need to store child names?
	
	private String nodeID; //ID of the node
	private int value = Integer.MIN_VALUE;
	private int alfa = Integer.MIN_VALUE;
	private int beta = Integer.MAX_VALUE;
	//private GameState 
	
	//Constructor
	public Node(int v,int a,int b, String parNodeID){
		this.value = v;
		this.alfa = a;
		this.beta = b;
		this.parentNodeID = parNodeID;
	//	this.GameState
	}
	
	// this way we probably don't need Tree.java to build the tree
	public void addChild(Node child){
		children.add(child);
	}
	
	public String toString(){
		return "ID:" + nodeID + "Value:" + value + " alfa:" + alfa + ", beta:" + beta;
	}
}
