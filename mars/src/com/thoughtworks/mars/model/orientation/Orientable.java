package com.thoughtworks.mars.model.orientation;
/**
 *  This class is used to represent the orientation which the rover can face.   
 * 
 * @author leiw
 *  
 */

import com.thoughtworks.mars.model.Point;

public interface Orientable {
	String EAST = "E";
	String WEST = "W";
	String NORTH = "N";
	String SOUTH = "S";
	
    /**
     * Return the right orientation.
     */
	Orientable getRight();
	
    /**
     * Return the left orientation.
     */
	Orientable getLeft();
	
    /**
     * Return the forward point.
     */
	Point getForwardPoint(Point p);

    /**
     * Return the name of orientation.
     */
	String getName();
}