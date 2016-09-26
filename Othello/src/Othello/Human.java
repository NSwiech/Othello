package Othello;

import java.util.Scanner;
public class Human implements Controllable {

	private String color;
	private Scanner rowChoice = new Scanner(System.in);
	private Scanner colChoice = new Scanner(System.in);
	private int row, col;
	//TODO improve input validation suggest input char and using parse to integer 
	//and regular expressions
	//http://stackoverflow.com/questions/2496239/how-do-i-keep-a-scanner-from-throwing-exceptions-when-the-wrong-type-is-entered

	
	public Human(String color) {
		this.color = color;
	}

	public void play() {
		boolean played = false;
		
	   
		while (!played) {
			// Human enters 1-4 computer subtracts 1 to apply to arrays
			do{
				System.out.println("Choose a row between 1 and 4");
				 row = this.rowChoice.nextInt() - 1;
			}while ((row>=1)&&(row<=4)); //This is NOT a solution
			do{
				System.out.println("Choose a column between 1 and 4");
				 col = this.colChoice.nextInt() - 1;
			}while ((col>=1)&&(col<=4)); //This is NOT a solution
			
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
