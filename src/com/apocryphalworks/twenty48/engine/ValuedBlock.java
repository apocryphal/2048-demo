package com.apocryphalworks.twenty48.engine;

class ValuedBlock extends AbstractBlock implements Block {
	
	private int score;
	public ValuedBlock(int i) {
		setScore(i);
	}
	public int getScore() {
		return score;
	}
	private void setScore(int score) {
		this.score = score;
	}
	
}
