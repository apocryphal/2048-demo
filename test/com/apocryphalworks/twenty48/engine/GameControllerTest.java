package com.apocryphalworks.twenty48.engine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameControllerTest {

	//Test
	public void testTransformState() {
		fail("Not yet implemented");
	}

	private GameController controller = new GameController();
	private Board scenario1;
	private Board scenario2;
	private Board scenario3;
	private Board scenario4;
	private Board scenario5;
	private Board scenario6;
	private Board scenario7;
	private Board scenario8;
	private Board scenario9;
	private Board scenario10;
	private Board scenario11;
	
	@Before
	public void setUp() {

		// scenario 1
		// ___ ___ ___ _2_   ___ ___ ___ ___ 
		// ___ ___ _4_ ___   ___ ___ ___ ___ 
		// ___ _4_ ___ ___   ___ ___ ___ ___ 
		// _2_ ___ ___ ___   ___ ___ ___ ___ 
		scenario1 = new Board(new int[][]{{0,0,0,2},{0,0,4,0},{0,4,0,0},{2,0,0,0}});

		// scenario 2
		// ___ ___ ___ ___   ___ ___ ___ ___  
		// ___ _2_ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		scenario2 = new Board(new int[][]{{0,0,0,0},{0,2,0,0},{0,0,0,0},{0,0,0,0}});

		// scenario 3
		// ___ ___ ___ _2_   ___ ___ ___ ___  
		// ___ ___ ___ _2_   ___ ___ ___ ___ 
		// ___ ___ ___ _2_   ___ ___ ___ ___ 
		// ___ ___ ___ _2_   ___ ___ ___ ___ 
		scenario3 = new Board(new int[][]{{0,0,0,2},{0,0,0,2},{0,0,0,2},{0,0,0,2}});

		// scenario 4
		// _2_ _2_ _2_ _2_   ___ ___ ___ ___  
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		scenario4 = new Board(new int[][]{{2,2,2,2},{0,0,0,0},{0,0,0,0},{0,0,0,0}});

		// scenario 5
		// _2_ _4_ _2_ _4_   ___ ___ ___ ___  
		// _4_ _2_ _4_ _2_   ___ ___ ___ ___  
		// _2_ _4_ _2_ _4_   ___ ___ ___ ___  
		// _4_ _2_ _4_ _2_   ___ ___ ___ ___  
		scenario5 = new Board(new int[][]{{2,4,2,4},{4,2,4,2},{2,4,2,4},{4,2,4,2}});

		// scenario 6
		// _2_ _2_ _4_ _2_   ___ ___ ___ ___  
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		scenario6 = new Board(new int[][]{{2,2,4,2},{0,0,0,0},{0,0,0,0},{0,0,0,0}});

		// scenario 7
		// ___ ___ ___ _2_   ___ ___ ___ ___  
		// ___ ___ ___ _2_   ___ ___ ___ ___ 
		// ___ ___ ___ _4_   ___ ___ ___ ___ 
		// ___ ___ ___ _2_   ___ ___ ___ ___ 
		scenario7 = new Board(new int[][]{{0,0,0,2},{0,0,0,2},{0,0,0,4},{0,0,0,2}});

		// scenario 8
		// ___ _2_ ___ _2_   ___ ___ ___ ___  
		// ___ _2_ ___ _2_   ___ ___ ___ ___ 
		// ___ _4_ ___ _4_   ___ ___ ___ ___ 
		// ___ _2_ ___ _2_   ___ ___ ___ ___ 
		scenario8 = new Board(new int[][]{{0,2,0,2},{0,2,0,2},{0,4,0,4},{0,2,0,2}});

		// scenario 9
		// _2_ ___ ___ ___   ___ ___ ___ ___ 
		// _4_ ___ ___ ___   ___ ___ ___ ___ 
		// _8_ ___ ___ ___   ___ ___ ___ ___ 
		// _16 ___ ___ ___   ___ ___ ___ ___
		scenario9 = new Board(new int[][]{{2,0,0,0},{4,0,0,0},{8,0,0,0},{16,0,0,0}});
		
		// scenario 10
		// ___ ___ ___ _2_   ___ ___ ___ ___ 
		// ___ ___ ___ _4_   ___ ___ ___ ___ 
		// ___ ___ ___ _8_   ___ ___ ___ ___ 
		// ___ ___ ___ _16   ___ ___ ___ ___ 
		scenario10 = new Board(new int[][]{{0,0,0,2},{0,0,0,4},{0,0,0,8},{0,0,0,16}});
		
		// scenario 11
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ _4_   ___ ___ ___ ___ 
		// ___ ___ ___ _8_   ___ ___ ___ ___ 
		// ___ ___ ___ _16   ___ ___ ___ ___ 
		scenario11 = new Board(new int[][]{{0,0,0,0},{0,0,0,4},{0,0,0,8},{0,0,0,16}});

	}
	
	@Test
	public void testGameOver() throws GameOverException {
		try {
			controller.testForGameOver(scenario5);
			fail("Should have reached game over.");
		} catch (Exception e) {
			// good
		}
		controller.testForGameOver(scenario1);
		controller.testForGameOver(scenario2);
		controller.testForGameOver(scenario3);
		controller.testForGameOver(scenario4);
		controller.testForGameOver(scenario6);
		controller.testForGameOver(scenario7);
		controller.testForGameOver(scenario8);
		controller.testForGameOver(scenario9);
		controller.testForGameOver(scenario10);

	}

	@Test
	public void testNullMove() {
		GameController.Direction direction = null;
		assertEquals(
				scenario1,
				controller.makeMove(scenario1, direction)
				);
	}
	@Test
	public void testMakeMoveLeft() {

		GameController.Direction direction = GameController.LEFT;

		// scenario 1
		// ___ ___ ___ _2_   _2_ ___ ___ ___ 
		// ___ ___ _4_ ___   _4_ ___ ___ ___ 
		// ___ _4_ ___ ___   _4_ ___ ___ ___ 
		// _2_ ___ ___ ___   _2_ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{2,0,0,0},{4,0,0,0},{4,0,0,0},{2,0,0,0}}),
				controller.makeMove(scenario1, direction)
				);

		// scenario 2
		// ___ ___ ___ ___   ___ ___ ___ ___  
		// ___ _2_ ___ ___   _2_ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{0,0,0,0},{2,0,0,0},{0,0,0,0},{0,0,0,0}}),
				controller.makeMove(scenario2, direction)
				);

		// scenario 3
		// ___ ___ ___ _2_   _2_ ___ ___ ___  
		// ___ ___ ___ _2_   _2_ ___ ___ ___ 
		// ___ ___ ___ _2_   _2_ ___ ___ ___ 
		// ___ ___ ___ _2_   _2_ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{2,0,0,0},{2,0,0,0},{2,0,0,0},{2,0,0,0}}),
				controller.makeMove(scenario3, direction)
				); 

		// scenario 4
		// _2_ _2_ _2_ _2_   _4_ _4_ ___ ___  
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{4,4,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}),
				controller.makeMove(scenario4, direction)
				);

		// scenario 5
		// _2_ _4_ _2_ _4_   ___ ___ ___ ___  
		// _4_ _2_ _4_ _2_   ___ ___ ___ ___  
		// _2_ _4_ _2_ _4_   ___ ___ ___ ___  
		// _4_ _2_ _4_ _2_   ___ ___ ___ ___  
		// SCENARIO 5 game over...

		// scenario 6
		// _2_ _2_ _4_ _2_   _4_ _4_ _2_ ___  
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{4,4,2,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}),
				controller.makeMove(scenario6, direction)
				);

		// scenario 7
		// ___ ___ ___ _2_   _2_ ___ ___ ___  
		// ___ ___ ___ _2_   _2_ ___ ___ ___ 
		// ___ ___ ___ _4_   _4_ ___ ___ ___ 
		// ___ ___ ___ _2_   _2_ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{2,0,0,0},{2,0,0,0},{4,0,0,0},{2,0,0,0}}),
				controller.makeMove(scenario7, direction)
				);

		// scenario 8
		// ___ _2_ ___ _2_   _4_ ___ ___ ___  
		// ___ _2_ ___ _2_   _4_ ___ ___ ___ 
		// ___ _4_ ___ _4_   _8_ ___ ___ ___ 
		// ___ _2_ ___ _2_   _4_ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{4,0,0,0},{4,0,0,0},{8,0,0,0},{4,0,0,0}}),
				controller.makeMove(scenario8, direction)
				);	
	}
	@Test
	public void testMakeMoveRight() {
		GameController.Direction direction = GameController.RIGHT;
		// scenario 1
		// ___ ___ ___ _2_   ___ ___ ___ _2_ 
		// ___ ___ _4_ ___   ___ ___ ___ _4_ 
		// ___ _4_ ___ ___   ___ ___ ___ _4_ 
		// _2_ ___ ___ ___   ___ ___ ___ _2_ 
		assertEquals(
				new Board(new int[][]{{0,0,0,2},{0,0,0,4},{0,0,0,4},{0,0,0,2}}),
				controller.makeMove(scenario1, direction)
				);

		// scenario 2
		// ___ ___ ___ ___   ___ ___ ___ ___  
		// ___ _2_ ___ ___   ___ ___ ___ _2_ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{0,0,0,0},{0,0,0,2},{0,0,0,0},{0,0,0,0}}),
				controller.makeMove(scenario2, direction)
				);

		// scenario 3
		// ___ ___ ___ _2_   ___ ___ ___ _2_  
		// ___ ___ ___ _2_   ___ ___ ___ _2_ 
		// ___ ___ ___ _2_   ___ ___ ___ _2_ 
		// ___ ___ ___ _2_   ___ ___ ___ _2_ 
		assertEquals(
				new Board(new int[][]{{0,0,0,2},{0,0,0,2},{0,0,0,2},{0,0,0,2}}),
				controller.makeMove(scenario3, direction)
				); 

		// scenario 4
		// _2_ _2_ _2_ _2_   ___ ___ _4_ _4_   
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{0,0,4,4},{0,0,0,0},{0,0,0,0},{0,0,0,0}}),
				controller.makeMove(scenario4, direction)
				);

		// scenario 5
		// _2_ _4_ _2_ _4_   ___ ___ ___ ___  
		// _4_ _2_ _4_ _2_   ___ ___ ___ ___  
		// _2_ _4_ _2_ _4_   ___ ___ ___ ___  
		// _4_ _2_ _4_ _2_   ___ ___ ___ ___  
		// SCENARIO 5 game over...

		// scenario 6
		// _2_ _2_ _4_ _2_   ___ _4_ _4_ _2_   
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{0,4,4,2},{0,0,0,0},{0,0,0,0},{0,0,0,0}}),
				controller.makeMove(scenario6, direction)
				);

		// scenario 7
		// ___ ___ ___ _2_   ___ ___ ___ _2_  
		// ___ ___ ___ _2_   ___ ___ ___ _2_ 
		// ___ ___ ___ _4_   ___ ___ ___ _4_ 
		// ___ ___ ___ _2_   ___ ___ ___ _2_ 
		assertEquals(
				new Board(new int[][]{{0,0,0,2},{0,0,0,2},{0,0,0,4},{0,0,0,2}}),
				controller.makeMove(scenario7, direction)
				);

		// scenario 8
		// ___ _2_ ___ _2_   ___ ___ ___ _4_  
		// ___ _2_ ___ _2_   ___ ___ ___ _4_ 
		// ___ _4_ ___ _4_   ___ ___ ___ _8_ 
		// ___ _2_ ___ _2_   ___ ___ ___ _4_ 
		assertEquals(
				new Board(new int[][]{{0,0,0,4},{0,0,0,4},{0,0,0,8},{0,0,0,4}}),
				controller.makeMove(scenario8, direction)
				);	
	}
	@Test
	public void testMakeMoveDown() {
		GameController.Direction direction = GameController.DOWN;

		// scenario 1
		// ___ ___ ___ _2_   ___ ___ ___ ___ 
		// ___ ___ _4_ ___   ___ ___ ___ ___ 
		// ___ _4_ ___ ___   ___ ___ ___ ___ 
		// _2_ ___ ___ ___   _2_ _4_ _4_ _2_ 
		assertEquals(
				new Board(new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{2,4,4,2}}),
				controller.makeMove(scenario1, direction)
				);

		// scenario 2
		// ___ ___ ___ ___   ___ ___ ___ ___  
		// ___ _2_ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ _2_ ___ ___ 
		assertEquals(
				new Board(new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,2,0,0}}),
				controller.makeMove(scenario2, direction)
				);

		// scenario 3
		// ___ ___ ___ _2_   ___ ___ ___ ___  
		// ___ ___ ___ _2_   ___ ___ ___ ___ 
		// ___ ___ ___ _2_   ___ ___ ___ _4_ 
		// ___ ___ ___ _2_   ___ ___ ___ _4_ 
		assertEquals(
				new Board(new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,4},{0,0,0,4}}),
				controller.makeMove(scenario3, direction)
				); 

		// scenario 4
		// _2_ _2_ _2_ _2_   ___ ___ ___ ___  
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   _2_ _2_ _2_ _2_ 
		assertEquals(
				new Board(new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{2,2,2,2}}),
				controller.makeMove(scenario4, direction)
				);

		// scenario 5
		// _2_ _4_ _2_ _4_   ___ ___ ___ ___  
		// _4_ _2_ _4_ _2_   ___ ___ ___ ___  
		// _2_ _4_ _2_ _4_   ___ ___ ___ ___  
		// _4_ _2_ _4_ _2_   ___ ___ ___ ___  
		// SCENARIO 5 game over...

		// scenario 6
		// _2_ _2_ _4_ _2_   ___ ___ ___ ___  
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   _2_ _2_ _4_ _2_ 
		assertEquals(
				new Board(new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{2,2,4,2}}),
				controller.makeMove(scenario6, direction)
				);

		// scenario 7
		// ___ ___ ___ _2_   ___ ___ ___ ___  
		// ___ ___ ___ _2_   ___ ___ ___ _4_ 
		// ___ ___ ___ _4_   ___ ___ ___ _4_ 
		// ___ ___ ___ _2_   ___ ___ ___ _2_ 
		assertEquals(
				new Board(new int[][]{{0,0,0,0},{0,0,0,4},{0,0,0,4},{0,0,0,2}}),
				controller.makeMove(scenario7, direction)
				);

		// scenario 8
		// ___ _2_ ___ _2_   ___ ___ ___ ___  
		// ___ _2_ ___ _2_   ___ _4_ ___ _4_ 
		// ___ _4_ ___ _4_   ___ _4_ ___ _4_ 
		// ___ _2_ ___ _2_   ___ _2_ ___ _2_ 
		assertEquals(
				new Board(new int[][]{{0,0,0,0},{0,4,0,4},{0,4,0,4},{0,2,0,2}}),
				controller.makeMove(scenario8, direction)
				);
	}
	@Test
	public void testMakeMoveUp() {
		GameController.Direction direction = GameController.UP;

		// scenario 1
		// ___ ___ ___ _2_   _2_ _4_ _4_ _2_ 
		// ___ ___ _4_ ___   ___ ___ ___ ___ 
		// ___ _4_ ___ ___   ___ ___ ___ ___ 
		// _2_ ___ ___ ___   ___ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{2,4,4,2},{0,0,0,0},{0,0,0,0},{0,0,0,0}}),
				controller.makeMove(scenario1, direction)
				);

		// scenario 2
		// ___ ___ ___ ___   ___ _2_ ___ ___  
		// ___ _2_ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{0,2,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}),
				controller.makeMove(scenario2, direction)
				);

		// scenario 3
		// ___ ___ ___ _2_   ___ ___ ___ _4_  
		// ___ ___ ___ _2_   ___ ___ ___ _4_ 
		// ___ ___ ___ _2_   ___ ___ ___ ___ 
		// ___ ___ ___ _2_   ___ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{0,0,0,4},{0,0,0,4},{0,0,0,0},{0,0,0,0}}),
				controller.makeMove(scenario3, direction)
				); 

		// scenario 4
		// _2_ _2_ _2_ _2_   _2_ _2_ _2_ _2_  
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{2,2,2,2},{0,0,0,0},{0,0,0,0},{0,0,0,0}}),
				controller.makeMove(scenario4, direction)
				);

		// scenario 5
		// _2_ _4_ _2_ _4_   ___ ___ ___ ___  
		// _4_ _2_ _4_ _2_   ___ ___ ___ ___  
		// _2_ _4_ _2_ _4_   ___ ___ ___ ___  
		// _4_ _2_ _4_ _2_   ___ ___ ___ ___  
		// SCENARIO 5 game over...

		// scenario 6
		// _2_ _2_ _4_ _2_   _2_ _2_ _4_ _2_  
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		// ___ ___ ___ ___   ___ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{2,2,4,2},{0,0,0,0},{0,0,0,0},{0,0,0,0}}),
				controller.makeMove(scenario6, direction)
				);

		// scenario 7
		// ___ ___ ___ _2_   ___ ___ ___ _4_  
		// ___ ___ ___ _2_   ___ ___ ___ _4_ 
		// ___ ___ ___ _4_   ___ ___ ___ _2_ 
		// ___ ___ ___ _2_   ___ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{0,0,0,4},{0,0,0,4},{0,0,0,2},{0,0,0,0}}),
				controller.makeMove(scenario7, direction)
				);

		// scenario 8
		// ___ _2_ ___ _2_   ___ _4_ ___ _4_  
		// ___ _2_ ___ _2_   ___ _4_ ___ _4_ 
		// ___ _4_ ___ _4_   ___ _2_ ___ _2_ 
		// ___ _2_ ___ _2_   ___ ___ ___ ___ 
		assertEquals(
				new Board(new int[][]{{0,4,0,4},{0,4,0,4},{0,2,0,2},{0,0,0,0}}),
				controller.makeMove(scenario8, direction)
				);
	}
}
