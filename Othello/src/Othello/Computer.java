package Othello;

import java.util.Scanner;

public class Computer implements Controllable {

	private String color;
	private Scanner rowChoice = new Scanner(System.in);
	private Scanner colChoice = new Scanner(System.in);

	public Computer(String color) {
		this.color = color;
	}

	public void play() {
		boolean played = false;
		while (!played) {
			System.out.println("Choose a row between 1 and 4");
			int row = rowChoice.nextInt() - 1;
			System.out.println("Choose a column between 1 and 4");
			int col = colChoice.nextInt() - 1;

			if (Game.grid[row][col].state == "available") {
				System.out.println("Legal move. You played.");
				Game.grid[row][col].state = "black";
				played = true;
			} else {
				System.out.println("Not legal move.");
			}
		}
	}

	/*
	 * public Slot getLastPlay() { return Game.grid[rowChoice.nextInt() -
	 * 1][colChoice.nextInt() - 1]; }
	 */

	public int getLastRowPlayed() {
		return (rowChoice.nextInt() - 1);
	}

	public int getLastColPlayed() {
		return (colChoice.nextInt() - 1);
	}

	public String getColor() {
		return this.color;
	}

}
