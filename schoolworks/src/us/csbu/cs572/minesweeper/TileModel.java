package us.csbu.cs572.minesweeper;

import java.util.HashMap;

/**
 * Tile model class
 * 
 * @author JeremyLu
 */
public class TileModel {

	private static HashMap<String, TileModel> tiles;

	private static int totalMines = 0;

	private static int totalExposed = 0;

	private boolean exposed;

	private boolean isMine;

	private boolean flagged;

	private HashMap<String, Integer> coordinate;

	/**
	 * Class constructor
	 * 
	 * @param x
	 * @param y
	 * @param isMine
	 */
	public TileModel(int x, int y, boolean isMine) {
		this.coordinate = new HashMap<String, Integer>(2);
		this.coordinate.put("x", x);
		this.coordinate.put("y", y);
		this.isMine = isMine;
		if (this.isMine) {
			TileModel.totalMines++;
		}
	}

	public static void reset() {
		TileModel.totalMines = 0;
		TileModel.totalExposed = 0;
		TileModel.tiles = null;
		TileModel.tiles = new HashMap<String, TileModel>();
	}

	/**
	 * Retrieve tile coordinate(x,y)
	 * 
	 * @return
	 */
	public HashMap<String, Integer> getCoordinate() {
		return this.coordinate;
	}

	/**
	 * Is the tile mine
	 * 
	 * @return
	 */
	public boolean isMine() {
		return this.isMine;
	}

	/**
	 * Has this tile been exposed
	 * 
	 * @return
	 */
	public boolean isExplosed() {
		return this.exposed;
	}

	/**
	 * expose this tile (an action)
	 */
	public void expose() {
		this.exposed = true;
		TileModel.totalExposed++;
	}

	/**
	 * check the winning status on every move
	 * 
	 * @return {boolean}
	 */
	public boolean winCheck() {
		int totalTiles = TileModel.tiles.size();
		return totalTiles - TileModel.totalExposed == TileModel.totalMines;
	}

	/**
	 * Is flagged
	 * 
	 * @return boolean
	 */
	public boolean isFlagged() {
		return this.flagged;
	}

	/**
	 * Toggle flag status on a tile
	 */
	public void toggleFlag() {
		if (this.flagged) {
			this.flagged = false;
		} else {
			this.flagged = true;
		}
	}

	/**
	 * Get mine count from all neighbors (8 directions)
	 * 
	 * @return
	 */
	public int getNeighborMinesCount() {
		int surroundingMines = 0;
		int x = this.getCoordinate().get("x");
		int y = this.getCoordinate().get("y");
		TileModel tile;
		tile = TileModel.getTileByCoordinate(x - 1, y + 1);
		if (tile != null && tile.isMine()) {
			// north west
			surroundingMines++;
		}
		tile = TileModel.getTileByCoordinate(x, y + 1);
		if (tile != null && tile.isMine()) {
			// north
			surroundingMines++;
		}
		tile = TileModel.getTileByCoordinate(x + 1, y + 1);
		if (tile != null && tile.isMine()) {
			// north east
			surroundingMines++;
		}
		tile = TileModel.getTileByCoordinate(x + 1, y);
		if (tile != null && tile.isMine()) {
			// east
			surroundingMines++;
		}
		tile = TileModel.getTileByCoordinate(x + 1, y - 1);
		if (tile != null && tile.isMine()) {
			// south east
			surroundingMines++;
		}
		tile = TileModel.getTileByCoordinate(x, y - 1);
		if (tile != null && tile.isMine()) {
			// south
			surroundingMines++;
		}
		tile = TileModel.getTileByCoordinate(x - 1, y - 1);
		if (tile != null && tile.isMine()) {
			// south west
			surroundingMines++;
		}
		tile = TileModel.getTileByCoordinate(x - 1, y);
		if (tile != null && tile.isMine()) {
			// west
			surroundingMines++;
		}
		return surroundingMines;
	}

	/**
	 * Get the tile identifier (constructed using x and y coordinate)
	 * 
	 * @return {String} id
	 */
	public String getId() {
		return this.coordinate.get("x") + "_" + this.coordinate.get("y");
	}

	/**
	 * Get the tile by (x,y) coordinate
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static TileModel getTileByCoordinate(int x, int y) {
		// convert coordinate to ID and call get tile by id
		String id = x + "_" + y;
		return getTileById(id);
	}

	/**
	 * Get the tile model by ID
	 * 
	 * @param id
	 * @return {TileModel} tile
	 */
	public static TileModel getTileById(String id) {
		return TileModel.tiles.get(id);
	}

	/**
	 * Save a tile to HashMap in memory
	 * 
	 * @param tile
	 */
	public static void save(TileModel tile) {
		if (tiles == null) {
			tiles = new HashMap<String, TileModel>();
		}
		TileModel.tiles.put(tile.getId(), tile);
	}
}
