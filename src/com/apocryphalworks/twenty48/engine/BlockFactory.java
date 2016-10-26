package com.apocryphalworks.twenty48.engine;

import java.util.HashMap;
import java.util.Map;

public class BlockFactory {

	private static final boolean FLYWEIGHT = false; //does not work with true.. why?

	public static Block generateRandomBlock() {
		Block bgen = new ValuedBlock(getRandomBlockValue());
		return bgen;
	}

	private static int getRandomBlockValue() {
		return 1;
	}

	private static Map<Integer,Block> blockStock = new HashMap<Integer,Block>();

	public static Block giveBlock(int i) {
		if (i > 0) {
			if (FLYWEIGHT) {
				Block storedBlock = blockStock.get(i);
				if (storedBlock == null) {
					blockStock.put(i, new ValuedBlock(i));
				}
				return storedBlock;
			}
			else {
				return new ValuedBlock(i);
			}
		} else {
			return EmptyBlock.BLOCK;
		}
	}

}
