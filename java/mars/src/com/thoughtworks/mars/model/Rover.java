package com.thoughtworks.mars.model;

/**
 *  This class is used to represent the robotic rover on a plateau on Mars.   
 * 
 * @author leiw
 *  
 */

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.mars.model.behavior.Behavioural;
import com.thoughtworks.mars.model.behavior.LeftTurn;
import com.thoughtworks.mars.model.behavior.MoveForward;
import com.thoughtworks.mars.model.behavior.RightTurn;
import com.thoughtworks.mars.model.orientation.Orientable;

public class Rover 
{
	private Orientable heading;
	private Point spot;
	private List<Behavioural> behaviors;

	public Rover(Point p, Orientable o)
	{
		this.spot = p;
		this.heading = o;
		initBehaviors();
	}
	
	public Rover(int x, int y, Orientable o)
	{
		this(new Point(x, y), o);
	}
	
    /**
     * Initialize the behaviors set of Rover.
     */
	private void initBehaviors() {
		behaviors = new ArrayList<Behavioural>();
		behaviors.add(new LeftTurn());
		behaviors.add(new RightTurn());
		behaviors.add(new MoveForward());
	}

    /**
     * Control the rover to do as instruction described.
     * @param instruction The instruction will control rover how to do in Mars.
     */
	public void doInstruction(char instruction)
	{
		for (Behavioural behavior : behaviors) 
		{
			if (behavior.getName().equals(String.valueOf(instruction)))
			{
				behavior.execute(this);
				break;
			}
		}
	}
	
	
	/**
     * Return the current spot of the rover.
     */
	public Point getSpot() {
		return spot;
	}

	/**
     * set the new spot
     * @param spot - the new spot. 
     */
	public void setSpot(Point spot) {
		this.spot = spot;
	}

	/**
     * Return the current heading of the rover.
     */
	public Orientable getHeading() {
		return heading;
	}

	public void setHeading(Orientable heading) {
		this.heading = heading;
	}
	
	/**
     * Return the current spot and heading of the rover.
     */
	public String getPosition() {
		return new StringBuffer().append(spot.getX()).append(" ")
								 .append(spot.getY()).append(" ")
								 .append(heading.getName()).toString();
	}	
}
