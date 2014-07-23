package com.thoughtworks.mars.model.behavior;

import com.thoughtworks.mars.model.Rover;
import com.thoughtworks.mars.model.orientation.Orientable;

public class RightTurn implements Behavioural 
{

	public void execute(Rover rover) {
		Orientable newHeading = rover.getHeading().getRight();
		rover.setHeading(newHeading);
	}

	public String getName() {
		return Behavioural.TURNRIGHT;
	}

}
