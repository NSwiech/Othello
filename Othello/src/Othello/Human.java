package Othello;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Human implements Controllable {

	private String color;
	private int row, col;

	// TODO improve input validation suggest input char and using parse to
	// integer
	// and regular expressions
	// http://stackoverflow.com/questions/2496239/how-do-i-keep-a-scanner-from-throwing-exceptions-when-the-wrong-type-is-entered

	public Human(String color) {
		this.color = color;
	}

	public void play() {
		boolean played = false;

		while (!played) {
			// Human enters 1-4 computer subtracts 1 to apply to arrays

			do {
				System.out.println("Choose a row between 1 and 4");
				Scanner rowChoice = new Scanner(System.in);
				try {
					row = rowChoice.nextInt() - 1;

				} catch (InputMismatchException e1) {
					System.out.println("Wrong input!\n");
				}
			} while ((row < 0) || (row > 5));

			do {
				System.out.println("Choose a column between 1 and 4");
				Scanner colChoice = new Scanner(System.in);
				try {
					col = colChoice.nextInt() - 1;

				} catch (InputMismatchException e2) {
					System.out.println("Wrong input!\n");
				}
			} while ((col < 0) || (col > 5));

			if (Game.grid[row][col].state == "available") {
				System.out.println("Legal move. You played.");
				Game.grid[row][col].state = "White";
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
