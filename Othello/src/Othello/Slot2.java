package Othello;

import java.awt.Point;

//*****************************
//Nicklas Persson
//Nicolas Swiech
//2016-09-28
//
//*****************************

public class Slot2 {
		private Point pos = new Point();
		private int state;
		// state -1 = black
		// state 0 = available
		// state 1 = white
		
		//Constructor
		public Slot2(Point p, int state) {
			this.pos = p;
			this.state = state;
		}

		public void flip() {
			state = state * -1;
		};
		
		public Point getpos() {
			return this.pos;
		}
		
		public int getState() {
			return this.state;
		}
		
		public void setState(int state) {
			this.state = state;
		}
		
		public boolean hasNextUpRow(int row) {
			int y = pos.y-1;
			return y>=0;
		}
		
		public boolean hasNextDownRow(int row) {
			int y = pos.y+1;
			return y<=3;
		}
		
		public boolean hasNextLeftCol(int col) {
			int x = pos.x-1;
			return x>=0;
		}
		
		public boolean hasNextRightCol(int col) {
			int x = pos.x+1;
			return x<=3;
		}

	};
