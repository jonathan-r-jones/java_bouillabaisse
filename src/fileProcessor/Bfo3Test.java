package fileProcessor;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.junit.Test;
import org.xml.sax.SAXException;

public class Bfo3Test 
{
	FileProcessor fileProcessor = new FileProcessor();
	PdfWriterPss pdfWriterPss = new PdfWriterPss();
	String wp = FileProcessor.WORKSPACE_PATH;
	XmlWriter xmlWriter = new XmlWriter();
	
	@Test
	public void validateFileExists() 
	{
		assertEquals(true, fileProcessor.fileExists(wp + "a.txt"));
	}
	@Test
	public void validatePDFDoesNotExist() 
	{
		assertEquals(true, fileProcessor.fileExists(wp + "my.pdf"));
	}
	@Test
	public void validateXmlFileExists() 
	{
		assertEquals(true, fileProcessor.fileExists(wp + "HelloWorld.xml"));
	}
	@Test
	public void test10() throws SAXException, IOException 
	{
		String xmlFile = wp + "HelloWorld3.xml";
		File file = new File(wp + "my3.pdf");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		Bfo3 bfo3 = new Bfo3();
		bfo3.createPDF(xmlFile, fileOutputStream);
	}
	@Test
	public void test11() throws SAXException, IOException 
	{
		// Function Purpose: Get a "hello world" simple merge to work. 
		//
		// Creation Date: Sep-28-2016
		//
		// Outcome:
		//
		// Conclusion:
		String xmlFile = wp + "Interactive Form Version 1.xml";
		File file = new File(wp + "Interactive Form Version 1.pdf");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		Bfo3 bfo3 = new Bfo3();
		bfo3.createPDF(xmlFile, fileOutputStream);
	}
	@Test
	public void test12() throws SAXException, IOException 
	{
		// Function Purpose: Get a "hello world" simple merge to work. 
		// Creation Date: Sep-28-2016
		String xmlFile = wp + "Interactive Form Version 2.xml";
		File file = new File(wp + "Interactive Form Version 2.pdf");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		Bfo3 bfo3 = new Bfo3();
		bfo3.createPDF(xmlFile, fileOutputStream);
	}
	@Test
	public void test13() throws SAXException, IOException 
	{
		// Function Purpose: Get a "hello world" simple merge to work. 
		// Creation Date: Sep-28-2016
		String xmlFile = wp + "Interactive Form Version 3.xml";
		File file = new File(wp + "Interactive Form Version 3.pdf");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		Bfo3 bfo3 = new Bfo3();
		bfo3.createPDF(xmlFile, fileOutputStream);
	}
	@Test
	public void test14() throws SAXException, IOException 
	{
		// Function Purpose: Get a "hello world" simple merge to work. 
		// Creation Date: Sep-28-2016
		String xmlFile = wp + "Interactive Form Version 4.xml";
		File file = new File(wp + "Interactive Form Version 4.pdf");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		Bfo3 bfo3 = new Bfo3();
		bfo3.createPDF(xmlFile, fileOutputStream);
	}
}
