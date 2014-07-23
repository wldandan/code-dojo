=========================================
== mars demo ==
=========================================

@author wl
@date 2012.2.19


1. DESCRIPTION
src----java source file directory
test---java test file directory
lib----jar file directory for build/run test
dist---release jar file directory
bin----directory for compliled class files
docs---Javadoc directory	
junit-reports---Junit result directory	

run.bat----run application and output result to console
build.xml----the config file to run ant
sample.txt----sample data to run application


2. BUILD AND RUN
  1)Please change the file name "run.bat.rename" into "run.bat"
  2)To get the test result with input file "sample.txt", please run "run.bat"
  
  Optionally, you can also run the application and save result to file "result.txt" by entering the following script:
      "%JAVA_HOME%/bin/java" -cp dist/mars.jar com.thoughtworks.mars.Client sample.txt result.txt
	   
  
3.DESIGN
The orientation or rover is designed with "Orientable" interface and implementations, including East, West, South and North.
The behavior of rover is designed with "Behavioural" interface and implementations, including LeftTurn, RightTurn and MoveForward.

4. SOURCE STRUCTURE
©¸©¤com
	©¸©¤thoughtworks
		©¸©¤mars
			©¸©¤Client.java               
			©¸©¤Navigator.java            
			©¸©¤OrientationFactory.java   
			©¸©¤NavigatorException.java
			©¸©¤NavigatorHelper.java   
			©¸©¤model
				©À©¤Plateau.java			   
				©À©¤Point.java			
				©À©¤Rover.java	
                		©À©¤Behavior           
					©¸©¤LeftTurn.java
					©¸©¤RightTurn.java
					©¸©¤MoveForward.java
                		©¸©¤orientation           
					©¸©¤East.java
					©¸©¤West.java
					©¸©¤South.java
					©¸©¤North.java
        
 

5. DEVELOPING TOOLS
   Eclipse3.6
   jdk1.6.0_24
   apache.ant_1.6.5
   junit3.8.1