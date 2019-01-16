package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.HuntTheWumpusGame;

/**
 * Author: Steven Chin
 * TextField view of the Hunt the Wumpus Game which renders a 2d board
 * and allows the player to click their moves and be updated accordingly
 */

@SuppressWarnings("serial")
public class TextFieldView extends JPanel implements Observer {
	
	JTextArea gameBoard = new JTextArea();
	public JLabel status = new JLabel("Make your move");
	
	JLabel move = new JLabel("Move");
	JLabel shoot = new JLabel("Shoot");
	
	JButton moveUp = new JButton();
	JButton moveDown = new JButton();
	JButton moveLeft = new JButton();
	JButton moveRight = new JButton();
	
	JButton shootUp = new JButton();
	JButton shootDown = new JButton();
	JButton shootLeft = new JButton();
	JButton shootRight = new JButton();
	
	private HuntTheWumpusGame theGame;
	private String board;
	
	public TextFieldView(HuntTheWumpusGame HuntTheWumpusGame) {
		theGame = HuntTheWumpusGame;
		initializeButtons();
		initializeTextPanel();
	}
	
	private void initializeTextPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		board = theGame.toString();
		gameBoard.setText(board);
		gameBoard.setFont(new Font(Font.MONOSPACED, 1, 28));
		gameBoard.setSize(750, 400);
		gameBoard.setLocation(200, 25);
		add(gameBoard);
		
		status.setText("Make your move");
		status.setSize(300, 20);
		status.setFont(new Font("SmallBold", Font.BOLD, 14));
		status.setLocation(375, 450);
		add(status);
		
		enableButtons();
	}
	
	public void initializeButtons() {
		ButtonListener buttonListener = new ButtonListener();
		
		move.setSize(50, 50);
		move.setLocation(75, 25);
		add(move);
		
		moveUp.setEnabled(true);
		moveUp.setSize(45, 20);
		moveUp.setLocation(70, 70);
		moveUp.addActionListener(buttonListener);
		add(moveUp);
		
		moveLeft.setEnabled(true);
		moveLeft.setSize(45, 20);
		moveLeft.setLocation(25, 100);
		moveLeft.addActionListener(buttonListener);
		add(moveLeft);
		
		moveRight.setEnabled(true);
		moveRight.setSize(45, 20);
		moveRight.setLocation(115, 100);
		moveRight.addActionListener(buttonListener);
		add(moveRight);
		
		moveDown.setEnabled(true);
		moveDown.setSize(45, 20);
		moveDown.setLocation(70, 130);
		moveDown.addActionListener(buttonListener);
		add(moveDown);
	
		shoot.setSize(50, 50);
		shoot.setLocation(75, 220);
		add(shoot);
	
		shootUp.setEnabled(true);
		shootUp.setSize(45, 20);
		shootUp.setLocation(70, 270);
		shootUp.addActionListener(buttonListener);
		add(shootUp);
		
		shootLeft.setEnabled(true);
		shootLeft.setSize(45, 20);
		shootLeft.setLocation(25, 300);
		shootLeft.addActionListener(buttonListener);
		add(shootLeft);
		
		shootRight.setEnabled(true);
		shootRight.setSize(45, 20);
		shootRight.setLocation(115, 300);
		shootRight.addActionListener(buttonListener);
		add(shootRight);
		
		shootDown.setEnabled(true);
		shootDown.setSize(45, 20);
		shootDown.setLocation(70, 330);
		shootDown.addActionListener(buttonListener);
		add(shootDown);
	}

	public void disableButtons() {
		moveUp.setEnabled(false);
		moveLeft.setEnabled(false);
		moveRight.setEnabled(false);
		moveDown.setEnabled(false);
		shootUp.setEnabled(false);
		shootLeft.setEnabled(false);
		shootRight.setEnabled(false);
		shootDown.setEnabled(false);
	}
	
	public void enableButtons() {
		moveUp.setEnabled(true);
		moveLeft.setEnabled(true);
		moveRight.setEnabled(true);
		moveDown.setEnabled(true);
		shootUp.setEnabled(true);
		shootLeft.setEnabled(true);
		shootRight.setEnabled(true);
		shootDown.setEnabled(true);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (arg.toString().equals("newGame")) {
			initializeTextPanel();
		}
		if (arg.toString().equals("updateBoard")) {
			board = theGame.toString();
			gameBoard.setText(board);
			status.setText("Make your move");
		}
		if (arg.toString().equals("steppedOnSlime")) {
			board = theGame.toString();
			gameBoard.setText(board);
			status.setText("There is a breeze nearby");
		}
		if (arg.toString().equals("steppedOnBlood")) {
			board = theGame.toString();
			gameBoard.setText(board);
			status.setText("There is a foul smell nearby");
		}
		if (arg.toString().equals("steppedOnGoop")) {
			board = theGame.toString();
			gameBoard.setText(board);
			status.setText("There seems to be great danger nearby");
		}
		if (arg.toString().equals("eatenByWumpus")) {
			status.setText("You were eaten by the Wumpus");
			disableButtons();
			board = theGame.revealBoard();
			gameBoard.setText(board);
		}
		if (arg.toString().equals("fellInPit")) {
			status.setText("You fell down a pit");
			disableButtons();
			board = theGame.revealBoard();
			gameBoard.setText(board);
		}
		if (arg.toString().equals("shotSelf")) {
			status.setText("You have shot yourself");
			disableButtons();
			board = theGame.revealBoard();
			gameBoard.setText(board);
		}
		if (arg.toString().equals("killedWumpus")) {
			status.setText("You have slain the Wumpus");
			disableButtons();
			board = theGame.revealBoard();
			gameBoard.setText(board);
		}
		
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton buttonClicked = (JButton) e.getSource();
			
			if (buttonClicked == moveUp) {
				theGame.moveTo("moveUp");
			}
			else if (buttonClicked == moveLeft) {
				theGame.moveTo("moveLeft");
			}
			else if (buttonClicked == moveRight) {
				theGame.moveTo("moveRight");
			}
			else if (buttonClicked == moveDown) {
				theGame.moveTo("moveDown");
			}
			
			else if (buttonClicked == shootUp) {
				theGame.shootAt("shootUp");
			}
			else if (buttonClicked == shootLeft) {
				theGame.shootAt("shootLeft");
			}
			else if (buttonClicked == shootRight) {
				theGame.shootAt("shootRight");
			}
			else if (buttonClicked == shootDown) {
				theGame.shootAt("shootDown");
			}
		}
	}
}
