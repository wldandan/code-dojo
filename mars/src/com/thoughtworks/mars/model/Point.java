package com.thoughtworks.mars.model;

public class Point {
	
	public static final int DISTANCE = 1;
	private Integer x;
	private Integer y;
	
	public Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	public Integer getX() {
		return x;
	}
	public Integer getY() {
		return y;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public void setY(Integer y) {
		this.y = y;
	}
}
