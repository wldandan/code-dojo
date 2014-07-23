
package com.thoughtworks.mars;

public final class NavigatorException extends Exception
{
	private static final long serialVersionUID = 5583888608623969881L;

	public static String ERROR_PARSE_ORIENTATION = "The system can not parse the orientation!\nPlease input like `<DomainName>,<>`"; 
	public static String ERROR_PARSE_COORDINATE = "The system can not parse the co-ordinate value!\nPlease input like [1 3] or [1 3 N]";
	public static String ERROR_ORIENTATION = "The system can not detect the right orientation, it should be one of [E S W N]";
	public static String ERROR_INPUT_WAY = "The system can not detect your input way!";
	public static String ERROR_OUTPUT_WAY = "The system can not detect your output way!";
	
	public NavigatorException(String string)
    {
        super(string);
    }
}