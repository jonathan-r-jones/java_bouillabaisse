package generalTests;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class ConsoleRunner
{

public static void main(String arg[])
{
	JUnitCore jUnitCore = new JUnitCore();
	jUnitCore.addListener(new TextListener(System.out));
	System.out.println("Oct-31-2016");
	jUnitCore.run(GeneralTests.class);
}
public static void main2(String arg[])
{
	JUnitCore jUnitCore = new JUnitCore();
	jUnitCore.addListener(new TextListener(System.out));
	System.out.println("Oct-28-2016");
	jUnitCore.run(TrackingServiceTests.class);
}

}
