package Othello;

public class Node {
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
