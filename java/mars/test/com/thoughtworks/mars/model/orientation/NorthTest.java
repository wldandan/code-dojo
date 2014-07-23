package com.thoughtworks.mars.model.orientation;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.mars.model.Point;
import com.thoughtworks.mars.model.orientation.North;
import com.thoughtworks.mars.model.orientation.Orientable;

public class NorthTest {

	Orientable north;
	
	@Before
	public void setUp() throws Exception {
		north = new North();
	}

	@Test
	public void should_get_west_after_left() {
		Orientable left = north.getLeft();
		assertThat(left.getName(), is("W"));
	}
	
	@Test
	public void should_get_east_after_right() {
		Orientable right = north.getRight();
		assertThat(right.getName(), is("E"));
	}
	
	@Test
	public void should_get_x1y4_after_forward_from_x1y3() {
		Point p = new Point(1,3);
		assertThat(north.getForwardPoint(p).getX(), is(1));
		assertThat(north.getForwardPoint(p).getY(), is(4));
	}
}
