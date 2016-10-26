package com.apocryphalworks.twenty48.engine;

class EmptyBlock extends AbstractBlock implements Block {

	public static final Block BLOCK = new EmptyBlock();
	
	private EmptyBlock() {}
	public int getScore() {
		return 0;
	}


}
