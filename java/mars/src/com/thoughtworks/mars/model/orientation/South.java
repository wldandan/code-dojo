package com.thoughtworks.mars.model.orientation;

import com.thoughtworks.mars.model.Point;

public class South implements Orientable 
{
	@Override
	public Orientable getRight() {
		return new West();
	}

	@Override
	public Orientable getLeft() {
		return new East();
	}

	@Override
	public Point getForwardPoint(Point p) {
		return new Point(p.getX(), p.getY() - Point.DISTANCE);
	}

	@Override
	public String getName() {
		return SOUTH;
	}
}
