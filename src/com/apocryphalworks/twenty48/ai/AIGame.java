package com.apocryphalworks.twenty48.ai;

import com.apocryphalworks.twenty48.Game;
import com.apocryphalworks.twenty48.engine.Board;
import com.apocryphalworks.twenty48.engine.GameConstants;
import com.apocryphalworks.twenty48.engine.GameController;
import com.apocryphalworks.twenty48.engine.GameOverException;
import com.apocryphalworks.twenty48.engine.GameController.Direction;

public class AIGame extends Game {

	@Override
	public GameResult mainLoop() {
		Board gameBoard = new Board();
		GameController controller = new GameController();
		try {
			while (true) {
				Direction direction = determineDirectionRoot(gameBoard);
				gameBoard = controller.transformState(gameBoard, direction);
			}
		} catch (GameOverException e) {

		}

		// TODO Auto-generated method stub
		return GameResult.Loss;
	}

	public Direction determineDirectionRoot(Board gameBoard) {
		GameState start = new GameState(gameBoard,Direction.START);
		GameState bestChoice = determineDirection(gameBoard, start, GameConstants.MAX_DEPTH);
		return bestChoice.transition();
	}

	public GameState determineDirection(Board gameBoard, GameState start, int depthToGo) {
		AIDecisionNode<GameState> root = expandChildStates(gameBoard, start, depthToGo - 1);
		int maxScore = 0;
		GameState bestChoice = null;
		for (AIDecisionNode<GameState> choice: root.getChildren()) {
			if (choice.getData().getWeightedScore() > maxScore) {
				bestChoice = choice.getData();
			}
		}
		return bestChoice;
	}

	public AIDecisionNode<GameState> expandChildStates(Board gameBoard, GameState start, int depthToGo) {
		if (depthToGo > 0) {
			AIDecisionNode<GameState> root = new AIDecisionNode<GameState>(start);
			AIDecisionNode<GameState> upState = testState(gameBoard,Direction.UP);
			if (upState.isValid()) root.addChild(upState);
			AIDecisionNode<GameState> downState = testState(gameBoard,Direction.DOWN);
			if (downState.isValid()) root.addChild(downState);
			AIDecisionNode<GameState> rightState = testState(gameBoard,Direction.RIGHT);
			if (rightState.isValid()) root.addChild(rightState);
			AIDecisionNode<GameState> leftState = testState(gameBoard,Direction.LEFT);
			if (leftState.isValid()) root.addChild(leftState);
			return root;
		} else 
			return null;
	}

	private AIDecisionNode<GameState> testState(Board gameBoard, Direction direction) {
		GameState currentState = new GameState(gameBoard,direction);
		AIDecisionNode<GameState> returnThis = null;
		if (currentState.isValid()) {

		}
		return null;
	}

}
