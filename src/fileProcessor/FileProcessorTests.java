package fileProcessor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class FileProcessorTests implements Outcome 
{
	
	FileProcessor fileProcessor = new FileProcessor();
	PdfWriterPss pdfWriterPss = new PdfWriterPss();
	String wp = FileProcessor.WORKSPACE_PATH;
	XmlWriter xmlWriter = new XmlWriter();
	
	@Test
	public void xmlFileWithDataIsWellFormedAndValid2() throws ParserConfigurationException, SAXException, IOException 
	{
		// fp: Will Alan's XML pass validation?
		String fullXmlFilename = wp + "alan1.xml"; 
		String fullXsdFilename = wp + "works with data and no data xml files.xsd";
		assertEquals(true, fileProcessor.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void xmlFileWithDataIsWellFormedAndValid3() throws ParserConfigurationException, SAXException, IOException 
	{
		// fp: Validate backbone.
		String fullXmlFilename = wp + "backbone.xml"; 
		String fullXsdFilename = wp + "works with data and no data xml files.xsd";
		assertEquals(true, fileProcessor.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test2() 
	{
		// fp: Is XFA file.
		String pdfilename = wp + "no data.pdf"; 
		assertEquals(true, fileProcessor.isXfaForm(pdfilename));
	}
	@Test
	public void test3() 
	{
		// fp: Is XFA file.
		String pdfilename = wp + "data.pdf"; 
		assertEquals(true, fileProcessor.isXfaForm(pdfilename));
	}
	@Test
	public void test5() 
	{
		// fp: Is XFA file.
		String pdfilename = wp + "backbone10.pdf"; 
		assertEquals(true, fileProcessor.isXfaForm(pdfilename));
	}
	@Test
	public void test8() 
	{
		// fp: Is XFA file.
		String pdfFilename = wp + "123data.pdf"; 
		assertEquals(true, fileProcessor.isXfaForm(pdfFilename));
	}
	// Above here are XFA. *************************
	@Test
	public void test1() 
	{
		// fp: Is XFA file.
		String pdfilename = wp + "java generated pdf file - version 5.pdf"; 
		assertEquals(false, fileProcessor.isXfaForm(pdfilename));
	}
	@Test
	public void test6() 
	{
		// fp: Is XFA file.
		String pdfilename = wp + "IDesign CSharp Coding Standard 2.32.pdf"; 
		assertEquals(false, fileProcessor.isXfaForm(pdfilename));
	}
	@Test
	public void test7() 
	{
		// fp: Is XFA file.
		String pdfFilename = wp + "Interactive Form Version 2.pdf"; 
		assertEquals(false, fileProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test9() 
	{
		// fp: Is XFA file.
		String pdfFilename = wp + "Colors.pdf"; 
		assertEquals(false, fileProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test10() 
	{
		// fp: Is XFA file.
		String pdfFilename = wp + "HelloWorld11.pdf"; 
		assertEquals(false, fileProcessor.isXfaForm(pdfFilename));
	}
}
