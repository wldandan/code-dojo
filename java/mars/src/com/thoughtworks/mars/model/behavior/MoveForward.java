package com.thoughtworks.mars.model.behavior;

import com.thoughtworks.mars.model.Point;
import com.thoughtworks.mars.model.Rover;

public class MoveForward implements Behavioural 
{

	public void execute(Rover rover) {
		Point newSpot = rover.getHeading().getForwardPoint(rover.getSpot());
		rover.setSpot(newSpot);
	}

	public String getName() {
		return Behavioural.MOVEFORWARD;
	}
}
