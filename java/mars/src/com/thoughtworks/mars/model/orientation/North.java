package com.thoughtworks.mars.model.orientation;

import com.thoughtworks.mars.model.Point;

public class North implements Orientable {
	
	@Override
	public Orientable getRight() {
		return new East();
	}

	@Override
	public Orientable getLeft() {
		return new West();
	}
	
	@Override
	public Point getForwardPoint(Point p) {
		return new Point(p.getX(), p.getY() + Point.DISTANCE);
	}

	@Override
	public String getName() {
		return NORTH;
	}
}
