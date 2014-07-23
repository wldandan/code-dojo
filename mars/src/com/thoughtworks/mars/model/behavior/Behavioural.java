package com.thoughtworks.mars.model.behavior;

/**
 *  This class is used to represent the behavior of rover.   
 * @author leiw
 */
import com.thoughtworks.mars.model.Rover;

public interface Behavioural {
	
	String TURNLEFT = "L";
	String TURNRIGHT = "R";
	String MOVEFORWARD = "M";
	
    /**
     * execute the behavior of rover.
     */
	public void execute(Rover rover);
	
    /**
     * Return the name of behavior.
     */
	public String getName();
}
