package generalTests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTests2
{

// private static TrackingService trackingService = new TrackingService(new
// NotifierStub());
private int _input;
private int _expectedValue;

@Parameters
public static List<Object[]> data()
{
	return Arrays.asList(new Object[][]
	{
	    { 5, 5, },
	    { 5, 5, },
	    { -12, 0 },
	    { 50, 5 },
	    { 5, 5 } 
	});
}
public ParameterizedTests2(int input, int expectedValue)
{
	_input = input;
	_expectedValue = expectedValue;
}
@Test
public void test1()
{
	// This works. Dec-1-2016
	assertEquals(_expectedValue, _input);
}
}

