package com.apocryphalworks.twenty48.engine;

public abstract class AbstractBlock implements Block {

	public static Block collide(Block one, Block two) {
		if (one instanceof EmptyBlock) {
			return EmptyBlock.BLOCK;
			//return two;
		}
		if (two instanceof EmptyBlock) {
			return EmptyBlock.BLOCK;
			//return one;
		}
		if (one.getScore() != two.getScore()) {
			return EmptyBlock.BLOCK;
			//throw new Exception();
		}
		return BlockFactory.giveBlock(one.getScore() + two.getScore());
	}

	public AbstractBlock() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Block) {
			return this.getScore() == ((Block) obj).getScore();
		}
		else return false;
	}
	
	@Override
	public String toString() {
		return String.format("%1$05d ", getScore());
	}
	
	@Override
	public Block collide(Block with) {
		return AbstractBlock.collide(with,this);
	}
	
}