package Othello;

import java.util.Scanner;

public class Human implements Controllable {

	private String color;
	private int row, col;

	public Human(String color) {
		this.color = color;
	}

	public void play() {
		boolean played = false;

		while (!played) {
			// Human enters 1-4 computer subtracts 1 to apply to arrays
			boolean validRowInput = false;
			while (!validRowInput) {
				System.out.println("Choose a row between 1 and 4");
				Scanner rowChoice = new Scanner(System.in);
				try {
					row = Integer.parseInt(rowChoice.next()) - 1;

				} catch (NumberFormatException e) {
					System.out.println("Wrong input!\n");
				}
				if ((row >= 0) && (row < 4)) {
					validRowInput = true;
				}
			}

			boolean validColInput = false;
			while (!validColInput) {
				System.out.println("Choose a column between 1 and 4");
				Scanner colChoice = new Scanner(System.in);
				try {
					col = Integer.parseInt(colChoice.next()) - 1;

				} catch (NumberFormatException e) {
					System.out.println("Wrong input!\n");
				}
				if ((col >= 0) && (col < 4)) {
					validColInput = true;
				}
			}


			if (Game.getStateSlot(row, col).equals("available")) {

			if (Game.getStateSlot(row, col) == "available") {

				System.out.println("Legal move. You played.");

				Game.setStateSlot(row, col, "White");

				played = true;
			} else {
				System.out.println("Not legal move.");
			}
		}
		}

	}

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
