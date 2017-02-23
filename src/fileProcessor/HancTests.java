package fileProcessor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class HancTests 
{
	
	FileProcessor fileProcessor = new FileProcessor();
	PdfWriterPss pdfWriterPss = new PdfWriterPss();
	String wp = FileProcessor.WORKSPACE_PATH_2;
	XmlWriter xmlWriter = new XmlWriter();
	
	@Test
	public void xmlFileIsWellFormedAndValid() throws ParserConfigurationException, SAXException, IOException 
	{
		String fullXmlFilename = wp + "without data.xml"; 
		String fullXsdFilename = wp + "reverse engineered.xsd";
		assertEquals(true, fileProcessor.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void xmlFileWithDataIsWellFormedAndValid() throws ParserConfigurationException, SAXException, IOException 
	{
		String fullXmlFilename = wp + "with data.xml"; 
		String fullXsdFilename = wp + "reverse engineered.xsd";
		assertEquals(true, fileProcessor.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}

}
