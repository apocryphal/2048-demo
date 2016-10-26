package com.apocryphalworks.twenty48.engine;

import java.util.ArrayList;
import java.util.List;

import com.apocryphalworks.twenty48.engine.exceptions.BlockOccupiedException;

public class Board {

	protected Block[][] contents;
	private int moveNumber = 0;
	protected int xSize = 0;
	protected int ySize = 0;

	public Board() {
		contents = new Block[getDefaultY()][getDefaultX()];
		xSize = getDefaultX();
		ySize = getDefaultY();
	}

	public Board(Board original) {
		xSize = original.getXSize();
		ySize = original.getYSize();
		contents = new Block[ySize][xSize];
		for (int i = 0; i < ySize; i++) {
			for (int j = 0; j < xSize; j++) {
				contents[i][j] = original.contents[i][j];
			}
		}
		moveNumber = original.moveNumber;
	}
	
	protected static int getDefaultX() {
		return 4;
	}
	protected static int getDefaultY() {
		return getDefaultX();
	}

	public Board(int[][] initialState) {
		initializeFromArray(initialState);
	}

	protected void initializeFromArray(int[][] initialState) {
		ySize = initialState.length;
		xSize = initialState[0].length;
		contents = new Block[ySize][xSize];
		for (int i = 0; i < initialState.length; i++) {
			for (int j = 0; j < initialState[i].length; j++) {
				Block b = BlockFactory.giveBlock(initialState[i][j]);
				try {
					insertBlock(b, j, i);
				} catch (Exception e) {
					//we have this here to make the compiler happy, but it will never happen
				}
			}
		}
	}

	public Block blockAt(int x, int y) {
		return (contents[y][x] == null ? EmptyBlock.BLOCK : contents[y][x]);
	}

	public void insertBlock(Block block, int atX, int atY) throws BlockOccupiedException {
		if(blockAt(atX,atY) instanceof EmptyBlock) {
			contents[atY][atX] = block;
		} else {
			throw new BlockOccupiedException();
		}
	}

	public Location findEmptyCoordinates() {
		List<Location> locations = findAllEmptyLocations();
		if (locations.isEmpty()) {
			return null;
		}
		int locationIdx = (int) (Math.random() * locations.size());
		if (locationIdx >= locations.size()) {
			locationIdx = locations.size() - 1;
		}
		if (locationIdx < 0) {
			locationIdx = 0;
		}
		return locations.get(locationIdx);
	}

	public List<Location> findAllEmptyLocations() {
		List<Location> locations = new ArrayList<Location>();
		for(int j = 0; j < getYSize(); j++) {
			for (int i = 0; i < getXSize(); i++) {
				if (blockAt(i, j).equals(EmptyBlock.BLOCK)) {
					locations.add(new Location(i,j));
				}
			}
		}
		return locations;
	}

	void incrementMoveCount() {
		moveNumber ++;
	}
	int getMoveCount() {
		return moveNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Board) {
			Board test = (Board) obj;
			int xsize = getXSize();
			int ysize = getYSize();
			if (xsize != test.getXSize()) return false;
			if (ysize != test.getYSize()) return false;
			for (int j = 0; j < ysize; j++) {
				for (int i = 0; i < xsize; i++) {
					if (!this.blockAt(i, j).equals((test).blockAt(i, j))) 
						return false;
				}
			}
		} else return false;
		return true;
	}

	protected int getYSize() {
		return ySize;
	}

	protected int getXSize() {
		return xSize;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("\n");
		for (int j = 0; j < ySize; j++) {
			for (int i = 0; i < xSize; i++) {
				sb.append(blockAt(i,j));
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public Block removeAt(int x, int y) {
		Block b = contents[y][x];
		contents[y][x] = EmptyBlock.BLOCK;
		return b;
	}

	public int getMaxBlockScore() {
		int maxScore = 0;
		for (int j = 0; j < getXSize(); j++) {
			for (int i = 0; i < getYSize(); i++) {
				int score = blockAt(i, j).getScore();
				if (score > maxScore) {
					maxScore = score;
				}
			}
		}
		return maxScore;
	}

	public int determineCohesion() {
		// TODO Auto-generated method stub
		return 0;
	}
}
