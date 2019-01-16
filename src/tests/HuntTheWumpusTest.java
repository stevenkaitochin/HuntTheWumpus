package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.HuntTheWumpusGame;
import view.TextFieldView;

/**
 * Test class that tests some of the different methods of the
 * HuntTheWumpusGame class
 */

public class HuntTheWumpusTest {

	@Test
	public void testHuntTheWumpusBoardSetup() {
		HuntTheWumpusGame theGame = new HuntTheWumpusGame(false);
		theGame.makeTestBoard();
		
		TextFieldView textView = new TextFieldView(theGame);
		assertTrue(textView.status.getText().equals("Make your move"));
		
		@SuppressWarnings("unused")
		char[][] shownBoard = theGame.getShownBoard();
		@SuppressWarnings("unused")
		char[][] hiddenBoard = theGame.getHiddenBoard();
		
		assertEquals("[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n", theGame.toString());
		
		theGame.set(1, 1, 'O');
		theGame.set(8, 5, 'W');
		theGame.set(2, 2, 'P');
		theGame.set(5, 5, 'P');
		theGame.set(3, 8, 'P');
		theGame.set(0, 4, 'P');
		theGame.set(7, 0, 'P');
		assertEquals("[ ] [ ] [ ] [ ] [P] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [O] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [P] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [P] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [P] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[P] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [W] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		assertEquals("[ ] [ ] [ ] [S] [P] [S] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [O] [S] [ ] [S] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [S] [P] [S] [ ] [ ] [ ] [ ] [S] [ ] \n"
				   + "[ ] [ ] [S] [ ] [ ] [ ] [ ] [S] [P] [S] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [S] [ ] [ ] [S] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [S] [P] [S] [ ] [ ] [ ] \n"
				   + "[S] [ ] [ ] [ ] [ ] [S] [ ] [ ] [ ] [ ] \n"
				   + "[P] [S] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [S] \n"
				   + "[S] [ ] [ ] [ ] [ ] [W] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [S] [ ] [ ] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.addBlood();
		assertEquals("[ ] [ ] [ ] [S] [P] [G] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [O] [S] [ ] [S] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [S] [P] [S] [ ] [ ] [ ] [ ] [S] [ ] \n"
				   + "[ ] [ ] [S] [ ] [ ] [ ] [ ] [S] [P] [S] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [S] [ ] [ ] [S] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [S] [P] [S] [ ] [ ] [ ] \n"
				   + "[S] [ ] [ ] [ ] [ ] [G] [ ] [ ] [ ] [ ] \n"
				   + "[P] [S] [ ] [ ] [B] [B] [B] [ ] [ ] [S] \n"
				   + "[S] [ ] [ ] [B] [B] [W] [B] [B] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [G] [B] [B] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		assertEquals("[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [O] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n", theGame.testCurrentBoardView());
		
		theGame.moveTo("moveUp");
		assertEquals("[X] [O] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n", theGame.testCurrentBoardView());
		
		theGame.moveTo("moveUp");
		theGame.moveTo("moveUp");
		theGame.moveTo("moveUp");
		theGame.moveTo("moveUp");
		theGame.moveTo("moveLeft");
		assertEquals("[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[O] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [S] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n", theGame.testCurrentBoardView());
		
		textView.update(theGame, "steppedOnSlime");
		assertTrue(textView.status.getText().equals("There is a breeze nearby"));
		
		theGame.moveTo("moveDown");
		assertEquals("[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[S] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[O] [S] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n", theGame.testCurrentBoardView());
		
		textView.update(theGame, "fellInPit");
		assertTrue(textView.status.getText().equals("You fell down a pit"));
		
		assertEquals("[ ] [ ] [ ] [S] [P] [G] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [S] [ ] [S] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [S] [P] [S] [ ] [ ] [ ] [ ] [S] [ ] \n"
				   + "[ ] [ ] [S] [ ] [ ] [ ] [ ] [S] [P] [S] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [S] [ ] [ ] [S] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [S] [P] [S] [ ] [ ] [ ] \n"
				   + "[S] [ ] [ ] [ ] [ ] [G] [ ] [ ] [ ] [ ] \n"
				   + "[O] [S] [ ] [ ] [B] [B] [B] [ ] [ ] [S] \n"
				   + "[S] [ ] [ ] [B] [B] [W] [B] [B] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [G] [B] [B] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());	
		assertTrue(theGame.gameOver());
		
	}
	
	
	@Test
	public void testFallingAndGettingEaten() {
		HuntTheWumpusGame theGame = new HuntTheWumpusGame(false);
		theGame.makeTestBoard();
		
		TextFieldView textView = new TextFieldView(theGame);
		
		theGame.set(1, 1, 'O');
		theGame.set(8, 5, 'W');
		theGame.set(2, 2, 'P');
		theGame.set(5, 5, 'P');
		theGame.set(3, 8, 'P');
		theGame.set(0, 4, 'P');
		theGame.set(7, 0, 'P');
		
		theGame.addSlimes();
		theGame.addBlood();
		
		textView.update(theGame, "updateBoard");
		assertTrue(textView.status.getText().equals("Make your move"));
		
		theGame.moveTo("moveUp");
		theGame.moveTo("moveUp");
		theGame.moveTo("moveUp");
		theGame.moveTo("moveUp");
		theGame.moveTo("moveUp");
		theGame.moveTo("moveLeft");
		
		assertEquals("[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[O] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [S] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n", theGame.testCurrentBoardView());
		
		theGame.moveTo("moveRight");
		theGame.moveTo("moveDown");
		theGame.moveTo("moveDown");
		theGame.moveTo("moveLeft");
		theGame.moveTo("moveRight");
		theGame.moveTo("moveRight");
		theGame.moveTo("moveRight");
		
		assertEquals("[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[S] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [S] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[S] [ ] [ ] [O] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n", theGame.testCurrentBoardView());
		
		textView.update(theGame, "steppedOnBlood");
		assertTrue(textView.status.getText().equals("There is a foul smell nearby"));
		
		theGame.moveTo("moveRight");
		theGame.moveTo("moveUp");
		theGame.moveTo("moveDown");
		theGame.moveTo("moveLeft");
		theGame.moveTo("moveDown");
		theGame.moveTo("moveRight");
		
		assertEquals("[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[S] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [S] [X] [X] [B] [X] [X] [X] [X] [X] \n"
				   + "[S] [ ] [ ] [B] [B] [X] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [ ] [O] [X] [X] [X] [X] [X] \n", theGame.testCurrentBoardView());
		
		
		assertEquals("[ ] [ ] [ ] [S] [P] [G] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [S] [ ] [S] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [S] [P] [S] [ ] [ ] [ ] [ ] [S] [ ] \n"
				   + "[ ] [ ] [S] [ ] [ ] [ ] [ ] [S] [P] [S] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [S] [ ] [ ] [S] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [S] [P] [S] [ ] [ ] [ ] \n"
				   + "[S] [ ] [ ] [ ] [ ] [G] [ ] [ ] [ ] [ ] \n"
				   + "[P] [S] [ ] [ ] [B] [B] [B] [ ] [ ] [S] \n"
				   + "[S] [ ] [ ] [B] [B] [W] [B] [B] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [O] [B] [B] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		textView.update(theGame, "steppedOnGoop");
		assertTrue(textView.status.getText().equals("There seems to be great danger nearby"));
		
		theGame.moveTo("moveRight");
		theGame.moveTo("moveLeft");
		theGame.moveTo("moveRight");
		theGame.moveTo("moveDown");
		theGame.moveTo("moveUp");
		
		assertEquals("[X] [ ] [X] [X] [X] [G] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [X] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[S] [ ] [X] [X] [X] [X] [X] [X] [X] [X] \n"
				   + "[X] [S] [X] [X] [B] [X] [X] [X] [X] [X] \n"
				   + "[S] [ ] [ ] [B] [B] [X] [X] [X] [X] [X] \n"
				   + "[X] [ ] [X] [ ] [G] [O] [X] [X] [X] [X] \n", theGame.testCurrentBoardView());
		
		
		theGame.moveTo("moveUp");
		
		textView.update(theGame, "eatenByWumpus");
		assertTrue(textView.status.getText().equals("You were eaten by the Wumpus"));
		
		theGame.moveTo("moveUp");
		theGame.moveTo("moveDown");
		theGame.moveTo("moveLeft");
		theGame.moveTo("moveRight");
		theGame.moveTo("moveRight");
		theGame.moveTo("moveLeft");
		
		theGame.moveTo("moveUp");
		theGame.moveTo("moveUp");
		theGame.moveTo("moveUp");
		theGame.moveTo("moveUp");
		theGame.moveTo("moveDown");
		theGame.moveTo("moveLeft");
		theGame.moveTo("moveRight");
		theGame.moveTo("moveRight");
		theGame.moveTo("moveLeft");
		
		assertEquals("[ ] [ ] [ ] [S] [P] [G] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [S] [ ] [S] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [S] [P] [S] [ ] [ ] [ ] [ ] [S] [ ] \n"
				   + "[ ] [ ] [S] [ ] [ ] [ ] [ ] [S] [P] [S] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [S] [ ] [ ] [S] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [S] [O] [S] [ ] [ ] [ ] \n"
				   + "[S] [ ] [ ] [ ] [ ] [G] [ ] [ ] [ ] [ ] \n"
				   + "[P] [S] [ ] [ ] [B] [B] [B] [ ] [ ] [S] \n"
				   + "[S] [ ] [ ] [B] [B] [W] [B] [B] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [G] [B] [B] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.moveTo("moveLeft");
		theGame.moveTo("moveLeft");
		theGame.moveTo("moveLeft");
		theGame.moveTo("moveLeft");
		theGame.moveTo("moveLeft");
		theGame.moveTo("moveLeft");
		theGame.moveTo("moveRight");
		
		assertFalse(theGame.gameOver());
		theGame.moveTo("moveRight");
		theGame.moveTo("moveRight");
		theGame.moveTo("moveRight");
		theGame.moveTo("moveDown");
		theGame.moveTo("moveDown");
		theGame.moveTo("moveDown");
		theGame.moveTo("moveRight");
		theGame.moveTo("moveRight");
		assertTrue(theGame.gameOver());
	}
	
	
	@Test
	public void testWumpusMethods() {
		HuntTheWumpusGame theGame = new HuntTheWumpusGame(false);
		assertTrue(theGame.numberOfPits() >= 3 && theGame.numberOfPits() <= 5);
		theGame.makeTestBoard();
		
		theGame.set(1, 0, 'P');
		theGame.set(8, 0, 'P');
		theGame.set(0, 2, 'W');
		theGame.set(0, 4, 'P');
		theGame.set(3, 9, 'P');
		theGame.set(5, 9, 'P');
		theGame.set(9, 6, 'P');
		theGame.set(4, 7, 'W');
		theGame.set(9, 6, 'P');
		theGame.set(3, 3, 'P');
		theGame.set(9, 1, 'P');
		
		
		assertEquals("[ ] [ ] [W] [ ] [P] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[P] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [P] [ ] [ ] [ ] [ ] [ ] [P] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [W] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [P] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[P] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [P] [ ] [ ] [ ] [ ] [P] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();
		
		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(4, 3, 'P');
		theGame.set(5, 3, 'P');
		theGame.set(6, 3, 'P');
		theGame.set(5, 3, 'P');
		theGame.set(3, 4, 'P');
		theGame.set(3, 5, 'P');
		theGame.set(3, 6, 'P');
		theGame.set(4, 7, 'P');
		theGame.set(5, 7, 'P');
		theGame.set(6, 7, 'P');
		theGame.set(7, 4, 'P');
		theGame.set(7, 5, 'P');
		theGame.set(7, 6, 'P');
		theGame.set(5, 5, 'W');
		
		assertEquals("[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [P] [P] [P] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [P] [ ] [ ] [ ] [P] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [P] [ ] [W] [ ] [P] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [P] [ ] [ ] [ ] [P] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [P] [P] [P] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();
		
		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(8, 4, 'P');
		theGame.set(9, 4, 'W');
		theGame.set(0, 5, 'P');
		theGame.set(0, 0, 'W');
		theGame.set(0, 9, 'W');
		
		assertEquals("[W] [ ] [ ] [ ] [ ] [P] [ ] [ ] [ ] [W] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [P] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [W] [ ] [ ] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();
		
		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(0, 0, 'P');
		theGame.set(0, 5, 'W');
		theGame.set(9, 2, 'W');
		theGame.set(4, 2, 'W');
		
		assertEquals("[P] [ ] [ ] [ ] [ ] [W] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [W] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [W] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();
		
		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(0, 5, 'W');
		theGame.set(4, 2, 'W');
		theGame.set(8, 0, 'W');
		theGame.set(8, 7, 'P');
		theGame.set(7, 9, 'P');
		theGame.set(9, 4, 'W');
		
		assertEquals("[ ] [ ] [ ] [ ] [ ] [W] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [W] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [P] \n"
				   + "[W] [ ] [ ] [ ] [ ] [ ] [ ] [P] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [W] [ ] [ ] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();

		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(0, 8, 'W');
		theGame.set(3, 9, 'W');
		theGame.set(6, 0, 'P');
		theGame.set(7, 2, 'P');
		theGame.set(7, 9, 'W');
		
		assertEquals("[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [W] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [W] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[P] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [P] [ ] [ ] [ ] [ ] [ ] [ ] [W] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();
		
		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(0, 4, 'W');
		theGame.set(0, 8, 'P');
		theGame.set(1, 8, 'P');
		theGame.set(1, 1, 'W');
		theGame.set(8, 2, 'W');
		theGame.set(8, 5, 'P');
		theGame.set(9, 5, 'P');
		theGame.set(9, 7, 'W');
		theGame.set(4, 0, 'W');
		
		assertEquals("[ ] [ ] [ ] [ ] [W] [ ] [ ] [ ] [P] [ ] \n"
				   + "[ ] [W] [ ] [ ] [ ] [ ] [ ] [ ] [P] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[W] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [W] [ ] [ ] [P] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [P] [ ] [W] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();
		
		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(0, 7, 'P');
		theGame.set(1, 4, 'W');
		theGame.set(8, 8, 'W');
		theGame.set(9, 3, 'P');
		theGame.set(3, 1, 'W');
		theGame.set(5, 2, 'P');
		
		assertEquals("[ ] [ ] [ ] [ ] [ ] [ ] [ ] [P] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [W] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [W] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [P] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [W] [ ] \n"
				   + "[ ] [ ] [ ] [P] [ ] [ ] [ ] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();
		
		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(6, 0, 'P');
		theGame.set(8, 8, 'W');
		theGame.set(1, 4, 'W');
		
		assertEquals("[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [W] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[P] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [W] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();
		
		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(0, 0, 'W');
		theGame.set(0, 9, 'W');
		theGame.set(8, 0, 'P');
		theGame.set(8, 9, 'P');
		theGame.set(0, 4, 'W');
		theGame.set(9, 2, 'P');
		theGame.set(5, 0, 'W');
		theGame.set(5, 9, 'P');
		
		assertEquals("[W] [ ] [ ] [ ] [W] [ ] [ ] [ ] [ ] [W] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[W] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [P] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[P] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [P] \n"
				   + "[ ] [ ] [P] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();
		
		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(7, 0, 'P');
		theGame.set(8, 8, 'W');
		theGame.set(0, 9, 'W');
		
		assertEquals("[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [W] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[P] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [W] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();
		
		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(8, 0, 'P');
		theGame.set(0, 9, 'W');
		theGame.set(3, 1, 'P');
		theGame.set(4, 9, 'W');
		
		
		assertEquals("[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [W] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [P] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [W] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[P] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();
		
		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(0, 1, 'P');
		theGame.set(9, 0, 'W');
		theGame.set(0, 8, 'P');
		theGame.set(9, 9, 'W');
		
		assertEquals("[ ] [P] [ ] [ ] [ ] [ ] [ ] [ ] [P] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[W] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [W] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();
		
		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(9, 0, 'W');
		theGame.set(9, 9, 'W');
		theGame.set(4, 9, 'W');
		theGame.set(4, 0, 'P');
		
		assertEquals("[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[P] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [W] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[W] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [W] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();
		
		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(9, 9, 'W');
		
		assertEquals("[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [W] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();
		
		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(9, 9, 'W');
		theGame.set(0, 1, 'P');
		theGame.set(9, 4, 'W');
		theGame.set(0, 6, 'P');
		
		assertEquals("[ ] [P] [ ] [ ] [ ] [ ] [P] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [W] [ ] [ ] [ ] [ ] [W] \n", theGame.testOverallBoardToString());
		
		theGame.addSlimes();
		theGame.addBlood();
	}
	
	@Test
	public void testWinning() {
		HuntTheWumpusGame theGame = new HuntTheWumpusGame(false);
		theGame.makeTestBoard();
		
		TextFieldView textView = new TextFieldView(theGame);
		textView.update(theGame, "killedWumpus");
		assertTrue(textView.status.getText().equals("You have slain the Wumpus"));
		textView.update(theGame, "shotSelf");
		assertTrue(textView.status.getText().equals("You have shot yourself"));
		
		theGame.set(4, 4, 'O');
		theGame.set(1, 4, 'W');
		theGame.set(4, 7, 'W');
		
		theGame.shootAt("shootUp");
		theGame.shootAt("shootDown");
		theGame.shootAt("shootLeft");
		theGame.shootAt("shootRight");
		
		assertEquals("[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [W] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [O] [ ] [ ] [W] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
		
		theGame.startNewGame();
		theGame.makeTestBoard();
		
		theGame.set(4, 4, 'O');
		theGame.shootAt("shootUp");
		theGame.shootAt("shootLeft");
		assertEquals("[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [O] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n"
				   + "[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] \n", theGame.testOverallBoardToString());
	}
	
	@Test
	public void testRandomGame() {
		@SuppressWarnings("unused")
		HuntTheWumpusGame theGame = new HuntTheWumpusGame(true);
		
	}
}
