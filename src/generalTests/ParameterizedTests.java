package generalTests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTests
{

private static TrackingService trackingService = new TrackingService(new NotifierStub());
private int _input;
private int _expectedValue;

@Parameters
public static List<Object[]> data()
{
	return Arrays.asList(new Object[][]
	{
	    { 5, 5 },
	    { 5, 10 },
	    { -12, 0 },
	    { 50, 50 },
	    { 1, 51 } });
}
public ParameterizedTests(int input, int expectedValue)
{
	_input = input;
	_expectedValue = expectedValue;
}
@Test
public void test1()
{
	if (_input >= 0)
		trackingService.addProtein(_input);
	else
		trackingService.removeProtein(-_input);
	assertEquals(_expectedValue, trackingService.getTotal());
}
}
