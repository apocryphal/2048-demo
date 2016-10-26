package com.apocryphalworks.twenty48.engine;

import com.apocryphalworks.twenty48.engine.exceptions.BlockOccupiedException;
import com.apocryphalworks.twenty48.engine.exceptions.LoseConditionException;
import com.apocryphalworks.twenty48.engine.exceptions.WinConditionException;

public class GameController {

	public enum Direction { UP, DOWN, LEFT, RIGHT, START };

	public static final Direction UP = Direction.UP;
	public static final Direction DOWN = Direction.DOWN;
	public static final Direction LEFT = Direction.LEFT;
	public static final Direction RIGHT = Direction.RIGHT;
	public static final Direction START = Direction.START;

	
	int moveNumber = 0;

	protected void collideCellsUp(final Board outputState, final int i) throws BlockOccupiedException {
		for (int j = 1; j < outputState.getYSize(); j++) {
			final Block left = outputState.blockAt(i, j - 1);
			final Block right = outputState.blockAt(i, j);
			final Block collided = left.collide(right);
			if (collided != EmptyBlock.BLOCK) {
				outputState.removeAt(i, j - 1);
				outputState.removeAt(i, j);
				outputState.insertBlock(collided, i, j-1);
			}
		}
	}

	protected void collideCellsDown(final Board outputState, final int i) throws BlockOccupiedException {
		for (int j = outputState.getYSize() - 1; j > 0 ; j--) {
			final Block left = outputState.blockAt(i, j - 1);
			final Block right = outputState.blockAt(i, j);
			final Block collided = left.collide(right);
			if (collided != EmptyBlock.BLOCK) {
				outputState.removeAt(i, j - 1);
				outputState.removeAt(i, j);
				outputState.insertBlock(collided, i, j-1);
			}
		}
	}

	protected void collideCellsLeft(final Board outputState, final int j) throws BlockOccupiedException {
		for (int i = 1; i < outputState.getXSize(); i++) {
			final Block left = outputState.blockAt(i - 1, j);
			final Block right = outputState.blockAt(i, j);
			final Block collided = left.collide(right);
			if (collided != EmptyBlock.BLOCK) {
				outputState.removeAt(i - 1, j);
				outputState.removeAt(i, j);
				outputState.insertBlock(collided, i - 1, j);
			}
		}
	}

	protected void collideCellsRight(final Board outputState, final int j) throws BlockOccupiedException {
		for (int i = outputState.getXSize() - 1; i > 0; i--) {
			final Block left = outputState.blockAt(i - 1, j);
			final Block right = outputState.blockAt(i, j);
			final Block collided = left.collide(right);
			if (collided != EmptyBlock.BLOCK) {
				outputState.removeAt(i - 1, j);
				outputState.removeAt(i, j);
				outputState.insertBlock(collided, i, j);
			}
		}
	}

	public Board makeMove(final Board inputState, final Direction direction) {
		if (direction == null) return inputState;
		switch (direction) {
		case UP:
			return moveUp(inputState);
		case DOWN:
			return moveDown(inputState);
		case LEFT:
			return moveLeft(inputState);
		case RIGHT:
		default:
			return moveRight(inputState);
		}
		//return inputState;
	}

	protected Board moveDown(final Board inputState) {
		final Board outputState = new Board(inputState);
		// each row...
		final int xSize = outputState.getXSize();
		for (int i = 0; i < xSize; i++) {
			slideRowBlocksDown(outputState, i);
			collideCellsDown(outputState, i);
			slideRowBlocksDown(outputState, i);
		}
		return outputState;	
	}

	protected Board moveLeft(final Board inputState) {
		final Board outputState = new Board(inputState);
		// each row...
		final int ySize = outputState.getYSize();
		for (int j = 0; j < ySize; j++) {
			slideRowBlocksLeft(outputState, j);
			collideCellsLeft(outputState, j);
			slideRowBlocksLeft(outputState, j);
		}
		return outputState;
	}

	protected Board moveRight(final Board inputState) {
		final Board outputState = new Board(inputState);
		// each row...
		final int ySize = outputState.getYSize();
		for (int j = 0; j < ySize; j++) {
			slideRowBlocksRight(outputState, j);
			collideCellsRight(outputState, j);
			slideRowBlocksRight(outputState, j);
		}
		return outputState;
	}

	protected Board moveUp(final Board inputState) {
		final Board outputState = new Board(inputState);
		// each row...
		final int xSize = outputState.getXSize();
		for (int i = 0; i < xSize; i++) {
			slideRowBlocksUp(outputState, i);
			collideCellsUp(outputState, i);
			slideRowBlocksUp(outputState, i);
		}
		return outputState;	
	}

/*	private void outputRow(final Block[] row) {
		for (final Block b : row) {
			System.out.print(b);
		}
		System.out.println("");
	} */

	protected void slideRowBlocksLeft(final Board outputState, final int j) throws BlockOccupiedException {
		int nextEmptyLocation = 0;
		for (int i = 0; i < outputState.getXSize(); i++) {
			final Block currentBlock = outputState.removeAt(i, j);
			if (currentBlock != EmptyBlock.BLOCK) {
				outputState.insertBlock(currentBlock, nextEmptyLocation, j);
				nextEmptyLocation++;
			}
		}
	}

	protected void slideRowBlocksRight(final Board outputState, final int j) throws BlockOccupiedException {
		final int startLocation = outputState.getXSize() - 1;
		int nextEmptyLocation = startLocation;
		for (int i = startLocation; i >= 0; i--) {
			final Block currentBlock = outputState.removeAt(i, j);
			if (currentBlock != EmptyBlock.BLOCK) {
				outputState.insertBlock(currentBlock, nextEmptyLocation, j);
				nextEmptyLocation--;
			}
		}
	}

	protected void slideRowBlocksUp(final Board outputState, final int i) throws BlockOccupiedException {
		int nextEmptyLocation = 0;
		for (int j = 0; j < outputState.getYSize(); j++) {
			final Block currentBlock = outputState.removeAt(i, j);
			if (currentBlock != EmptyBlock.BLOCK) {
				outputState.insertBlock(currentBlock, i, nextEmptyLocation);
				nextEmptyLocation++;
			}
		}
	}

	protected void slideRowBlocksDown(final Board outputState, final int i) throws BlockOccupiedException {
		final int startLocation = outputState.getYSize() - 1;
		int nextEmptyLocation = startLocation;
		for (int j = startLocation; j >= 0; j--) {
			final Block currentBlock = outputState.removeAt(i, j);
			if (currentBlock != EmptyBlock.BLOCK) {
				outputState.insertBlock(currentBlock, i, nextEmptyLocation);
				nextEmptyLocation--;
			}
		}
	}

	public Board transformState(final Board inputState, final Direction direction) throws GameOverException {
		Board newState = null;
		try {
			newState = makeMove(inputState, direction);
			if (newState.equals(inputState)) {
				return inputState;
			}
			final Location emptySpot = newState.findEmptyCoordinates();
			newState.insertBlock(BlockFactory.generateRandomBlock(), emptySpot.getX(), emptySpot.getY());
			newState.incrementMoveCount();
			testForGameOver(newState);			
		} catch (GameOverException e) {
			throw e;
		}
		return newState;
	}

	public void testForGameOver(Board inputState) throws GameOverException {
		//if (inputState.getMaxBlockScore() >= GameConstants.TARGET_SCORE) {
		//	throw new WinConditionException();
		//}
		
		Board up = moveUp(inputState);
		if (!up.equals(inputState)) return;

		Board down = moveDown(inputState);
		if (!down.equals(inputState)) return;

		Board right = moveRight(inputState);
		if (!right.equals(inputState)) return;

		Board left = moveLeft(inputState);
		if (!left.equals(inputState)) return;

		throw new LoseConditionException();
	}
}
