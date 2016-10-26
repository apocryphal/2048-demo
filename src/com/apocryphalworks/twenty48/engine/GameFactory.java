package com.apocryphalworks.twenty48.engine;

import com.apocryphalworks.twenty48.Game;

public class GameFactory {

	public enum GameType {Interactive, Graphic, AI};
	public static GameType INTERACTIVE_GAME = GameType.Interactive;
	public static GameType GRAPHICAL_GAME = GameType.Graphic;
	public static GameType AI_GAME = GameType.AI;
	

	public static GameFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public Game buildGame(GameType gameType) {
		// TODO Auto-generated method stub
		return null;
	}

}
