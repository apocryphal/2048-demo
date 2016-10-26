package com.apocryphalworks.twenty48.engine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest extends Board {

	public BoardTest() { 
		super();
	}
	
	@Before
	public void setUp() {
		initializeFromArray(
				new int[][]{{0,1,2},
							{3,4,5},   // y
							{6,7,8}});
	}

	
	@Test
	public void testBoard() {
		Board b = new Board();
		assertEquals(getDefaultX(),b.getXSize());
		assertEquals(getDefaultY(),b.getYSize());
		assertEquals(EmptyBlock.BLOCK,b.blockAt(0,0));
	}

	@Test
	public void testBlockAt() {
		assertEquals(new ValuedBlock(4),blockAt(1,1));
		assertEquals(new ValuedBlock(1),blockAt(1,0));
		assertEquals(new ValuedBlock(3),blockAt(0,1));
		assertEquals(EmptyBlock.BLOCK, blockAt(0,0));
		
	}

	@Test
	public void testInsertBlock() throws Exception {
		insertBlock(new ValuedBlock(16),0,0);
		assertEquals(new ValuedBlock(16), blockAt(0,0));
		try {
			insertBlock(new ValuedBlock(16),2,2);
			fail("throw exception in case of collision");
		} catch (Exception e) {
			// ok.
		}
	}

	@Test
	public void testFindEmptyCoordinates() {
		//fail("Not yet implemented");
	}

	@Test
	public void testIncrementMoveCount() {
		assertEquals(0,getMoveCount());	
		incrementMoveCount();
		assertEquals(1,getMoveCount());
	}
	
	@Test
	public void testEquals() {
		Board board1 = new Board(new int[][]{{0,0},{0,0}});
		Board board2 = new Board(new int[][]{{0,0},{0,0}});
		assertEquals(board1,board2);
	}
	@Test 
	public void testNotEquals() {
		Board board1 = new Board(new int[][]{{0,0},{0,0}});
		Board board2 = new Board(new int[][]{{0,0,0},{0,0,0}});
		Board board3 = new Board(new int[][]{{0,0},{0,0},{0,0}});
		Board board4 = new Board(new int[][]{{1,0},{0,0},{0,0}});

		assertFalse(board1.equals(board2));
		assertFalse(board1.equals(board3));
		assertFalse(board3.equals(board4));
		assertFalse(board1.equals("jolly"));
		assertFalse(board1.equals(null));
	}
}
