package greetings;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void test() 
	{
		assertEquals(5, "Hello".length());
	}
	@Test
	public void test2() 
	{
		assertEquals(6, "Hello2".length());
	}
	@Test
	public void test3() 
	{
		assertEquals(7, "Hello22".length());
	}
}
