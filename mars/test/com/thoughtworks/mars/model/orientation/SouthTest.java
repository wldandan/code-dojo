package com.thoughtworks.mars.model.orientation;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.mars.model.Point;

public class SouthTest {
	Orientable south;
	
	@Before
	public void setUp() throws Exception {
		south = new South();
	}
	
	@Test
	public void should_get_east_after_left() {
		assertThat(south.getLeft().getName(), is("E"));
	}
	
	@Test
	public void should_get_west_after_right() {
		assertThat(south.getRight().getName(), is("W"));
	}
	
	@Test
	public void should_get_x2y2_after_forward_from_x2y3() {
		Point p = new Point(2, 3);
		assertThat(south.getForwardPoint(p).getY(), is(2));
		assertThat(south.getForwardPoint(p).getX(), is(2));
	}
}
