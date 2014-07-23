package com.thoughtworks.mars.model.behavior;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.mars.model.Point;
import com.thoughtworks.mars.model.Rover;
import com.thoughtworks.mars.model.orientation.East;
import com.thoughtworks.mars.model.orientation.North;
import com.thoughtworks.mars.model.orientation.South;
import com.thoughtworks.mars.model.orientation.West;

public class MoveForwardTest {

	Behavioural moveForward;
	
	@Before
	public void setUp() throws Exception {
		moveForward = new MoveForward();
	}

	@Test
	public void should_get_north_x2y4_after_moveforward_from_north_x2y3() {
		Rover rover = new Rover(new Point(2,3), new North());
		moveForward.execute(rover);
		assertThat(rover.getSpot().getX(), is(2));
		assertThat(rover.getSpot().getY(), is(4));
		assertThat(rover.getHeading().getName(), is("N"));
	}
	
	@Test
	public void should_get_west_x1y3_after_moveforward_from_west_x2y3() {
		Rover rover = new Rover(new Point(2,3), new West());
		moveForward.execute(rover);
		assertThat(rover.getSpot().getX(), is(1));
		assertThat(rover.getSpot().getY(), is(3));
		assertThat(rover.getHeading().getName(), is("W"));
	}
	
	@Test
	public void should_get_east_x3y3_after_moveforward_from_east_x2y3() {
		Rover rover = new Rover(new Point(2,3), new East());
		moveForward.execute(rover);
		assertThat(rover.getSpot().getX(), is(3));
		assertThat(rover.getSpot().getY(), is(3));
		assertThat(rover.getHeading().getName(), is("E"));
	}
	
	@Test
	public void should_get_south_x2y2_after_moveforward_from_south_x2y3() {
		Rover rover = new Rover(new Point(2,3), new South());
		moveForward.execute(rover);
		assertThat(rover.getSpot().getX(), is(2));
		assertThat(rover.getSpot().getY(), is(2));
		assertThat(rover.getHeading().getName(), is("S"));
	}
}
