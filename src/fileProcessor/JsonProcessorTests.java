package fileProcessor;

import static org.junit.Assert.*;

import org.junit.Test;

public class JsonProcessorTests
{

JsonProcessor jsonProcessor = new JsonProcessor();

@Test
public void test1()
{
	// Fp: Get JSON processing going. 
	// Date: Feb-23-2017
	assertEquals("He", jsonProcessor.first_2_characters("Hello World"));
}

}
