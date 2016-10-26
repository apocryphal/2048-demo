package com.apocryphalworks.twenty48;

import com.apocryphalworks.twenty48.engine.GameFactory;

public class Main {

	public static void main(String[] args) {
		if (args.length > 0) {
			//try to figure out what the arguments tell us to do
			
		}
		GameFactory factory = GameFactory.getFactory();
		Game game = factory.buildGame(GameFactory.AI_GAME);
		Game.GameResult result = game.mainLoop();
	}
}
