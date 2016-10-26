package com.apocryphalworks.twenty48.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValuedBlockTest {

	ValuedBlock one = new ValuedBlock(1);
	ValuedBlock two = new ValuedBlock(2);
	
	AbstractBlock twoA = new ValuedBlock(2);
	AbstractBlock twoB = new ValuedBlock(2);
	
	@Test
	public void testGetScore() {
		assertEquals(1,one.getScore());
		assertEquals(2,two.getScore());
	}

	@Test
	public void testCollide() {
		assertEquals(new ValuedBlock(4),twoA.collide(twoB));
		//assertEquals(new ValuedBlock(2),EmptyBlock.BLOCK.collide(twoB));
		//assertEquals(new ValuedBlock(2),twoB.collide(EmptyBlock.BLOCK));
	}
	
	@Test
	public void testCollisionFail() {
		Block block = one.collide(two);
		assertEquals(block,EmptyBlock.BLOCK);
	}
	
}
