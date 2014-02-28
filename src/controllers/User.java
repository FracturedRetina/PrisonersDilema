package controllers;

import javax.swing.JOptionPane;

import main.Prisoner;

public class User extends Prisoner {
	public User(int id) {
		super(id);
	}

	@Override
	public boolean play() {
		int choice = JOptionPane.showConfirmDialog(null, "Player " + id + " betray other prisoner?", "Betray?", JOptionPane.YES_NO_OPTION);
		
		if (choice == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
}