package com.apocryphalworks.twenty48.ai;

import com.apocryphalworks.twenty48.engine.Board;
import com.apocryphalworks.twenty48.engine.GameController;
import com.apocryphalworks.twenty48.engine.GameController.Direction;

public class GameState {

	private Board state;
	private int score; 
	private boolean isValid = false;
	private Direction transition;
	private int SCORE_WEIGHT;
	private int OPEN_SPACE_WEIGHT;
	private int COHESION_WEIGHT;

	public GameState(Board state, Direction transition) {
		GameController controller = new GameController();
		this.state = controller.makeMove(state, transition);
		if (!this.state.equals(state)) {
			this.transition = transition;
			this.score = determineNodeScore();
			this.isValid = true;
		}
		this.state = null;
	}
	public int getWeightedScore() {
		return this.score;
	}
	public Direction transition() {
		return transition;
	}
	public boolean isValid() {
		return this.isValid;
	}
	
	private int determineNodeScore () {
		int maxScore = state.getMaxBlockScore();
		int openSpaces = state.findAllEmptyLocations().size();
		int cohesion = state.determineCohesion();

		return maxScore * SCORE_WEIGHT 
				+ openSpaces * OPEN_SPACE_WEIGHT 
				+ cohesion * COHESION_WEIGHT;
	}

}
