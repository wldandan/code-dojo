package com.thoughtworks.mars.model.behavior;

import com.thoughtworks.mars.model.Rover;
import com.thoughtworks.mars.model.orientation.Orientable;

public class LeftTurn implements Behavioural
{
	@Override
	public void execute(Rover rover) {
		Orientable newHeading = rover.getHeading().getLeft();
		rover.setHeading(newHeading);
	}

	@Override
	public String getName() {
		return Behavioural.TURNLEFT;
	}
	
	
}
