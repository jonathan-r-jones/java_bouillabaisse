package xmlOperations2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import XmlOperations.ReadFile;

public class WriteXMLFile_Test 
{
	ReadFile readFile = new ReadFile();
	WriteXMLFile writeXMLFile = new WriteXMLFile();
	String data_path = "C:\\Neighborhood\\Eclipse Workspace\\$UnderDevelopment\\src\\pdfAndXmlMerger\\Test Data\\";

	@Test
	public void test1() 
	{
		WriteXMLFile.writeXMLFileDemo();
	}
	@Test
	public void test2() 
	{
		// fp = Parameterize a new copied version of the write file method and then validate that the file exists.
		String xmlDataFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\java generated xml file - version 1.xml"; 
		WriteXMLFile.writeXMLFile2(xmlDataFilename);
		assertEquals(true, readFile.fileExists(xmlDataFilename));
	}
	@Test
	public void test3() 
	{
		// fp = Get the XML data to be more like what I need.
		String xmlDataFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\java generated xml file - version 2.xml"; 
		WriteXMLFile.writeXMLFile3(xmlDataFilename);
		assertEquals(true, readFile.fileExists(xmlDataFilename));
	}
	@Test
	public void validateDataTweaked()
	{
		// fp = Validate for confidence.
		String xmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\data tweaked.xml"; 
		String xsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\milestone1.xsd";
		assertEquals(true, readFile.xmlFileIsWellFormedAndValid(xmlFilename, xsdFilename));
	}
	@Test
	public void generateXML() 
	{
		// fp = Get all document information into the XML.
		String xmlDataFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\java generated xml file - version 3.xml"; 
		WriteXMLFile.writeXMLFile(xmlDataFilename);
		assertEquals(true, readFile.fileExists(xmlDataFilename));
	}
	@Test
	public void validateXml()
	{
		// fp = Validate as you go.
		String xmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\java generated xml file - version 3.xml"; 
		String xsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\milestone1.xsd";
		assertEquals(true, readFile.xmlFileIsWellFormedAndValid(xmlFilename, xsdFilename));
	}
	@Test
	public void validateXml2()
	{
		// fp = Validate as you go.
		String xmlFilename = data_path + "java generated xml file - version 5.xml"; 
		String xsdFilename = data_path + "milestone1.xsd";
		assertEquals(true, readFile.xmlFileIsWellFormedAndValid(xmlFilename, xsdFilename));
	}
	@Test
	public void generateXML2() 
	{
		// fp = Get all document information into the XML.
		String xmlDataFilename = data_path + "java generated xml file - version 5.xml"; 
		WriteXMLFile.writeFullyPopulatedValidateableXMLFile(xmlDataFilename);
		assertEquals(true, readFile.fileExists(xmlDataFilename));
	}
	@Test
	public void validateXmlOfCompPop()
	{
		// fp = Validate as you go.
		String xmlFilename = data_path + "completely_populated.xml"; 
		String xsdFilename = data_path + "milestone1.xsd";
		assertEquals(true, readFile.xmlFileIsWellFormedAndValid(xmlFilename, xsdFilename));
	}
	@Test
	public void validateBoilerplateXml()
	{
		// fp = Validate as you go.
		String xmlFilename = data_path + "boilerplate.xml"; 
		String xsdFilename = data_path + "milestone1.xsd";
		assertEquals(false, readFile.xmlFileIsWellFormedAndValid(xmlFilename, xsdFilename));
	}
	@Test
	public void addXfaTags()
	{
		// fcd: Nov-22-2016
		// This is the latest.
		String xmlFilename = data_path + "java generated xml file - version 5.xml"; 
		WriteXMLFile.addXfaTags2(xmlFilename);
	}
	@Test
	public void generateValidateableXML() 
	{
		String xmlDataFilename = data_path + "java generated xml file - version 8.xml"; 
		WriteXMLFile.writeFullyPopulatedValidateableXMLFile(xmlDataFilename);
		assertEquals(true, readFile.fileExists(xmlDataFilename));
	}
	@Test
	public void validate()
	{
		// fp = Validate as you go.
		String xmlFilename = data_path + "java generated xml file - version 8.xml"; 
		String xsdFilename = data_path + "milestone1.xsd";
		assertEquals(true, readFile.xmlFileIsWellFormedAndValid(xmlFilename, xsdFilename));
	}
	}
