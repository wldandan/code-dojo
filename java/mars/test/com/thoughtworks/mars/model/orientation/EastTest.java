package com.thoughtworks.mars.model.orientation;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.mars.model.Point;
import com.thoughtworks.mars.model.orientation.East;
import com.thoughtworks.mars.model.orientation.Orientable;

public class EastTest {

	Orientable east;
	
	@Before
	public void setUp() throws Exception {
		east = new East();
	}

	@Test
	public void should_get_north_after_left() {
		Orientable left = east.getLeft();
		assertThat(left.getName(), is("N"));
	}
	
	@Test
	public void should_get_south_after_right() {
		Orientable right = east.getRight();
		assertThat(right.getName(), is("S"));
	}
	
	@Test
	public void should_get_x2y3_after_forward_from_x1y3() {
		Point p = new Point(1,3);
		assertThat(east.getForwardPoint(p).getX(),is(2));
		assertThat(east.getForwardPoint(p).getY(), is(3));
	}
}
