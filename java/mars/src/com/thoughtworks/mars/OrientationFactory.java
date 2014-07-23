package com.thoughtworks.mars;

/**
 *  This class is used to represent the factory to create orientation.   
 * @author leiw
 */


import com.thoughtworks.mars.model.orientation.East;
import com.thoughtworks.mars.model.orientation.North;
import com.thoughtworks.mars.model.orientation.Orientable;
import com.thoughtworks.mars.model.orientation.South;
import com.thoughtworks.mars.model.orientation.West;

public class OrientationFactory {
	public static Orientable createOrientation(String s) throws NavigatorException
	{
		if (s.equalsIgnoreCase(Orientable.EAST))
		{
			return new East();
		}
		else if (s.equalsIgnoreCase(Orientable.WEST))
		{
			return new West();
		}
		else if (s.equalsIgnoreCase(Orientable.SOUTH))
		{
			return new South();
		}
		else if (s.equalsIgnoreCase(Orientable.NORTH))
		{
			return new North();
		}
		return null;
	} 
}
