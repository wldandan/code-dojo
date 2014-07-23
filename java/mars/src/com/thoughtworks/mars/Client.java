package com.thoughtworks.mars;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Client {

	public static void main(String[] args) throws Exception 
	{
		InputStream is = null;
		OutputStream os = null;
		
		if (args.length > 0)
		{
			is = new FileInputStream(new File(args[0])); 
		}
		
		if (args.length > 1)
		{
			os = new FileOutputStream(new File(args[1])); 
		}
		
		if (null == is)
		{
			is = System.in;
		}
		
		if (null == os)
		{
			os = System.out;
		}
		
		Navigator.getInstance().run(is, os);
	}
}
