package com.thoughtworks.mars;

/**
 *  This class is used to parse the user input for Navigator.   
 * @author leiw
 */

import static com.thoughtworks.mars.NavigatorException.*;
import com.thoughtworks.mars.model.Point;
import com.thoughtworks.mars.model.orientation.Orientable;

public class NavigatorHelper {
	
	public static Orientable parseOrientation(String inputLine) throws NavigatorException
	{
		if (null == inputLine || 0 == inputLine.length()){
			throw new NavigatorException(ERROR_PARSE_ORIENTATION);
		}
		
		String inputData[] = inputLine.trim().split(" ");
		//the length of array must be not less than 3   
		if (inputData.length < 3)
		{
			throw new NavigatorException(ERROR_PARSE_ORIENTATION);
		}
		
		Orientable orientation = OrientationFactory.createOrientation(inputData[2]);
		if (null == orientation)
		{
			throw new NavigatorException(ERROR_ORIENTATION);
		}
		
		return orientation;
	}

	public static Point parsePoint(String inputLine) throws NavigatorException
	{
		if (null == inputLine || 0 == inputLine.length()) {
			throw new NavigatorException(ERROR_PARSE_COORDINATE);
		}
		
		String inputData[] = inputLine.trim().split(" ");
		
		//the length of array must be not less than 2 
		if (inputData.length < 2)
		{
			throw new NavigatorException(ERROR_PARSE_ORIENTATION);
		}
		  
		Point point = new Point(0, 0);
		
		try 
		{
			int x = Integer.parseInt(inputData[0]);
			int y = Integer.parseInt(inputData[1]);
			point = new Point(x, y);
		} catch (Exception e) 
		{
			throw new NavigatorException(ERROR_PARSE_COORDINATE);
		}
		return point;	
	}
}
