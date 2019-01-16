package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.HuntTheWumpusGame;
import view.GraphicView;
import view.TextFieldView;

/**
 * The GUI class that creates the GUI that the user sees and plays the game on.
 * This utilizes the Observer and Observable interface
 */

@SuppressWarnings("serial")
public class HuntTheWumpusGUI extends JFrame {

	private HuntTheWumpusGame theGame;
	private GraphicView graphicView;
	private TextFieldView textFieldView;
	private JPanel currentView;

	public static void main(String[] args) {
		HuntTheWumpusGUI g = new HuntTheWumpusGUI();
		g.setVisible(true);
	}

	public HuntTheWumpusGUI() {
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(300, 50);
		this.setSize(900, 600);
		this.setTitle("Hunt The Wumpus");

		setupMenus();
		initializeGame();

		graphicView = new GraphicView(theGame);
		textFieldView = new TextFieldView(theGame);

		addObservers();
		setViewTo(textFieldView);
	}

	private void addObservers() {
		theGame.addObserver(textFieldView);
		theGame.addObserver(graphicView);
	}

	private void initializeGame() {
		theGame = new HuntTheWumpusGame(true);
	}

	private void setupMenus() {
		JMenuItem mainMenu = new JMenu("Options");
		JMenuItem newGame = new JMenuItem("New Game");
		mainMenu.add(newGame);

		JMenuItem viewMenu = new JMenu("Views");
		JMenuItem textViewItem = new JMenuItem("Textfield View");
		viewMenu.add(textViewItem);
		JMenuItem graphicViewItem = new JMenuItem("Graphic View");
		viewMenu.add(graphicViewItem);
		mainMenu.add(viewMenu);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(mainMenu);
		
	    // Add the same listener to all menu items requiring action
	    MenuItemListener menuListener = new MenuItemListener();
	    newGame.addActionListener(menuListener);
	    textViewItem.addActionListener(menuListener);
	    graphicViewItem.addActionListener(menuListener);
	}

	private void setViewTo(JPanel newView) {
		if (currentView != null)
			remove(currentView);
		currentView = newView;
		add(currentView);
		currentView.repaint();
		validate();
	}

	private class MenuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Find out the text of the JMenuItem that was just clicked
			String text = ((JMenuItem) e.getSource()).getText();

			if (text.equals("New Game"))
				theGame.startNewGame();
			
			if (text.equals("Textfield View"))
				setViewTo(textFieldView);

			if (text.equals("Graphic View"))
				setViewTo(graphicView);
		
		}
	}
}
