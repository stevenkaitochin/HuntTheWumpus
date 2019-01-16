package model;

import java.util.Observable;
import java.util.Random;

/**
 * Author: Steven Chin
 * Wumpus class that holds the state of the game, intializes the game board,
 * has methods that move the player around, and determine wins/losses by sending
 * to the respective view class
 */

public class HuntTheWumpusGame extends Observable {
	
	private char[][] hiddenBoard = new char[10][10];
	private char[][] shownBoard = new char[10][10];

	// If value is true, then setup board randomly, false value is for testing
	public HuntTheWumpusGame(boolean value) {
		if (value == true) {
			initializeBoard();
		}
	}

	private void initializeBoard() {
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				hiddenBoard[r][c] = ' ';
				shownBoard[r][c] = 'X';
			}
		}
		Random generator = new Random();
		
		int wumpusX = generator.nextInt(9);
		int wumpusY = generator.nextInt(9);
		hiddenBoard[wumpusX][wumpusY] = 'W';
		
		int pits = numberOfPits();
		int pitsPlaced = 0;
		while (pitsPlaced < pits) {
			int pitX = generator.nextInt(9);
			int pitY = generator.nextInt(9);
			if (hiddenBoard[pitX][pitY] == ' ') {
				hiddenBoard[pitX][pitY] = 'P';
				pitsPlaced++;
			}
		}
		addSlimes();
		addBlood();
		
		boolean hunterPlaced = false;
		while (!hunterPlaced) {
			int hunterX = generator.nextInt(9);
			int hunterY = generator.nextInt(9);
			if (hiddenBoard[hunterX][hunterY] == ' ') {
				hiddenBoard[hunterX][hunterY] = ' ';
				shownBoard[hunterX][hunterY] = 'O';
				hunterPlaced = true;
			}
		}
	}
	
	public void addSlimes() {
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (hiddenBoard[r][c] == 'P') {
					if (r == 0 && hiddenBoard[9][c] == ' ') {
						hiddenBoard[9][c] = 'S';
					}
					else if (r > 0 && hiddenBoard[r - 1][c] == ' ')
						hiddenBoard[r - 1][c] = 'S';
					if (r == 9 && hiddenBoard[0][c] == ' ') {
						hiddenBoard[0][c] = 'S';
					}
					else if (r < 9 && hiddenBoard[r + 1][c] == ' ')
						hiddenBoard[r + 1][c] = 'S';
					if (c == 0 && hiddenBoard[r][9] == ' ') {
						hiddenBoard[r][9] = 'S'; 
					}
					else if (c > 0 && hiddenBoard[r][c - 1] == ' ')
						hiddenBoard[r][c - 1] = 'S';
					if (c == 9 && hiddenBoard[r][0] == ' ') {
						hiddenBoard[r][0] = 'S';
					}
					else if (c < 9 && hiddenBoard[r][c + 1] == ' ')
						hiddenBoard[r][c + 1] = 'S';
				}
			}
		}
	}
	
	public void addBlood() {
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (hiddenBoard[r][c] == 'W') {
					
					// Add blood to 1 up
					if (r == 0 && hiddenBoard[9][c] == 'S') {
						hiddenBoard[9][c] = 'G';
					}
					else if (r == 0 && hiddenBoard[9][c] == ' ') {
						hiddenBoard[9][c] = 'B';
					}
					else if (r > 0 && hiddenBoard[r - 1][c] == 'S') {
						hiddenBoard[r - 1][c] = 'G';
					}
					else if (r > 0 && hiddenBoard[r - 1][c] == ' ') {
						hiddenBoard[r - 1][c] = 'B';
					}
					// Add blood to 1 down
					if (r == 9 && hiddenBoard[0][c] == 'S') {
						hiddenBoard[0][c] = 'G';
					}
					else if (r == 9 && hiddenBoard[0][c] == ' ') {
						hiddenBoard[0][c] = 'B';
					}
					else if (r < 9 && hiddenBoard[r + 1][c] == 'S') {
						hiddenBoard[r + 1][c] = 'G';
					}
					else if (r < 9 && hiddenBoard[r + 1][c] == ' ') {
						hiddenBoard[r + 1][c] = 'B';
					}
					// Add blood to 1 left
					if (c == 0 && hiddenBoard[r][9] == 'S') {
						hiddenBoard[r][9] = 'G';
					}
					else if (c == 0 && hiddenBoard[r][9] == ' ') {
						hiddenBoard[r][9] = 'B';
					}
					else if (c > 0 && hiddenBoard[r][c - 1] == 'S') {
						hiddenBoard[r][c - 1] = 'G';
					}
					else if (c > 0 && hiddenBoard[r][c - 1] == ' ') {
						hiddenBoard[r][c - 1] = 'B';
					}
					// Add blood to 1 right
					if (c == 9 && hiddenBoard[r][0] == 'S') {
						hiddenBoard[r][0] = 'G';
					}
					else if (c == 9 && hiddenBoard[r][0] == ' ') {
						hiddenBoard[r][0] = 'B';
					}
					else if (c < 9 && hiddenBoard[r][c + 1] == 'S') {
						hiddenBoard[r][c + 1] = 'G';
					}
					else if (c < 9 && hiddenBoard[r][c + 1] == ' ') {
						hiddenBoard[r][c + 1] = 'B';
					}
					// Add blood to 2 up
					if (r == 0 && hiddenBoard[8][c] == 'S') {
						hiddenBoard[8][c] = 'G';
					}
					else if (r == 0 && hiddenBoard[8][c] == ' ') {
						hiddenBoard[8][c] = 'B';
					}
					else if (r == 1 && hiddenBoard[9][c] == 'S') {
						hiddenBoard[9][c] = 'G';
					}
					else if (r == 1 && hiddenBoard[9][c] == ' ') {
						hiddenBoard[9][c] = 'B';
					}
					else if (r > 1 && hiddenBoard[r - 2][c] == 'S') {
						hiddenBoard[r - 2][c] = 'G';
					}
					else if (r > 1 && hiddenBoard[r - 2][c] == ' ') {
						hiddenBoard[r - 2][c] = 'B';
					}
					// Add blood to 2 down
					if (r == 9 && hiddenBoard[1][c] == 'S') {
						hiddenBoard[1][c] = 'G';
					}
					else if (r == 9 && hiddenBoard[1][c] == ' ') {
						hiddenBoard[1][c] = 'B';
					}
					else if (r == 8 && hiddenBoard[0][c] == 'S') {
						hiddenBoard[0][c] = 'G';
					}
					else if (r == 8 && hiddenBoard[0][c] == ' ') {
						hiddenBoard[0][c] = 'B';
					}
					else if (r < 8 && hiddenBoard[r + 2][c] == 'S') {
						hiddenBoard[r + 2][c] = 'G';
					}
					else if (r < 8 && hiddenBoard[r + 2][c] == ' ') {
						hiddenBoard[r + 2][c] = 'B';
					}
					// Add blood to 2 left
					if (c == 0 && hiddenBoard[r][8] == 'S') {
						hiddenBoard[r][8] = 'G';
					}
					else if (c == 0 && hiddenBoard[r][8] == ' ') {
						hiddenBoard[r][8] = 'B';
					}
					else if (c == 1 && hiddenBoard[r][9] == 'S') {
						hiddenBoard[r][9] = 'G';
					}
					else if (c == 1 && hiddenBoard[r][9] == ' ') {
						hiddenBoard[r][9] = 'B';
					}
					else if (c > 1 && hiddenBoard[r][c - 2] == 'S') {
						hiddenBoard[r][c - 2] = 'G';
					}
					else if (c > 1 && hiddenBoard[r][c - 2] == ' ') {
						hiddenBoard[r][c - 2] = 'B';
					}
					// Add blood to 2 right
					if (c == 9 && hiddenBoard[r][1] == 'S') {
						hiddenBoard[r][1] = 'G';
					}
					else if (c == 9 && hiddenBoard[r][1] == ' ') {
						hiddenBoard[r][1] = 'B';
					}
					else if (c == 8 && hiddenBoard[r][0] == 'S') {
						hiddenBoard[r][0] = 'G';
					}
					else if (c == 8 && hiddenBoard[r][0] == ' ') {
						hiddenBoard[r][0] = 'B';
					}
					else if (c < 8 && hiddenBoard[r][c + 2] == 'S') {
						hiddenBoard[r][c + 2] = 'G';
					}
					else if (c < 8 && hiddenBoard[r][c + 2] == ' ') {
						hiddenBoard[r][c + 2] = 'B';
					}
					// Add blood to 1 up 1 left
					if (r == 0 && c == 0 && hiddenBoard[9][9] == 'S') {
						hiddenBoard[9][9] = 'G';
					}
					else if (r == 0 && c == 0 && hiddenBoard[9][9] == ' ') {
						hiddenBoard[9][9] = 'B';
					}
					else if (r == 0 && c > 0 && hiddenBoard[9][c - 1] == 'S') {
						hiddenBoard[9][c - 1] = 'G';
					}
					else if (r == 0 && c > 0 && hiddenBoard[9][c - 1] == ' ') {
						hiddenBoard[9][c - 1] = 'B';
					}
					else if (c == 0 && r > 0 && hiddenBoard[r - 1][9] == 'S') {
						hiddenBoard[r - 1][9] = 'G';
					}
					else if (c == 0 && r > 0 && hiddenBoard[r - 1][9] == ' ') {
						hiddenBoard[r - 1][9] = 'B';
					}
					else if (c > 0 && r > 0 && hiddenBoard[r - 1][c - 1] == 'S') {
						hiddenBoard[r - 1][c - 1] = 'G';
					}
					else if (c > 0 && r > 0 && hiddenBoard[r - 1][c - 1] == ' ') {
						hiddenBoard[r - 1][c - 1] = 'B';
					}
					// Add blood to 1 up 1 right
					if (r == 0 && c == 9 && hiddenBoard[9][0] == 'S') {
						hiddenBoard[9][0] = 'G';
					}
					else if (r == 0 && c == 9 && hiddenBoard[9][0] == ' ') {
						hiddenBoard[9][0] = 'B';
					}
					else if (r == 0 && c < 9 && hiddenBoard[9][c + 1] == 'S') {
						hiddenBoard[9][c + 1] = 'G';
					}
					else if (r == 0 && c < 9 && hiddenBoard[9][c + 1] == ' ') {
						hiddenBoard[9][c + 1] = 'B';
					}
					else if (c == 9 && r > 0 && hiddenBoard[r - 1][0] == 'S') {
						hiddenBoard[r - 1][0] = 'G';
					}
					else if (c == 9 && r > 0 && hiddenBoard[r - 1][0] == ' ') {
						hiddenBoard[r - 1][0] = 'B';
					}
					else if (c < 9 && r > 0 && hiddenBoard[r - 1][c + 1] == 'S') {
						hiddenBoard[r - 1][c + 1] = 'G';
					}
					else if (c < 9 && r > 0 && hiddenBoard[r - 1][c + 1] == ' ') {
						hiddenBoard[r - 1][c + 1] = 'B';
					}
					// Add blood to 1 down 1 left
					if (r == 9 && c == 0 && hiddenBoard[0][9] == 'S') {
						hiddenBoard[0][9] = 'G';
					}
					else if (r == 9 && c == 0 && hiddenBoard[0][9] == ' ') {
						hiddenBoard[0][9] = 'B';
					}
					else if (r == 9 && c > 0 && hiddenBoard[0][c - 1] == 'S') {
						hiddenBoard[0][c - 1] = 'G';
					}
					else if (r == 9 && c > 0 && hiddenBoard[0][c - 1] == ' ') {
						hiddenBoard[0][c - 1] = 'B';
					}
					else if (c == 0 && r < 9 && hiddenBoard[r + 1][9] == 'S') {
						hiddenBoard[r + 1][9] = 'G';
					}
					else if (c == 0 && r < 9 && hiddenBoard[r + 1][9] == ' ') {
						hiddenBoard[r + 1][9] = 'B';
					}
					else if (c > 0 && r < 9 && hiddenBoard[r + 1][c - 1] == 'S') {
						hiddenBoard[r + 1][c - 1] = 'G';
					}
					else if (c > 0 && r < 9 && hiddenBoard[r + 1][c - 1] == ' ') {
						hiddenBoard[r + 1][c - 1] = 'B';
					}
					// Add blood to 1 down 1 right
					if (r == 9 && c == 9 && hiddenBoard[0][0] == 'S') {
						hiddenBoard[0][0] = 'G';
					}
					else if (r == 9 && c == 9 && hiddenBoard[0][0] == ' ') {
						hiddenBoard[0][0] = 'B';
					}
					else if (r == 9 && c < 9 && hiddenBoard[0][c + 1] == 'S') {
						hiddenBoard[0][c + 1] = 'G';
					}
					else if (r == 9 && c < 9 && hiddenBoard[0][c + 1] == ' ') {
						hiddenBoard[0][c + 1] = 'B';
					}
					else if (c == 9 && r < 9 && hiddenBoard[r + 1][0] == 'S') {
						hiddenBoard[r + 1][0] = 'G';
					}
					else if (c == 9 && r < 9 && hiddenBoard[r + 1][0] == ' ') {
						hiddenBoard[r + 1][0] = 'B';
					}
					else if (c < 9 && r < 9 && hiddenBoard[r + 1][c + 1] == 'S') {
						hiddenBoard[r + 1][c + 1] = 'G';
					}
					else if (c < 9 && r < 9 && hiddenBoard[r + 1][c + 1] == ' ') {
						hiddenBoard[r + 1][c + 1] = 'B';
					}
				}
			}
		}
	}

	public void startNewGame() {
		initializeBoard();
		// The state of this model just changed so tell any observer to update
		// themselves
		setChanged();
		notifyObservers("newGame");
	}
	
	public void moveTo(String command) {
		if (command.equals("moveUp")) {
			int x = getX();
			int y = getY();
			int oldX = x;
			int oldY = y;
			if (x == 0) {
				x = 10;
			}
			x = x - 1;
			if (hiddenBoard[x][y] == 'W') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("eatenByWumpus");
			}
			else if (hiddenBoard[x][y] == 'P') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("fellInPit");
			}
			else if (hiddenBoard[x][y] == 'S') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("steppedOnSlime");
			}
			else if (hiddenBoard[x][y] == 'B') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("steppedOnBlood");
			}
			else if (hiddenBoard[x][y] == 'G') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("steppedOnGoop");
			}
			else {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("updateBoard");
			}
		}
		if (command.equals("moveLeft")) {
			int x = getX();
			int y = getY();
			int oldX = x;
			int oldY = y;
			if (y == 0) {
				y = 10;
			}
			y = y - 1;
			if (hiddenBoard[x][y] == 'W') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("eatenByWumpus");
			}
			else if (hiddenBoard[x][y] == 'P') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("fellInPit");
			}
			else if (hiddenBoard[x][y] == 'S') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("steppedOnSlime");
			}
			else if (hiddenBoard[x][y] == 'B') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("steppedOnBlood");
			}
			else if (hiddenBoard[x][y] == 'G') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("steppedOnGoop");
			}
			else {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("updateBoard");
			}
		}
		if (command.equals("moveRight")) {
			int x = getX();
			int y = getY();
			int oldX = x;
			int oldY = y;
			if (y == 9) {
				y = -1;
			}
			y = y + 1;
			if (hiddenBoard[x][y] == 'W') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("eatenByWumpus");
			}
			else if (hiddenBoard[x][y] == 'P') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("fellInPit");
			}
			else if (hiddenBoard[x][y] == 'S') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("steppedOnSlime");
			}
			else if (hiddenBoard[x][y] == 'B') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("steppedOnBlood");
			}
			else if (hiddenBoard[x][y] == 'G') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("steppedOnGoop");
			}
			else {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("updateBoard");
			}
		}
		if (command.equals("moveDown")) {
			int x = getX();
			int y = getY();
			int oldX = x;
			int oldY = y;
			if (x == 9) {
				x = -1;
			}
			x = x + 1;
			if (hiddenBoard[x][y] == 'W') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("eatenByWumpus");
			}
			else if (hiddenBoard[x][y] == 'P') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("fellInPit");
			}
			else if (hiddenBoard[x][y] == 'S') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("steppedOnSlime");
			}
			else if (hiddenBoard[x][y] == 'B') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("steppedOnBlood");
			}
			else if (hiddenBoard[x][y] == 'G') {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("steppedOnGoop");
			}
			else {
				shownBoard[x][y] = 'O';
				shownBoard[oldX][oldY] = hiddenBoard[oldX][oldY];
				setChanged();
				notifyObservers("updateBoard");
			}
		}
	}
	
	public void shootAt(String command) {
		if (command.equals("shootUp") || command.equals("shootDown")) {
			int y = getY();
			for (int r = 0; r < 10; r++) {
				if (hiddenBoard[r][y] == 'W') {
					setChanged();
					notifyObservers("killedWumpus");
					return;
				}
			}
			setChanged();
			notifyObservers("shotSelf");
		}
		
		if (command.equals("shootLeft") || command.equals("shootRight")) {
			int x = getX();
			for (int c = 0; c < 10; c++) {
				if (hiddenBoard[x][c] == 'W') {
					setChanged();
					notifyObservers("killedWumpus");
					return;
				}
			}
			setChanged();
			notifyObservers("shotSelf");
		}
	}
	
	public int getX() {
		int x = 0;
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (shownBoard[c][r] == 'O') {
					x = c;
				}
			}
		}
		return x;
	}
	
	public int getY() {
		int y = 0;
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (shownBoard[c][r] == 'O') {
					y = r;
				}
			}
		}
		return y;
	}
	
	public char[][] getHiddenBoard() {
		
		return hiddenBoard;
	}
	
	public char[][] getShownBoard() {
		
		return shownBoard;
	}
	
	public boolean gameOver() {
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (shownBoard[r][c] == 'O' && hiddenBoard[r][c] == 'W') {
					return true;
				}
				if (shownBoard[r][c] == 'O' && hiddenBoard[r][c] == 'P') {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String result = "";
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++)
				if (shownBoard[r][c] == ' ') {
					result += "[ ] ";
				}
				else
					result += "[" + shownBoard[r][c] + "] ";
			result += "\n";
		}
		return result;
	}

	public int numberOfPits() {
		Random generator = new Random();
		int pits = generator.nextInt(3) + 3;
		
		return pits;
	}
	
	public String revealBoard() {
		String result = "";
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (shownBoard[r][c] == 'O') {
					result += "[O] ";
				}
				else if (hiddenBoard[r][c] == ' ') {
					result += "[ ] ";
				}
				else
					result += "[" + hiddenBoard[r][c] + "] ";
			}
			result += "\n";
		}
		return result;
	}
	
	// The following code is for testing purposes only by manually creating a 
	// static gameboard, so that random values are not accounted for
	
	public void makeTestBoard() {
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				shownBoard[r][c] = 'X';
				hiddenBoard[r][c] = ' ';
			}
		}
	}
	
	public void set(int r, int c, char ch) {
		if (ch == 'O') {
			shownBoard[r][c] = 'O';
			hiddenBoard[r][c] = ' ';
		}
		else
			hiddenBoard[r][c] = ch;
	}
	
	public String testOverallBoardToString() {
		String result = "";
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (shownBoard[r][c] == 'O') {
					result += "[O] ";
				}
				else
					result += "[" + hiddenBoard[r][c] + "] ";
			}
			result += "\n";
		}
		return result;
	}
	
	public String testCurrentBoardView() {
		String result = "";
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				result += "[" + shownBoard[r][c] + "] ";
			}
			result += "\n";
		}
		return result;
	}
	
	

}
