package com.apocryphalworks.twenty48.engine;

public class Location {

	private int x,y;
	public Location(int i, int j) {
		x = i;
		y = j;
	}
	public Location() {
		x = 0;
		y = 0;
	};
	

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
}
