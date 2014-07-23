package com.thoughtworks.mars.model;

public class Plateau 
{	
	private Point lowerLeft;
	private Point upperRight;
	
	private Plateau(Point lowerLeft, Point upperRight)
	{
		this.lowerLeft = lowerLeft;
		this.upperRight = upperRight;
	}
	
	public Plateau(Point upperRight)
	{
		this(new Point(0, 0), upperRight);
	}
	
	public Plateau(int x, int y)
	{
		this(new Point(0, 0), new Point(x, y));
	}
	
	public Point getLowerLeft() {
		return lowerLeft;
	}
	
	public Point getUpperRight() {
		return upperRight;
	}
	
	public void setLowerLeft(Point lowerLeft) {
		this.lowerLeft = lowerLeft;
	}
	
	public void setUpperRight(Point upperRight) {
		this.upperRight = upperRight;
	}

}
