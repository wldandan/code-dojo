package com.thoughtworks.mars.model.orientation;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.mars.model.Point;
import com.thoughtworks.mars.model.orientation.Orientable;
import com.thoughtworks.mars.model.orientation.West;

public class WestTest {

	private West west;
	
	@Before
	public void setUp() throws Exception {
		west = new West();
	}

	@Test
	public void should_get_south_after_left() {
		Orientable left = west.getLeft();
		assertThat(left.getName(), is("S"));
	}
	
	@Test
	public void should_get_north_after_right() {
		Orientable right = west.getRight();
		assertThat(right.getName(), is("N"));
	}
	
	@Test
	public void should_get_x1y3_after_forward_from_x2y3() {
		Point p = new Point(2, 3);
		assertThat(west.getForwardPoint(p).getX(), is(1));
		assertThat(west.getForwardPoint(p).getY(), is(3));
	}
}
