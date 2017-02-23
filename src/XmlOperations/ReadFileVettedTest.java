package XmlOperations;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Test;
import org.xml.sax.SAXException;

import xmlOperations2.WriteXMLFile;

public class ReadFileVettedTest 
{
	ReadFile fileToRead = new ReadFile();
	@Test
	public void fileExists() 
	{
		assertEquals(true, fileToRead.fileExists("C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\a.txt"));
	}
	@Test
	public void readFirstCharacterInFile() 
	{
		assertEquals("H", fileToRead.getFirstCharatcerInFile("C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\Hello World.txt"));
	}
	@Test
	public void xmlFileIsWellFormedAndValid() throws ParserConfigurationException, SAXException, IOException 
	{
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xsd";
		assertEquals(true, fileToRead.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void validateNoDataXmlFile()
	{
		String fp = "36. Works with no data.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\works with data and no data xml files.xsd";
		assertEquals(true, fileToRead.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void validateDataXmlFile()
	{
		String fp = "36. Works with data.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\data.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\works with data and no data xml files.xsd";
		assertEquals(true, fileToRead.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void generateXML() 
	{
		// fp = Get all document information into the XML.
		String xmlDataFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\java generated xml file - version 3.xml"; 
		WriteXMLFile.writeXMLFile(xmlDataFilename);
		assertEquals(true, fileToRead.fileExists(xmlDataFilename));
	}
	@Test
	public void validateXml()
	{
		// fp = Validate as you go.
		String xmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\java generated xml file - version 3.xml"; 
		String xsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\milestone1.xsd";
		assertEquals(true, fileToRead.xmlFileIsWellFormedAndValid(xmlFilename, xsdFilename));
	}
}
