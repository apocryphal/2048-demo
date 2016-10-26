package com.apocryphalworks.twenty48.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class AbstractBlockTest {

	@Test
	public void testEqualsObject() {
		assertEquals(new ValuedBlock(1), new ValuedBlock(1));
		assertNotEquals(new ValuedBlock(2), new ValuedBlock(4));
		assertNotEquals(new ValuedBlock(3), EmptyBlock.BLOCK);
		assertNotEquals(EmptyBlock.BLOCK, new ValuedBlock(4));
		assertEquals(EmptyBlock.BLOCK, EmptyBlock.BLOCK);
		assertNotEquals("String!",new ValuedBlock(5));
		assertNotEquals(new ValuedBlock(6), "String");
		assertNotEquals(new ValuedBlock(7), null);
		assertNotEquals(null, new ValuedBlock(8));
	}

	@Test
	public void testToString() {
		assertEquals(new ValuedBlock(1).toString(),"00001 ");
		assertEquals(new ValuedBlock(10).toString(),"00010 ");
	}
}
