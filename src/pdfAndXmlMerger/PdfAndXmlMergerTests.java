package pdfAndXmlMerger;

import static org.junit.Assert.*;

import org.junit.Test;

public class PdfAndXmlMergerTests
{
String data_path = "C:\\Neighborhood\\Eclipse Workspace\\$UnderDevelopment\\src\\pdfAndXmlMerger\\Test Data\\";
//String web_data_path = serverURL + "pcarss/docs/";
//String serverURL = getApplicationBean().getResourceBean().getString("local.resource.url");

PdfAndXmlMerger pdfAndXmlMerger = new PdfAndXmlMerger();

@Test
public void test22()
{
	// Function Purpose: Test the BFO merge with a little more data.xml.
	// Creation Date: Nov-14-2016
	// Outcome: Worked.
	String templatePDFFilename = data_path + "boilerplate.pdf";
	String xmlDataFilename = data_path + "boilerplate.xml";
	String codeGeneratedPdfFilename = data_path + "boilerplate_merge.pdf";
	pdfAndXmlMerger.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
}
@Test
public void test23()
{
	// Function Purpose: Make the test use the new filename.
	// Creation Date: Nov-21-2016
	// Outcome: Worked.
	String templatePDFFilename = data_path + "Consolidated_Government_Furnished_Property.pdf";
	String xmlDataFilename = data_path + "boilerplate.xml";
	String codeGeneratedPdfFilename = data_path + "boilerplate_merge_2.pdf";
	pdfAndXmlMerger.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
}
@Test
public void test24()
{
	// Function Purpose: Create a completely populated PDF.
	// Creation Date: Nov-21-2016
	String templatePDFFilename = data_path + "Consolidated_Government_Furnished_Property.pdf";
	String xmlDataFilename = data_path + "completely_populated.xml";
	String codeGeneratedPdfFilename = data_path + "completely_populated_and_validated.pdf";
	pdfAndXmlMerger.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
}
@Test
public void latestMestmergerTest()
{
	// Function Purpose: Merge the java generated XML file.
	// Creation Date: Nov-22-2016
	String templatePDFFilename = data_path + "Consolidated_Government_Furnished_Property.pdf";
	String xmlDataFilename = data_path + "java generated xml file - version 8.xml";
	String codeGeneratedPdfFilename = data_path + "java_aided 8.pdf";
	pdfAndXmlMerger.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
}
@Test
public void generateXML() 
{
	String xmlDataFilename = data_path + "java generated xml file - version 10.xml"; 
	pdfAndXmlMerger.writeFullyPopulatedValidateableXMLFile(xmlDataFilename);
	assertEquals(true, pdfAndXmlMerger.fileExists(xmlDataFilename));
}
@Test
public void validateXML()
{
	String xmlFilename = data_path + "java generated xml file - version 10.xml"; 
	String xsdFilename = data_path + "milestone1.xsd";
	assertEquals(true, pdfAndXmlMerger.xmlFileIsWellFormedAndValid(xmlFilename, xsdFilename));
}
@Test
public void mergeXML()
{
	// Function Purpose: Merge the java generated XML file.
	// Creation Date: Nov-22-2016
	// This is the latest.
	String templatePDFFilename = data_path + "Consolidated_Government_Furnished_Property.pdf";
	String xmlDataFilename = data_path + "java generated xml file - version 10.xml";
	String codeGeneratedPdfFilename = data_path + "merge 10.pdf";
	pdfAndXmlMerger.createPdf4(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
}
@Test
public void generateXMLforWeb() 
{
	//String xmlDataFilename = web_data_path + "eda.xml"; 
	//pdfAndXmlMerger.writeFullyPopulatedValidateableXMLFile(xmlDataFilename);
	//assertEquals(true, pdfAndXmlMerger.fileExists(xmlDataFilename));
}
@Test
public void validateXMLforWeb()
{
//	String xmlFilename = web_data_path + "eda.xml"; 
//	String xsdFilename = web_data_path + "milestone1.xsd";
//	assertEquals(true, pdfAndXmlMerger.xmlFileIsWellFormedAndValid(xmlFilename, xsdFilename));
}
@Test
public void mergeXMLforWeb()
{
	// Function Purpose: Merge the java generated XML file.
	// Creation Date: Nov-23-2016
	// This is the latest.
	String templatePDFFilename = data_path + "Consolidated_Government_Furnished_Property.pdf";
	String xmlDataFilename = data_path + "java_generated.xml";
	String codeGeneratedPdfFilename = data_path + "electronic_design_automation_contract_transfer_form.pdf";
	pdfAndXmlMerger.createPdf4(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
}
}
