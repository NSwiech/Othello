package Othello;

import java.util.Scanner;

public class Computer implements Controllable {

	private String color;
	private Scanner rowChoice = new Scanner(System.in);
	private Scanner colChoice = new Scanner(System.in);
	private int row, col;
	
	public Computer(String color) {
		this.color = color;
	}

	public void play() {
		boolean played = false;
		while (!played) {
			
			System.out.println("Choose a row between 1 and 4");
			row = this.rowChoice.nextInt() - 1;
			System.out.println("Choose a column between 1 and 4");
			col = this.colChoice.nextInt() - 1;

			if (Game.grid[row][col].state == "available") {
				System.out.println("Legal move. You played.");
				Game.grid[row][col].state = "Black";
				played = true;
			} else {
				System.out.println("Not legal move.");
			}
		}
		return;
	}

	/*
	 * public Slot getLastPlay() { return Game.grid[rowChoice.nextInt() -
	 * 1][colChoice.nextInt() - 1]; }
	 */

	public int getLastRowPlayed() {
		return this.row;
		
	}

	public int getLastColPlayed() {
		return this.col;
	}

	public String getColor() {
		return this.color;
	}
}
