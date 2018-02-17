package us.csbu.cs572.minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tile Controller class
 * 
 * @author JeremyLu
 */
public class TileController implements ActionListener {

	MineSweeper mineSweeperUi;

	/**
	 * class constructor
	 * 
	 * @param width
	 * @param height
	 */
	public TileController(MineSweeper ms) {
		this.mineSweeperUi = ms;
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
		this.mineSweeperUi.updateTileUi(tile, neighborMines);
		tile.expose();
		if (tile.winCheck()) {
			this.mineSweeperUi.gameOver(true);
		}
		if (neighborMines > 0 || tile.isMine()) {
			return; // we are done here
		}
		// if there is no mine in all neighbors, explore each directions until mine
		// count is non-zero
		if (x - 1 >= 0 && y + 1 < this.mineSweeperUi.getBoardWidth()) {
			// go north west
			TileModel nextTile = TileModel.getTileByCoordinate(x - 1, y + 1);
			if (!nextTile.isExplosed()) {
				explore(nextTile);
			}
		}
		if (y + 1 < this.mineSweeperUi.getBoardWidth()) {
			// go north
			TileModel nextTile = TileModel.getTileByCoordinate(x, y + 1);
			if (!nextTile.isExplosed()) {
				explore(nextTile);
			}
		}
		if (x + 1 < this.mineSweeperUi.getBoardHeight() && y + 1 < this.mineSweeperUi.getBoardWidth()) {
			// go north east
			TileModel nextTile = TileModel.getTileByCoordinate(x + 1, y + 1);
			if (!nextTile.isExplosed()) {
				explore(nextTile);
			}
		}
		if (x + 1 < this.mineSweeperUi.getBoardHeight()) {
			// go east
			TileModel nextTile = TileModel.getTileByCoordinate(x + 1, y);
			if (!nextTile.isExplosed()) {
				explore(nextTile);
			}
		}
		if (x + 1 < this.mineSweeperUi.getBoardHeight() && y - 1 >= 0) {
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

	public void flagMine(String id) {
		TileModel tile = TileModel.getTileById(id);
		tile.toggleFlag();
		this.mineSweeperUi.setFlagUi(tile.isFlagged(), tile.getCoordinate().get("x"), tile.getCoordinate().get("y"));
	}

	/**
	 * Event handler when a (UI) button is clicked
	 */
	public void actionPerformed(ActionEvent e) {
		TileModel tile = TileModel.getTileById(e.getActionCommand());
		if (tile.isMine()) {
			this.mineSweeperUi.updateTileUi(tile, 0);
			this.mineSweeperUi.gameOver(false);
			return;
		}
		explore(tile);
	}
}
