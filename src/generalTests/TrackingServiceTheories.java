package generalTests;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.junit.Assume;

@RunWith(Theories.class)
public class TrackingServiceTheories
{
@DataPoints
public static int[] data()
{
	return new int[]
	{ 1, 5, 10, 15, 20, 50, -4 };
}
@Theory
public void positiveValuesShouldAlwaysHavePositiveTotals(int value)
{
	TrackingService trackingService = new	TrackingService(new NotifierStub());
	trackingService.addProtein(value);
	Assume.assumeTrue(value > 0);
	assertTrue(trackingService.getTotal() > 0);
}
}
