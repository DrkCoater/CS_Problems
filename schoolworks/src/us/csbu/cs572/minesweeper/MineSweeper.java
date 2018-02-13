package us.csbu.cs572.minesweeper;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Master MineSweeper, contains UI
 * 
 * @author JeremyLu
 */
public class MineSweeper extends JFrame {

	private static final long serialVersionUID = 8955518427880969237L;

	/**
	 * The game board that store a 2-d array of buttons (with states)
	 */
	private static JButton[][] board;

	/**
	 * Board size width
	 */
	private int width;

	/**
	 * Board size height
	 */
	private int height;

	/**
	 * Mine percentage on board
	 */
	private double percentOfMines;

	private TileController controller;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            JFrame name
	 */
	public MineSweeper(String name, int width, int height, double percentOfMines) {
		super(name);
		setResizable(false);
		this.width = width;
		this.height = height;
		this.percentOfMines = percentOfMines;
		this.controller = new TileController(this.width, this.height);
	}

	/**
	 * Bootstrap the game UI
	 * 
	 * @param width
	 * @param height
	 * @param percentOfMines
	 */
	public static void createMineSweeper(int width, int height, double percentOfMines) {
		MineSweeper frame = new MineSweeper("Mine Sweeper Game", width, height, percentOfMines);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.createBoard(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Update UI of a given tile
	 * 
	 * @param x
	 * @param y
	 * @param isMine
	 * @param neighborMinesCount
	 */
	public static void updateTileUi(int x, int y, boolean isMine, int neighborMinesCount) {
		URL url;
		if (isMine) {
			url = MineSweeper.class.getResource("/mine.jpg");
		} else {
			switch (neighborMinesCount) {
			case 1:
				url = MineSweeper.class.getResource("/one.jpg");
				break;
			case 2:
				url = MineSweeper.class.getResource("/two.jpg");
				break;
			case 3:
				url = MineSweeper.class.getResource("/three.jpg");
				break;
			case 4:
				url = MineSweeper.class.getResource("/four.jpg");
				break;
			case 5:
				url = MineSweeper.class.getResource("/five.jpg");
				break;
			case 6:
				url = MineSweeper.class.getResource("/six.jpg");
				break;
			case 7:
				url = MineSweeper.class.getResource("/seven.jpg");
				break;
			case 8:
				url = MineSweeper.class.getResource("/eight.jpg");
				break;
			default: // 0, there is no mine in in all 8 direction neighbors
				url = MineSweeper.class.getResource("/zero.jpg");
			}
		}
		Icon stateIcon = new ImageIcon(url);
		MineSweeper.board[x][y].setIcon(stateIcon);
	}

	/**
	 * Create board
	 * 
	 * @param pane
	 */
	private void createBoard(final Container pane) {
		MineSweeper.board = new JButton[this.width][this.height];
		Random r = new Random();
		final JPanel jPanel = new JPanel();
		GridLayout gridLayout = new GridLayout(this.width, this.height);
		jPanel.setLayout(gridLayout);
		int totalTiles = this.width * this.height;
		int totalMines = (int) Math.ceil(totalTiles * percentOfMines);
		for (int i = this.height - 1; i >= 0; i--) {
			for (int j = 0; j < this.width; j++) {
				TileModel tile = new TileModel(i, j, r.nextInt(totalTiles - 1) < totalMines);
				TileModel.save(tile);
				JButton btn = new JButton();
				btn.setActionCommand(tile.getId());
				btn.addActionListener(this.controller);
				btn.setPreferredSize(new Dimension(40, 40));
				MineSweeper.board[i][j] = btn;
				jPanel.add(MineSweeper.board[i][j], i, j);
			}
		}
		pane.add(jPanel);
	}

	/**
	 * Main method application start
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/* Use an appropriate Look and Feel */
		try {
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		/* Turn off metal's use of bold fonts */
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createMineSweeper(10, 10, 0.2);
			}
		});
	}
}
