package us.csbu.cs572.minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {

	private MineSweeper mineSweeperUi;

	public MenuController(MineSweeper ms) {
		this.mineSweeperUi = ms;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "new-beginner":
			this.mineSweeperUi.resetBoard(5, 5, .2);
			break;
		case "new-intermediate":
			this.mineSweeperUi.resetBoard(10, 10, .3);
			break;
		case "new-advanced":
			this.mineSweeperUi.resetBoard(20, 20, .4);
			break;
		case "exit":
			System.exit(0);
			break;
		}
	}
}
