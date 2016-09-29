package Othello;
//*****************************

//Nicklas Persson
//Nicolas Swiech
//2016-09-28
//
//*****************************

import java.util.Scanner;

public class Computer implements Controllable {

	private String color;
	private int row, col;

	public Computer(String color) {
		this.color = color;
	}

	public void play() {
		
		
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
