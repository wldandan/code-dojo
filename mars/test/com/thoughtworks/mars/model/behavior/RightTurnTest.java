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

public class RightTurnTest {

	Behavioural rightTurn;
	
	@Before
	public void setUp() throws Exception {
		rightTurn = new RightTurn();
	}

	@Test
	public void should_get_east_after_turnright_from_north() {
		Rover rover = new Rover(new Point(1,2), new North());
		rightTurn.execute(rover);
		assertThat(rover.getHeading().getName(), is("E"));
		assertThat(rover.getSpot().getX(), is(1));
		assertThat(rover.getSpot().getY(), is(2));
	}
	
	@Test
	public void should_get_north_after_turnright_from_west() {
		Rover rover = new Rover(new Point(1,2), new West());
		rightTurn.execute(rover);
		assertThat(rover.getHeading().getName(), is("N"));
		assertThat(rover.getSpot().getX(), is(1));
		assertThat(rover.getSpot().getY(), is(2));
	}
	
	@Test
	public void should_get_west_after_turnright_from_south() {
		Rover rover = new Rover(new Point(1,2), new South());
		rightTurn.execute(rover);
		assertThat(rover.getHeading().getName(), is("W"));
		assertThat(rover.getSpot().getX(), is(1));
		assertThat(rover.getSpot().getY(), is(2));
	}
	
	@Test
	public void should_get_south_after_turnright_from_east() {
		Rover rover = new Rover(new Point(1,2), new East());
		rightTurn.execute(rover);
		assertThat(rover.getHeading().getName(), is("S"));
		assertThat(rover.getSpot().getX(), is(1));
		assertThat(rover.getSpot().getY(), is(2));
	}

}
