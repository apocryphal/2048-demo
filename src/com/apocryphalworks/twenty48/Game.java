package com.apocryphalworks.twenty48;

public abstract class Game {

	public enum GameResult {
		Win, Loss
	};

	public abstract GameResult mainLoop();

}
