package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.HuntTheWumpusGame;

/**
 * Author: Steven Chin
 * The graphic view representation of the Hunt the Wumpus Game which
 * utilizes the images in the images directory
 */

@SuppressWarnings("serial")
public class GraphicView extends JPanel implements Observer {
	
	
	private HuntTheWumpusGame theGame;
	private char[][] hiddenBoard;
	private char[][] shownBoard;
	private boolean shotArrow = false;
	
	private BufferedImage blood = null;
	private BufferedImage ground = null;
	private BufferedImage slime = null;
	private BufferedImage slimepit = null;
	private BufferedImage goop = null;
	private BufferedImage hunter = null;
	private BufferedImage wumpus = null;
	
	JLabel status = new JLabel("Make your move");
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
	
	public GraphicView(HuntTheWumpusGame HuntTheWumpusGame) {
		theGame = HuntTheWumpusGame;
		initializeButtons();
		initializeGamePanel();
		setImages();
	}
	
	private void initializeGamePanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		shotArrow = false;
		
		status.setText("Make your move");
		status.setSize(200, 50);
		status.setLocation(65, 400);
		add(status);
		
		enableButtons();
	}

	private void initializeButtons() {
		ButtonListener buttonListener = new ButtonListener();
		
		move.setSize(50, 50);
		move.setLocation(95, 45);
		add(move);
		
		moveUp.setEnabled(true);
		moveUp.setSize(45, 20);
		moveUp.setLocation(90, 90);
		moveUp.addActionListener(buttonListener);
		add(moveUp);
		
		moveLeft.setEnabled(true);
		moveLeft.setSize(45, 20);
		moveLeft.setLocation(45, 120);
		moveLeft.addActionListener(buttonListener);
		add(moveLeft);
		
		moveRight.setEnabled(true);
		moveRight.setSize(45, 20);
		moveRight.setLocation(135, 120);
		moveRight.addActionListener(buttonListener);
		add(moveRight);
		
		moveDown.setEnabled(true);
		moveDown.setSize(45, 20);
		moveDown.setLocation(90, 150);
		moveDown.addActionListener(buttonListener);
		add(moveDown);
	
		shoot.setSize(50, 50);
		shoot.setLocation(95, 220);
		add(shoot);
	
		shootUp.setEnabled(true);
		shootUp.setSize(45, 20);
		shootUp.setLocation(90, 270);
		shootUp.addActionListener(buttonListener);
		add(shootUp);
		
		shootLeft.setEnabled(true);
		shootLeft.setSize(45, 20);
		shootLeft.setLocation(45, 300);
		shootLeft.addActionListener(buttonListener);
		add(shootLeft);
		
		shootRight.setEnabled(true);
		shootRight.setSize(45, 20);
		shootRight.setLocation(135, 300);
		shootRight.addActionListener(buttonListener);
		add(shootRight);
		
		shootDown.setEnabled(true);
		shootDown.setSize(45, 20);
		shootDown.setLocation(90, 330);
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

	public void setImages() {
		try {
			blood = ImageIO.read(new File("images/Blood.png"));
			goop = ImageIO.read(new File("images/Goop.png"));
			ground = ImageIO.read(new File("images/Ground.png"));
			slime = ImageIO.read(new File("images/Slime.png"));
			slimepit = ImageIO.read(new File("images/SlimePit.png"));
			hunter = ImageIO.read(new File("images/TheHunter.png"));
			wumpus = ImageIO.read(new File("images/Wumpus.png"));
		} catch (IOException e) {
			System.out.println("Cannot find image");
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		hiddenBoard = theGame.getHiddenBoard();
		shownBoard = theGame.getShownBoard();

		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				g2.setColor(Color.BLACK);
				g2.fillRect(c * 50 + 250, 20 + r * 50, 50, 50);
			}
		}
		
		if (theGame.gameOver() == true || shotArrow == true) {
			for (int r = 0; r < 10; r++) {
				for (int c = 0; c < 10; c++) {
					g2.drawImage(ground, c * 50 + 250, 20 + r * 50, null);
					if (hiddenBoard[r][c] == 'W') {
						g2.drawImage(wumpus, c * 50 + 250, 20 + r * 50, null);
					}
					if (hiddenBoard[r][c] == 'S') {
						g2.drawImage(slime, c * 50 + 250, 20 + r * 50, null);
					}
					if (hiddenBoard[r][c] == 'B') {
						g2.drawImage(blood, c * 50 + 250, 20 + r * 50, null);
					}
					if (hiddenBoard[r][c] == 'G') {
						g2.drawImage(goop, c * 50 + 250, 20 + r * 50, null);
					}
					if (hiddenBoard[r][c] == 'P') {
						g2.drawImage(slimepit, c * 50 + 250, 20 + r * 50, null);
					}
					if (r == theGame.getX() && c == theGame.getY()) {
						g2.drawImage(hunter, c * 50 + 250, 20 + r * 50, null);
					}
				}
			}
		}
		else {
			for (int r = 0; r < 10; r++) {
				for (int c = 0; c < 10; c++) {
					if (shownBoard[r][c] != 'X') {
						g2.drawImage(ground, c * 50 + 250, 20 + r * 50, null);
					}
					if (shownBoard[r][c] == 'W') {
						g2.drawImage(wumpus, c * 50 + 250, 20 + r * 50, null);
					}
					if (shownBoard[r][c] == 'O' && hiddenBoard[r][c] == 'S') {
						g2.drawImage(slime, c * 50 + 250, 20 + r * 50, null);
					}
					if (shownBoard[r][c] == 'S') {
						g2.drawImage(slime, c * 50 + 250, 20 + r * 50, null);
					}
					if (shownBoard[r][c] == 'O' && hiddenBoard[r][c] == 'B') {
						g2.drawImage(blood, c * 50 + 250, 20 + r * 50, null);
					}
					if (shownBoard[r][c] == 'B') {
						g2.drawImage(blood, c * 50 + 250, 20 + r * 50, null);
					}
					if (shownBoard[r][c] == 'O' && hiddenBoard[r][c] == 'G') {
						g2.drawImage(goop, c * 50 + 250, 20 + r * 50, null);
					}
					if (shownBoard[r][c] == 'G') {
						g2.drawImage(goop, c * 50 + 250, 20 + r * 50, null);
					}
					if (shownBoard[r][c] == 'P') {
						g2.drawImage(slimepit, c * 50 + 250, 20 + r * 50, null);
					}
					if (r == theGame.getX() && c == theGame.getY()) {
						g2.drawImage(hunter, c * 50 + 250, 20 + r * 50, null);
					}
				}
			}
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (arg.toString().equals("newGame")) {
			initializeGamePanel();
			repaint();
		}
		if (arg.toString().equals("updateBoard")) {
			status.setLocation(65, 400);
			status.setText("Make your move");
			repaint();
		}
		if (arg.toString().equals("steppedOnSlime")) {
			status.setLocation(40, 400);
			status.setText("There is a breeze nearby");
			repaint();
		}
		if (arg.toString().equals("steppedOnBlood")) {
			status.setLocation(35, 400);
			status.setText("There is a foul smell nearby");
			repaint();
		}
		if (arg.toString().equals("steppedOnGoop")) {
			status.setLocation(35, 400);
			status.setText("There is great danger nearby");
			repaint();
		}
		if (arg.toString().equals("eatenByWumpus")) {
			status.setLocation(35, 400);
			status.setText("You were eaten by the Wumpus");
			disableButtons();
			repaint();
		}
		if (arg.toString().equals("fellInPit")) {
			status.setLocation(50, 400);
			status.setText("You fell down a pit");
			disableButtons();
			repaint();
		}
		if (arg.toString().equals("shotSelf")) {
			status.setLocation(50, 400);
			status.setText("You have shot yourself");
			disableButtons();
			shotArrow = true;
			repaint();
		}
		if (arg.toString().equals("killedWumpus")) {
			status.setLocation(40, 400);
			status.setText("You have slain the Wumpus");
			disableButtons();
			shotArrow = true;
			repaint();
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
