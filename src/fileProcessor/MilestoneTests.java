package fileProcessor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class MilestoneTests implements Outcome 
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
	public void readFirstCharacterInFile() 
	{
		assertEquals("H", fileProcessor.getFirstCharatcerInFile(wp + "Hello World.txt"));
	}
	@Test
	public void xmlFileIsWellFormedAndValid() throws ParserConfigurationException, SAXException, IOException 
	{
		String fullXmlFilename = wp + "note.xml"; 
		String fullXsdFilename = wp + "note.xsd";
		assertEquals(true, fileProcessor.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void validateDataXmlFile()
	{
		String fp = "36. Works with data.";
		String fullXmlFilename = wp + "data.xml"; 
		String fullXsdFilename = wp + "works with data and no data xml files.xsd";
		assertEquals(true, fileProcessor.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void generateXMLFile() 
	{
		String xmlDataFilename = wp + "java generated xml file - version 3.xml"; 
		XmlWriter.writeXMLFile(xmlDataFilename);
		assertEquals(true, fileProcessor.fileExists(xmlDataFilename));
	}
	@Test
	public void validateSimpleXmlFile()
	{
		String xmlFilename = wp + "java generated xml file - version 3.xml"; 
		String xsdFilename = wp + "milestone1.xsd";
		assertEquals(true, fileProcessor.xmlFileIsWellFormedAndValid(xmlFilename, xsdFilename));
	}
	@Test
	public void validateDataTweaked()
	{
		// fp = Validate for confidence.
		String xmlFilename = wp + "data tweaked.xml"; 
		String xsdFilename = wp + "milestone1.xsd";
		assertEquals(true, fileProcessor.xmlFileIsWellFormedAndValid(xmlFilename, xsdFilename));
	}
	@Test
	public void generateXML() 
	{
		String xmlDataFilename = wp + "java generated xml file - version 3.xml"; 
		XmlWriter.writeXMLFile(xmlDataFilename);
		assertEquals(true, fileProcessor.fileExists(xmlDataFilename));
	}
	@Test
	public void validateJavaCreatedXml()
	{
		String xmlFilename = wp + "java generated xml file - version 3.xml"; 
		String xsdFilename = wp +  "milestone1.xsd";
		assertEquals(true, fileProcessor.xmlFileIsWellFormedAndValid(xmlFilename, xsdFilename));
	}
	@Test
	public void createSimplePdfDocument() 
	{
		String pdfFilename = wp + "java generated pdf file - version 1.pdf";
		pdfWriterPss.writePDF1(pdfFilename);
	}
	@Test
	public void test3() 
	{
		assertEquals("success", SUCCESS);
	}
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
}
