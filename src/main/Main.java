package main;

import java.util.ArrayList;
import java.util.List;

import controllers.*;
import ui.Window;

public class Main {
	static int iterations = 5;
	static Window window;
	private static Prisoner player1 = new TitForTat(1);
	private static Prisoner player2 = new User(2);
	private static List<Boolean> moveLog1 = new ArrayList<Boolean>();
	private static List<Boolean> moveLog2 = new ArrayList<Boolean>();
	
	public static void main(String[] args) {
		window = new Window();
		boolean player1Move;
		boolean player2Move;
		
		window.printToConsole(">> PROGRAM INITIALIZED <<");
		
		for (int i = 0; i < iterations; i++) {
			window.printToConsole("Iteration " + (i + 1) + " Commencing");
			player1Move = player1.play();
			player2Move = player2.play();
			
			//Print moves to console
			if (player1Move == false) {
				window.printToConsole("player1 was silent");
			} else {
				window.printToConsole("player1 betrayed player2");
			}
			if (player2Move == false) {
				window.printToConsole("player2 was silent");
			} else {
				window.printToConsole("player2 betrayed player1");
			}
			
			//Evaluate result of decisions
			if (player1Move == false && player2Move == false) {
				player1.sentence(1);
				player2.sentence(1);
				window.printToConsole("both players are jailed for 1 year");
			} else if (player1Move == false && player2Move == true) {
				player1.sentence(3);
				window.printToConsole("player1 is jailed for 3 years");
				window.printToConsole("player2 goes free");
			} else if (player1Move == true && player2Move == false) {
				player2.sentence(3);
				window.printToConsole("player1 goes free");
				window.printToConsole("player2 is jailed for 3 years");
			} else if (player1Move == true && player2Move == true) {
				player1.sentence(2);
				player2.sentence(2);
				window.printToConsole("both players are jailed for 2 years");
			}
			
			moveLog1.add(player1Move);
			moveLog2.add(player2Move);
			window.updateData();
		}
	}
	
	public static Prisoner getPlayer(int id) {
		if (id == 1) {
			return player1;
		} else if (id == 2) {
			return player2;
		} else {
			return null;
		}
	}
	
	public static ArrayList<Boolean> getMoveLog(int id) {
		if (id == 1) {
			return (ArrayList<Boolean>) moveLog1;
		} else if (id == 2) {
			return (ArrayList<Boolean>) moveLog2;
		} else {
			return null;
		}
	}
}