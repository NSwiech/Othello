package Othello;
//*****************************
//Nicklas Persson
//Nicolas Swiech
//2016-09-28
//
//*****************************

public class Node {
	
		private int parentNodeID = -666;; 	
		private int nodeID = -1; 
		private int row = -1;
		private int col = -1;
		private int value = Integer.MIN_VALUE;
		private int alfa = Integer.MIN_VALUE;
		private int beta = Integer.MAX_VALUE;
		private int nodeIDCounter=0;
		
		//Constructors
		public Node(int v,int a,int b,int row, int col, int ID, int parNodeID){
			this.value = v;
			this.alfa = a;
			this.beta = b;
			this.row = row;
			this.col = col;
			this.nodeID = ID; 
			this.parentNodeID = parNodeID;	
		}
		// Nicklas Experiment...
		// Constructor with some default values
		public Node(int v,int row, int col, int parNodeID){
			this.value = v;
			this.row = row;
			this.col = col;
			nodeIDCounter++; //count up when this constructor is used
			this.nodeID = nodeIDCounter; 
			this.parentNodeID = parNodeID;	
		}
		public Node(){
			
		}
		
		public int compare(Node n1){
			int result = 42;
			if (this.value > n1.value){
				result = 1;
			}
			if (this.value < n1.value){
				result = -1;
			}
			if (this.value == n1.value){
				result = 0;
			}
			return result;
		}

		public String toString(){
			return "parentID:" + parentNodeID + ", ID:" + nodeID + "Value:" + value + ", row:"+ row + 
					", col:" + col + ", alfa:" + alfa + ", beta:" + beta;
		}
		
		public int getParentNodeID() {
			return parentNodeID;
		}
		public void setParentNodeID(int parentNodeID) {
			this.parentNodeID = parentNodeID;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public int getAlfa() {
			return alfa;
		}
		public void setAlfa(int alfa) {
			this.alfa = alfa;
		}
		public int getBeta() {
			return beta;
		}
		public void setBeta(int beta) {
			this.beta = beta;
		}
		public int getNodeID() {
			return nodeID;
		}
		public int getRow() {
			return row;
		}
		public int getCol() {
			return col;
		}

	}
	
