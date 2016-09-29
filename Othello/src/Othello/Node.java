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
	
