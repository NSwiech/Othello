package Othello;

import java.util.Scanner;

public class Computer implements Controllable {

	private String color;

	public Computer(String color) {
		this.color = color;
	}

	public void play() {
		boolean played = false;
		while (!played) {

			if (Game.grid[1][1].state == "available") {
				
				played = true;
			} else {
			
			}
		}
	}

	/*
	 * public Slot getLastPlay() { return Game.grid[rowChoice.nextInt() -
	 * 1][colChoice.nextInt() - 1]; }
	 */

	public int getLastRowPlayed() {
		return (1);
	}

	public int getLastColPlayed() {
		return (1);
	}

	public String getColor() {
		return this.color;
	}

}
