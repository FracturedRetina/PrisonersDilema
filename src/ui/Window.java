package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;

import main.Main;

public class Window extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JSplitPane contentPane = new JSplitPane();
	private JTextPane console = new JTextPane();
	private JSplitPane playerStatus = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	private PlayerStatusPane player1Status = new PlayerStatusPane("Player 1", Main.getPlayer(1));
	private PlayerStatusPane player2Status = new PlayerStatusPane("Player 2", Main.getPlayer(2));
	
	public Window() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setPreferredSize(new Dimension(640, 480));
		this.setTitle("Prisoners Dilemma");
		
		this.add(contentPane);
			contentPane.setDividerLocation(320 - contentPane.getDividerSize());
			contentPane.setLeftComponent(new JScrollPane(console));
				console.setEditable(false);
				console.setForeground(Color.GREEN);
				console.setBackground(Color.BLACK);
				console.setFont(new Font("Courier New", Font.PLAIN, 16));
			contentPane.setRightComponent(playerStatus);
				playerStatus.setDividerLocation(240 - playerStatus.getDividerSize());
				playerStatus.setTopComponent(player1Status);
				playerStatus.setBottomComponent(player2Status);
					
		
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void updateData() {
		player1Status.update(Main.getPlayer(1));
		player2Status.update(Main.getPlayer(2));
	}
	
	public void printToConsole(String str) {
		this.console.setText(console.getText() + str + "\n");
	}
}