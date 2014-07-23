

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.thoughtworks.mars.model.behavior.LeftTurnTest;
import com.thoughtworks.mars.model.behavior.MoveForwardTest;
import com.thoughtworks.mars.model.behavior.RightTurnTest;
import com.thoughtworks.mars.model.orientation.EastTest;
import com.thoughtworks.mars.model.orientation.NorthTest;
import com.thoughtworks.mars.model.orientation.SouthTest;
import com.thoughtworks.mars.model.orientation.WestTest;



@RunWith(Suite.class )
@Suite.SuiteClasses({ 
					EastTest.class, 
					WestTest.class, 
					SouthTest.class, 
					NorthTest.class,
					LeftTurnTest.class,
					RightTurnTest.class,
					MoveForwardTest.class})
					
public class AllTests {

//	public static Test suite() {
//		TestSuite suite = new TestSuite(AllTests.class.getName());
//		//$JUnit-BEGIN$
//
//		//$JUnit-END$
//		return suite;
//	}
}
