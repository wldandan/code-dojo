package com.thoughtworks.mars;

/**
 *  This class is used to represent the navigator which instruct the rover by user input.   
 * @author leiw
 */

import static com.thoughtworks.mars.NavigatorException.ERROR_INPUT_WAY;
import static com.thoughtworks.mars.NavigatorException.ERROR_OUTPUT_WAY;
import static com.thoughtworks.mars.NavigatorHelper.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thoughtworks.mars.model.Plateau;
import com.thoughtworks.mars.model.Rover;
public class Navigator 
{
	private Plateau plateau;
	private InputStream inputStream;
	private OutputStream outputStream;
	private Iterator<String> inputLines;

	private static Navigator instance = new Navigator();
	
	public static Navigator getInstance()
	{
		return instance;
	}
	
	private void parseDataFromInput() throws NavigatorException
	{
		if (null == inputStream)
		{
			throw new NavigatorException(ERROR_INPUT_WAY);
		}
		List<String> inputList = new ArrayList<String>();
		BufferedReader in = new BufferedReader( new InputStreamReader(inputStream) );

		String line = "";
		try {
			while (null != ( line = in.readLine()) && (line.trim().length() > 0 )) 
			{
				inputList.add(line.trim());	
			}
		} catch (IOException e) {
			throw new NavigatorException(e.getMessage());
		}

		inputLines = inputList.iterator();
	}
	
    /**
     * Instruct the rover by inputStream and report the rover positon to outputStream.
     */
	public void run(InputStream inputStream, OutputStream outputStream) throws NavigatorException {
		setInputStream(inputStream);
		setOutputStream(outputStream);
		parseDataFromInput();
		run();
	}
	
	private void run() throws NavigatorException{
		
		if (inputLines.hasNext())
		{
			plateau = new Plateau(parsePoint(inputLines.next()));
		}
		
		while (inputLines.hasNext())
		{
			Rover r = createRover(inputLines.next());
			if (inputLines.hasNext())
			{
				instructRover(r, inputLines.next());
				reportRoverPosition(r);
			}
		}	
	}
	
	private Rover createRover(String inputLine) throws NavigatorException {
		return new Rover(parsePoint(inputLine), 
						parseOrientation(inputLine));
	}
	
    /**
     * Report the rover position to specified output.
     */
	public void reportRoverPosition(Rover rover) throws NavigatorException 
	{
		if (null == outputStream)
		{
			throw new NavigatorException(ERROR_OUTPUT_WAY);
		}
		try {
			outputStream.write((rover.getPosition() + "\r\n").getBytes());
		} catch (IOException e) {
			throw new NavigatorException(e.getMessage());
		}
	}
	
    /**
     * Instruct the rover by a group of instructions.
     */
	public void instructRover(Rover rover, String instruction) throws NavigatorException
	{
		for (int i = 0; i < instruction.length(); i++) {
			rover.doInstruction(instruction.charAt(i));
		}
	}

	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
	
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
}
