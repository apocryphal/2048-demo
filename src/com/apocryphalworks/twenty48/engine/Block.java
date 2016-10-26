package com.apocryphalworks.twenty48.engine;

public interface Block {
	int getScore();
	Block collide(Block with);
}
