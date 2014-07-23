package com.thoughtworks.mars.model.orientation;

import com.thoughtworks.mars.model.Point;

public class West implements Orientable {
	
	@Override
	public Orientable getRight() {
		return new North();
	}

	@Override
	public Orientable getLeft() {
		return new South();
	}

	@Override
	public Point getForwardPoint(Point p) {
		return new Point(p.getX() - Point.DISTANCE, p.getY());
	}

	@Override
	public String getName() {
		return WEST;
	}
}
