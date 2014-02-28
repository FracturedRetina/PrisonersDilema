package ui;

import java.awt.GridLayout;

import javax.swing.JLabel;

import main.Prisoner;

public class PlayerStatusPane extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel id = new JLabel("Id: ", JLabel.CENTER);
	private JLabel algorithm = new JLabel("Algorithm: ", JLabel.CENTER);
	private JLabel yearsServed = new JLabel("Years Served: ", JLabel.CENTER);
	private JLabel silent = new JLabel("Silent: ", JLabel.CENTER);
	private JLabel betray = new JLabel("Betrayed: ", JLabel.CENTER);
	
	public PlayerStatusPane(String title) {
		this.setPreferredSize(new java.awt.Dimension(230, 60));
		this.setLayout(new GridLayout(3,2));
		
		this.add(new JLabel(title, JLabel.CENTER));
		this.add(id);
		this.add(algorithm);
		this.add(yearsServed);
		this.add(silent);
		this.add(betray);
	}
	public PlayerStatusPane(String title, Prisoner prisoner) {
		this.setPreferredSize(new java.awt.Dimension(230, 60));
		this.setLayout(new GridLayout(3,2));
		
		this.add(new JLabel(title, JLabel.CENTER));
		this.add(id);
		this.add(algorithm);
		this.add(yearsServed);
		this.add(silent);
		this.add(betray);
		
		this.update(prisoner);
	}
	
	public void update(Prisoner prisoner) {
		id.setText("Id: " + prisoner.id);
		algorithm.setText("Algorithm: " + prisoner.getClass().getSimpleName());
		yearsServed.setText("Years Served: " + prisoner.getYearsServed());
		if (prisoner.timesSilent() == 1) {
			silent.setText("Silent: 1 time");
		} else {
			silent.setText("Silent: " + prisoner.timesSilent() + " times");
		}
		
		if (prisoner.timesBetrayed() == 1) {
			betray.setText("Betrayed: 1 time");
		} else {
			betray.setText("Betrayed: " + prisoner.timesBetrayed() + " times");
		}
	}
}