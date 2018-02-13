package us.csbu.cs572.minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tile Controller class
 * 
 * @author JeremyLu
 */
public class TileController implements ActionListener {

	/**
	 * board width for boundary checks
	 */
	private int width;

	/**
	 * board height for boundary checks
	 */
	private int height;

	/**
	 * class constructor
	 * 
	 * @param width
	 * @param height
	 */
	public TileController(int width, int height) {
		this.width = width;
		this.height = height;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Explore or discover a given tile Manipulating data model, call to update UI
	 * 
	 * @param tile
	 */
	private void explore(TileModel tile) {
		int x = tile.getCoordinate().get("x");
		int y = tile.getCoordinate().get("y");
		int neighborMines = tile.getNeighborMinesCount();
		// update current UI first
		MineSweeper.updateTileUi(x, y, tile.isMine(), neighborMines);
		tile.expose();
		if (neighborMines > 0 || tile.isMine()) {
			return; // we are done here
		}
		// if there is no mine in all neighbors, explore each directions until mine
		// count is non-zero
		if (x - 1 >= 0 && y + 1 < width) {
			// go north west
			TileModel nextTile = TileModel.getTileByCoordinate(x - 1, y + 1);
			if (!nextTile.isExplosed()) {
				explore(nextTile);
			}
		}
		if (y + 1 < width) {
			// go north
			TileModel nextTile = TileModel.getTileByCoordinate(x, y + 1);
			if (!nextTile.isExplosed()) {
				explore(nextTile);
			}
		}
		if (x + 1 < height && y + 1 < width) {
			// go north east
			TileModel nextTile = TileModel.getTileByCoordinate(x + 1, y + 1);
			if (!nextTile.isExplosed()) {
				explore(nextTile);
			}
		}
		if (x + 1 < height) {
			// go east
			TileModel nextTile = TileModel.getTileByCoordinate(x + 1, y);
			if (!nextTile.isExplosed()) {
				explore(nextTile);
			}
		}
		if (x + 1 < height && y - 1 >= 0) {
			// go south east
			TileModel nextTile = TileModel.getTileByCoordinate(x + 1, y - 1);
			if (!nextTile.isExplosed()) {
				explore(nextTile);
			}
		}
		if (y - 1 >= 0) {
			// go south
			TileModel nextTile = TileModel.getTileByCoordinate(x, y - 1);
			if (!nextTile.isExplosed()) {
				explore(nextTile);
			}
		}
		if (x - 1 >= 0 && y - 1 >= 0) {
			// go south west
			TileModel nextTile = TileModel.getTileByCoordinate(x - 1, y - 1);
			if (!nextTile.isExplosed()) {
				explore(nextTile);
			}
		}
		if (x - 1 >= 0) {
			// go west
			TileModel nextTile = TileModel.getTileByCoordinate(x - 1, y);
			if (!nextTile.isExplosed()) {
				explore(nextTile);
			}
		}
	}

	/**
	 * Event handler when a (UI) button is clicked
	 */
	public void actionPerformed(ActionEvent e) {
		TileModel tile = TileModel.getTileById(e.getActionCommand());
		explore(tile);
	}
}
